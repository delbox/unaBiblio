package com.biblioteca.unaBiblio.controllers;

import com.biblioteca.unaBiblio.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/prestamos")
    public ResponseEntity<?> generarReportePrestamos(
            @RequestParam String formato
    ) {
        try {
            byte[] reporte = reporteService.generarReportePrestamos(formato);

            String tipoContenido = formato.equalsIgnoreCase("excel")
                    ? "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
                    : "application/pdf";
            String nombreArchivo = "reporte_prestamos." + (formato.equalsIgnoreCase("excel") ? "xlsx" : "pdf");

            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" + nombreArchivo)
                    .contentType(MediaType.parseMediaType(tipoContenido))
                    .body(reporte);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al generar el reporte");
        }
    }
}

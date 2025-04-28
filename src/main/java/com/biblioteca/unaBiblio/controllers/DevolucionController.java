package com.biblioteca.unaBiblio.controllers;

import com.biblioteca.unaBiblio.models.DetallePrestamo;
import com.biblioteca.unaBiblio.models.Devolucion;
import com.biblioteca.unaBiblio.models.PrestamoLibro;
import com.biblioteca.unaBiblio.repositories.DetallePrestamoRepository;
import com.biblioteca.unaBiblio.repositories.DevolucionRepository;
import com.biblioteca.unaBiblio.repositories.PrestamoLibroRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionRepository devolucionRepository;

    @Autowired
    private PrestamoLibroRepository prestamoLibroRepository;
    
    @Autowired
    private DetallePrestamoRepository detallePrestamoRepository;
    
    @GetMapping("/all")
    public List<Devolucion> obtenerDevoluciones() {
    	return devolucionRepository.findAll();
    }
    
    
    @PostMapping("/{idPrestamo}/detalle/{idDetalle}")
    public ResponseEntity<?> crearDevolucion(@RequestBody Devolucion devolucion, 
                                             @PathVariable Integer idPrestamo,
                                             @PathVariable Integer idDetalle) {
        Optional<PrestamoLibro> prestamoLibro = prestamoLibroRepository.findById(idPrestamo);

        if (!prestamoLibro.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Préstamo no encontrado");
        }

        Optional<DetallePrestamo> detalleOpt = detallePrestamoRepository.findById(idDetalle);

        if (!detalleOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalle del préstamo no encontrado");
        }

        DetallePrestamo detalle = detalleOpt.get();

        // Registrar devolución
        devolucion.setDetalleprestamo(detalle);
        devolucion.setFechadevolucionreal(LocalDateTime.now());
        devolucion.setObservaciones(devolucion.getObservaciones());

        devolucionRepository.save(devolucion);


        return ResponseEntity.status(HttpStatus.CREATED).body(devolucion);
    }
}

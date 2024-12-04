package com.biblioteca.unaBiblio.controllers;

import com.biblioteca.unaBiblio.models.Libro;
import com.biblioteca.unaBiblio.services.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qr")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCode(@RequestBody Libro libro) throws Exception {
        // Convierte los datos del libro a JSON o texto
        String content = """
                {
                    "idlibro": %d,
                    "descripcion": "%s",
                    "autor": "%s",
                    "editorial": "%s",
                    "aniopublicacion": %d,
                    "estado": %b,
                    "idBiblioteca": %d
                }
                """.formatted(
                libro.getIdlibro(),
                libro.getDescripcion(),
                libro.getAutor(),
                libro.getEditorial(),
                libro.getAnioPublicacion(),
                libro.getEstado(),
                libro.getBiblioteca()
        );

        byte[] qrCode = qrCodeService.generateQRCode(content, 300, 300);

        // Devuelve la imagen como respuesta
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=qrCode.png")
                .contentType(MediaType.IMAGE_PNG)
                .body(qrCode);
    }
}


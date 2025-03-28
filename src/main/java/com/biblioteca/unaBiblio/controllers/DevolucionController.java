/*package com.biblioteca.unaBiblio.controllers;

import com.biblioteca.unaBiblio.models.Devolucion;
import com.biblioteca.unaBiblio.models.PrestamoLibro;
import com.biblioteca.unaBiblio.repositories.DevolucionRepository;
import com.biblioteca.unaBiblio.repositories.PrestamoLibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionRepository devolucionRepository;

    @Autowired
    private PrestamoLibroRepository prestamoLibroRepository;

    @PostMapping("/obtenerdevolucion/{idPrestamo}")
    public ResponseEntity<?> crearDevolucion(@RequestBody Devolucion devolucion, @PathVariable Integer idPrestamo) {
        Optional<PrestamoLibro> prestamoLibro = prestamoLibroRepository.findById(idPrestamo);

        if (!prestamoLibro.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Préstamo no encontrado");
        }

        PrestamoLibro prestamo = prestamoLibro.get();
        devolucion.setPrestamo(prestamo);
        Date fechaDevolucion = new Date();
        devolucion.setFechaDevolucion(fechaDevolucion);     
     
        devolucionRepository.save(devolucion);
        
        //Actualizar el estado del prestamo
        prestamo.setEstadoPrestamo("Finalizado");
        prestamoLibroRepository.save(prestamo);
       
        return ResponseEntity.status(HttpStatus.CREATED).body(devolucion);
    }
}
*/
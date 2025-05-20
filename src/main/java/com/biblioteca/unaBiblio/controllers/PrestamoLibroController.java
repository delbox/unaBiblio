package com.biblioteca.unaBiblio.controllers;


import com.biblioteca.unaBiblio.dto.PrestamoLibroDTO;
import com.biblioteca.unaBiblio.models.PrestamoLibro;
import com.biblioteca.unaBiblio.services.PrestamoLibroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/prestamo")
public class PrestamoLibroController {

	@Autowired
    private PrestamoLibroService prestamoLibroService;

    // Obtener todos los préstamos
    @GetMapping("/all")
    public List<PrestamoLibroDTO> getAllPrestamos() {
        return prestamoLibroService.getAllPrestamos();
    }
    
    @PostMapping("/crear")
    public ResponseEntity<PrestamoLibroDTO> agregarPrestamo(@RequestBody PrestamoLibroDTO prestamoLibroDTO) {
    	PrestamoLibroDTO nuevoPrestamo = prestamoLibroService.agregarPrestamo(prestamoLibroDTO);
    	return new ResponseEntity<>(nuevoPrestamo,HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable int id) {
        prestamoLibroService.eliminarPrestamo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<PrestamoLibro> obtenerPrestamoPorId(@PathVariable int id) {
        PrestamoLibro prestamoLibro = prestamoLibroService.obtenerPrestamoPorId(id);
        return ResponseEntity.ok(prestamoLibro);
    }
    
    
    
    /*@GetMapping("/historial/{idAlumno}")
    public ResponseEntity<?> obtenerHistorialPrestamo(@PathVariable int idAlumno) {
    	
    	try {
    		List<HistorialPrestamoDTO> historial = prestamoLibroService.obtenerHistorialPrestamoPorAlumno(idAlumno);

            if (historial.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron préstamos para el alumno");
            }

            return ResponseEntity.ok(historial);
    		
    	} catch(IllegalArgumentException e ) {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    	}
    	
        
    }*/

}

package com.biblioteca.unaBiblio.controllers;

import com.biblioteca.unaBiblio.dto.PrestamoLibroDTO;
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

}
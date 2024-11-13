package com.biblioteca.unaBiblio.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.biblioteca.unaBiblio.dto.BibliotecaDTO;
import com.biblioteca.unaBiblio.services.BibliotecaService;
//import jakarta.validation.Valid;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {
    
    @Autowired
    private BibliotecaService bibliotecaService;
    
    @GetMapping("/all")
    public List<BibliotecaDTO> getAllBibliotecas() {
        return bibliotecaService.getAllBibliotecas();
    }
    
    @PostMapping("/crear")
	public ResponseEntity<BibliotecaDTO> agregarBiblioteca(@RequestBody BibliotecaDTO bibliotecaDTO) {
		BibliotecaDTO nuevaBiblioteca = bibliotecaService.agregarBiblioteca(bibliotecaDTO);
		return new ResponseEntity<>(nuevaBiblioteca, HttpStatus.CREATED);
	}
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<BibliotecaDTO> actualizarBiblioteca(@PathVariable int id, @RequestBody BibliotecaDTO bibliotecaDTO) {
        BibliotecaDTO bibliotecaActualizada = bibliotecaService.actualizarBiblioteca(id, bibliotecaDTO);
        return new ResponseEntity<>(bibliotecaActualizada, HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarBiblioteca(@PathVariable int id) {
        bibliotecaService.eliminarBiblioteca(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
}

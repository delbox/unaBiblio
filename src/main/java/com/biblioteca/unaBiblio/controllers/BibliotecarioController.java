package com.biblioteca.unaBiblio.controllers;

import com.biblioteca.unaBiblio.dto.BibliotecarioDTO;
import com.biblioteca.unaBiblio.services.BibliotecarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bibliotecario")
public class BibliotecarioController {

    @Autowired
    private BibliotecarioService bibliotecarioService;
    
    @GetMapping("/all")
    public List<BibliotecarioDTO> getAllBibliotecarios() {
    	return bibliotecarioService.getAllBibliotecarios();
    }
    
    @PostMapping("/crear")
    public ResponseEntity<BibliotecarioDTO> agregarBibliotecario(@RequestBody BibliotecarioDTO bibliotecarioDTO) {
    	BibliotecarioDTO nuevoBibliotecario = bibliotecarioService.agregarBibliotecario(bibliotecarioDTO);
    	return new ResponseEntity<>(nuevoBibliotecario,HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<BibliotecarioDTO> actualizarBibliotecario(@PathVariable int id, @RequestBody BibliotecarioDTO bibliotecarioDTO) {
        BibliotecarioDTO bibliotecarioActualizado = bibliotecarioService.actualizarBibliotecario(id, bibliotecarioDTO);
        return new ResponseEntity<>(bibliotecarioActualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarBibliotecario(@PathVariable int id) {
        bibliotecarioService.eliminarBibliotecario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}

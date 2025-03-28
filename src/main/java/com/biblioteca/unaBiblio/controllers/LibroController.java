/*package com.biblioteca.unaBiblio.controllers;

import java.util.List;

import com.biblioteca.unaBiblio.dto.LibroDTO;
import com.biblioteca.unaBiblio.models.Libro;
import com.biblioteca.unaBiblio.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/all")
    public List<LibroDTO> getAllLibros() {
        return libroService.getAllLibros();
    }

    @PostMapping("/crear")
    public ResponseEntity<LibroDTO> agregarLibro(@RequestBody LibroDTO libroDTO) {
        LibroDTO nuevoLibro = libroService.agregarLibro(libroDTO);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<LibroDTO> actualizarLibro(@PathVariable int id, @RequestBody LibroDTO libroDTO) {
        LibroDTO libroActualizado = libroService.actualizarLibro(id, libroDTO);
        return new ResponseEntity<>(libroActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable int id) {
        libroService.eliminarLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
  //Agregar ruta de libro por id
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable int id) {
        Libro libro = libroService.obtenerLibroPorId(id);
        return ResponseEntity.ok(libro);
    }

}
*/
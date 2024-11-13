package com.biblioteca.unaBiblio.controllers;


import com.biblioteca.unaBiblio.dto.AlumnoDTO;
import com.biblioteca.unaBiblio.services.AlumnoService;

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
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;
    
    @GetMapping("/all")
    public List<AlumnoDTO> getAllAlumnos() {
    	return alumnoService.getAllAlumnos();
    }
    
    @PostMapping("/crear")
    public ResponseEntity<AlumnoDTO> agregarAlumno(@RequestBody AlumnoDTO alumnoDTO) {
    	AlumnoDTO nuevoAlumno = alumnoService.agregarAlumno(alumnoDTO);
    	return new ResponseEntity<>(nuevoAlumno,HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<AlumnoDTO> actualizarAlumno(@PathVariable int id, @RequestBody AlumnoDTO alumnoDTO) {
        AlumnoDTO alumnoActualizado = alumnoService.actualizarAlumno(id, alumnoDTO);
        return new ResponseEntity<>(alumnoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable int id) {
        alumnoService.eliminarAlumno(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
       
}   
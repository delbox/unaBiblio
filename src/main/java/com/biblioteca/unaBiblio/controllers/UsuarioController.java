package com.biblioteca.unaBiblio.controllers;




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

import com.biblioteca.unaBiblio.dto.UsuarioDTO;
import com.biblioteca.unaBiblio.models.Usuario;
import com.biblioteca.unaBiblio.services.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/all")
    public List<UsuarioDTO> getAllUsuarios() {
    	return usuarioService.getAllUsuarios();
    }
    
    @PostMapping("/crear")
    public ResponseEntity<UsuarioDTO> agregarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
    	UsuarioDTO nuevoUsuario = usuarioService.agregarUsuario(usuarioDTO);
    	return new ResponseEntity<>(nuevoUsuario,HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable int id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioActualizado = usuarioService.actualizarUsuario(id, usuarioDTO);
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/buscar-usuario/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable int id) {
        Usuario usuario = usuarioService.obtenerUsuarioAlumnoPorId(id);
        return ResponseEntity.ok(usuario);
    }
    
    //Agregar ruta de usuario por id
    @GetMapping("/buscar-alumno/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioAlumnoPorId(@PathVariable int id) {
        Usuario alumno = usuarioService.obtenerUsuarioAlumnoPorId(id);
        return ResponseEntity.ok(alumno);
    }

    @GetMapping("/buscar-bibliotecario/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioBibliotecarioPorId(@PathVariable int id) {
        Usuario bibliotecario = usuarioService.obtenerUsuarioBibliotecarioPorId(id);
        return ResponseEntity.ok(bibliotecario);
    }

}
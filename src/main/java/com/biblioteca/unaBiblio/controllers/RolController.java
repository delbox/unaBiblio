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

import com.biblioteca.unaBiblio.dto.RolDTO;
import com.biblioteca.unaBiblio.models.Rol;
import com.biblioteca.unaBiblio.services.RolService;






@RestController
@RequestMapping("/roles")
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	//Obtiene todos los roles de la BD
	@GetMapping("/all")
	public List<RolDTO> obtenerRoles() {
		return rolService.getAllRoles();
	}

	//Crea un rol en la base de datos
	@PostMapping("/crear")
	public ResponseEntity<RolDTO> agregarRol(@RequestBody RolDTO rolDTO) {
		RolDTO nuevoRol = rolService.agregarRol(rolDTO);
		return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar/{id}")
    public ResponseEntity<RolDTO> actualizarRol(@PathVariable int id, @RequestBody RolDTO rolDTO) {
        RolDTO rolActualizado = rolService.actualizarRol(id, rolDTO);
        return new ResponseEntity<>(rolActualizado, HttpStatus.OK);
    }
	
	@DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable int id) {
        rolService.eliminarRol(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	@GetMapping("/buscar/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable int id) {
        Rol rol = rolService.obtenerRolPorId(id);
        return ResponseEntity.ok(rol);
    }
}

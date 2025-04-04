package com.biblioteca.unaBiblio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.unaBiblio.dto.RolDTO;
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
		
}

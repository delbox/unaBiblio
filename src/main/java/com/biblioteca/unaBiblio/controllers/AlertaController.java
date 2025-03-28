/*package com.biblioteca.unaBiblio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.unaBiblio.dto.AlertaDTO;
import com.biblioteca.unaBiblio.services.AlertaService;




@RestController
@RequestMapping("/alerta")

public class AlertaController {
	
	@Autowired
	private AlertaService alertaService;
	
	@GetMapping("/all")
	public List<AlertaDTO> getAllAlertas() {
		return alertaService.getAllAlertas();
	}
	
	@PostMapping("/crear")
	public ResponseEntity<AlertaDTO> agregarAlerta(@RequestBody AlertaDTO alertaDTO) {
		AlertaDTO nuevaAlerta = alertaService.agregarAlerta(alertaDTO);
		return new ResponseEntity<>(nuevaAlerta,HttpStatus.CREATED);
	}
	
	
	
}
*/
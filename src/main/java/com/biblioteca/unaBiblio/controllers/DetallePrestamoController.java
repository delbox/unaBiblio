package com.biblioteca.unaBiblio.controllers;




import com.biblioteca.unaBiblio.dto.DetallePrestamoDTO;
import com.biblioteca.unaBiblio.models.DetallePrestamo;
import com.biblioteca.unaBiblio.repositories.DetallePrestamoRepository;
import com.biblioteca.unaBiblio.services.DetallePrestamoService;
import com.biblioteca.unaBiblio.services.PrestamoLibroService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/prestamo/detalle")
public class DetallePrestamoController {
	
	@Autowired
	private DetallePrestamoRepository detallePrestamoRepository;
	
	@Autowired
	private PrestamoLibroService prestamoLibroService;

	@Autowired
    private DetallePrestamoService detallePrestamoService;
	
	
    // Obtener todos los detalles
    @GetMapping("/all")
    public List<DetallePrestamoDTO> getAllDetalle() {
        return detallePrestamoService.getAllDetallePrestamo();
    }
    
    //crear el detalle del prestamo
    @PostMapping("/crear")
    public ResponseEntity<?> agregarDetalle(@RequestBody DetallePrestamoDTO detallePrestamoDTO) {
    	try {
    		DetallePrestamoDTO nuevoDetalle = detallePrestamoService.agregarDetalle(detallePrestamoDTO);
        	return new ResponseEntity<>(nuevoDetalle,HttpStatus.CREATED);
    	} catch (IllegalStateException e) {
    	    return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
    	} catch (RuntimeException e) {
    	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    	                         .body(Map.of("error", "Ocurrió un error inesperado."));
    	}
    }
    
    //Obtener detalle prestamo por id prestamo
    @GetMapping("/{idprestamo}")
    public List<DetallePrestamoDTO> obtenerDetallePorPrestamo(@PathVariable int idprestamo) {
    	
    	//Validar si existe el prestamo
    	prestamoLibroService.obtenerPrestamoPorId(idprestamo);
    	
    	//Si no lanza excepcion, seguimos con el detalle
    	List<DetallePrestamo> detalle = detallePrestamoRepository.findByPrestamo_Idprestamo(idprestamo);
    	
    	if(detalle.isEmpty()) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay detalles para este préstamo");
    	}
    	return detalle.stream()
    				.map(DetallePrestamoDTO::new)
    				.collect(Collectors.toList());
    }
    
}

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

import com.biblioteca.unaBiblio.dto.EjemplarDTO;
import com.biblioteca.unaBiblio.models.Ejemplar;
import com.biblioteca.unaBiblio.services.EjemplarService;





@RestController
@RequestMapping("/libro/ejemplar")
public class EjemplarController {
	
	@Autowired
	private EjemplarService ejemplarService;
	
	@GetMapping("/all")
	public List<EjemplarDTO> getAllEjemplares() {
		return ejemplarService.getAllEjemplares();
	}
	
	
	@PostMapping("/crear")
	public ResponseEntity<EjemplarDTO> agregarEjemplar(@RequestBody EjemplarDTO ejemplarDTO) {
		EjemplarDTO nuevoEjemplar = ejemplarService.agregarEjemplar(ejemplarDTO);
		return new ResponseEntity<>(nuevoEjemplar,HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar/{id}")
    public ResponseEntity<EjemplarDTO> actualizarEjemplar(@PathVariable int id, @RequestBody EjemplarDTO ejemplarDTO) {
        EjemplarDTO ejemplarActualizado = ejemplarService.actualizarEjemplar(id, ejemplarDTO);
        return new ResponseEntity<>(ejemplarActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEjemplar(@PathVariable int id) {
        ejemplarService.eliminarEjemplar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    //Obtener ejemplares disponibles por id libro
    @GetMapping("/disponibles/{idlibro}")
    public ResponseEntity<List<EjemplarDTO>> obtenerEjemplaresDisponibles(@PathVariable int idlibro) {
    	List<EjemplarDTO> ejemplares = ejemplarService.obtenerEjemplaresDisponiblesPorLibro(idlibro);
    	return ResponseEntity.ok(ejemplares);
    }
	
}


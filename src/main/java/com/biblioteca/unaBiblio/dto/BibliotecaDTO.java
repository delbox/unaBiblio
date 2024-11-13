package com.biblioteca.unaBiblio.dto;


import com.biblioteca.unaBiblio.models.Biblioteca;

//import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BibliotecaDTO {
	
	private int id_biblioteca;
	
	//@NotNull(mesage = "La facultad no puede ser nula")
    private String facultad;
    
    private Boolean estado;
    
    public BibliotecaDTO(Biblioteca biblioteca) {
    	this.id_biblioteca = biblioteca.getId_biblioteca();
    	this.facultad = biblioteca.getFacultad();
    	this.estado = biblioteca.getEstado();
    }
}
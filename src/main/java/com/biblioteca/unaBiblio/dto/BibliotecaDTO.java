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
	
	private int idbiblioteca;
	
	//@NotNull(mesage = "La facultad no puede ser nula")
    private String descripcion;
    
    private String direccion;
    
    private String telefono;
    
    private String email;
    
    private Boolean activo;
    
    public BibliotecaDTO(Biblioteca biblioteca) {
    	this.idbiblioteca = biblioteca.getIdbiblioteca();
    	this.descripcion = biblioteca.getDescripcion();
    	this.direccion = biblioteca.getDireccion();
    	this.telefono = biblioteca.getTelefono();
    	this.email = biblioteca.getEmail();
    	this.activo = biblioteca.getActivo();
    }
}
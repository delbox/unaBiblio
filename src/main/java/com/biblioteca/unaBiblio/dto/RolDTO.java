package com.biblioteca.unaBiblio.dto;

import com.biblioteca.unaBiblio.models.Rol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolDTO {
	private int idrol;
	private String descripcion;
	
	
	public RolDTO(Rol rol) {
		this.idrol = rol.getIdrol();
		this.descripcion = rol.getDescripcion();
	}
}

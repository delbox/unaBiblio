package com.biblioteca.unaBiblio.dto;

import com.biblioteca.unaBiblio.models.DetallePrestamo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetallePrestamoDTO {
	
	private int coddetalle;
	private int idejemplar;
	private Boolean activo;
	private int idprestamo;
	
	public DetallePrestamoDTO(DetallePrestamo detallePrestamo) {
		this.coddetalle = detallePrestamo.getCoddetalle();
		this.idejemplar = detallePrestamo.getEjemplar().getIdejemplar();
		this.activo = detallePrestamo.getActivo();
		this.idprestamo = detallePrestamo.getPrestamo().getIdprestamo();
	}
}

package com.biblioteca.unaBiblio.dto;

import com.biblioteca.unaBiblio.models.DetallePrestamo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
public class DetallePrestamoDTO {
	
	private int coddetalle;
	private int idejemplar;
	private Boolean activo;
	
	/*private EjemplarDTO ejemplar;
	private PrestamoLibroDTO prestamoLibro;*/
	
	//Campos para mostrar
	private String nombreLibro;
	
	//Devolucion
	private DevolucionDTO devolucion;
	
	public DetallePrestamoDTO() {}
	
	public DetallePrestamoDTO(DetallePrestamo detallePrestamo) {
		this.coddetalle = detallePrestamo.getCoddetalle();
		this.idejemplar = detallePrestamo.getEjemplar().getIdejemplar();
		this.activo = detallePrestamo.getActivo();
		
		/*this.ejemplar = new EjemplarDTO(detallePrestamo.getEjemplar());
		this.prestamoLibro = new PrestamoLibroDTO(detallePrestamo.getPrestamo());*/
		
		this.nombreLibro = detallePrestamo.getEjemplar().getLibro().getTitulo();
		
		/*if (detallePrestamo.getDevolucion() != null) {
			this.devolucion = new DevolucionDTO(detallePrestamo.getDevolucion());
		}*/
	}
}

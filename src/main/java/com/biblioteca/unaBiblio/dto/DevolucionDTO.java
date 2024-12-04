package com.biblioteca.unaBiblio.dto;

import java.util.Date;

import com.biblioteca.unaBiblio.models.Devolucion;

public class DevolucionDTO {
	
	private int idDevolucion;
	private Date fechaDevolucion;
	private String observaciones;
	private int idPrestamo;
	
	
	
	public DevolucionDTO(Devolucion devolucionLibro) {
		this.idDevolucion = devolucionLibro.getIdDevolucion();
		this.fechaDevolucion = devolucionLibro.getFechaDevolucion();
		this.observaciones = devolucionLibro.getObservaciones();
		
		this.idPrestamo = devolucionLibro.getPrestamo().getIdPrestamo();
		
	}
}

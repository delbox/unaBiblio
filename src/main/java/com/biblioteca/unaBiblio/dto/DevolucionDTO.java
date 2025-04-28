package com.biblioteca.unaBiblio.dto;


import java.time.LocalDateTime;


import com.biblioteca.unaBiblio.models.Devolucion;

public class DevolucionDTO {
	
	private int iddevolucion;
	private int iddetalle;
	private LocalDateTime fechadevolucionreal;
	private String observaciones;
	
	
	
	public DevolucionDTO(Devolucion devolucion) {
		this.iddevolucion = devolucion.getIddevolucion();
		this.iddetalle = devolucion.getDetalleprestamo().getCoddetalle();
		this.fechadevolucionreal = devolucion.getFechadevolucionreal();
		this.observaciones = devolucion.getObservaciones();
		
	}
}

/*package com.biblioteca.unaBiblio.dto;

import java.util.Date;

import com.biblioteca.unaBiblio.models.PrestamoLibro;



public class HistorialPrestamoDTO {
    private int idPrestamo;
    private String estadoPrestamo;
    private Date fechaPrestamo;
    private Date fechaEstimadaDevolucion;
    private String observaciones;
    private String nombreLibro;

    // Constructor que toma un objeto PrestamoLibro
    public HistorialPrestamoDTO(PrestamoLibro prestamo) {
        this.idPrestamo = prestamo.getIdPrestamo();
        this.estadoPrestamo = prestamo.getEstadoPrestamo();
        this.fechaPrestamo = prestamo.getFechaPrestamo();
        this.fechaEstimadaDevolucion = prestamo.getFechaEstimadaDevolucion();
        this.observaciones = prestamo.getObservaciones();
        
        // Si el libro está relacionado, trae su descripción
        this.nombreLibro = prestamo.getLibro() != null ? prestamo.getLibro().getDescripcion() : "Sin información";
    }

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public String getEstadoPrestamo() {
		return estadoPrestamo;
	}

	public void setEstadoPrestamo(String estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaEstimadaDevolucion() {
		return fechaEstimadaDevolucion;
	}

	public void setFechaEstimadaDevolucion(Date fechaEstimadaDevolucion) {
		this.fechaEstimadaDevolucion = fechaEstimadaDevolucion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getNombreLibro() {
		return nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}
    
    
    
}
*/

package com.biblioteca.unaBiblio.dto;

import java.util.Date;

import com.biblioteca.unaBiblio.models.PrestamoLibro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoLibroDTO {
    private int idPrestamo;
    private Date fechaPrestamo;
    private Date fechaEstimadaDevolucion;
    private String estadoPrestamo;
    private String observaciones;
    private int idAlumno;
    private int idLibro;
    private int idBibliotecario;
    private String nombreLibro;
    private String nombreCompletoAlumno;
    private String nombreCompletoBibliotecario;
    
    

    public PrestamoLibroDTO(PrestamoLibro prestamoLibro) {
        this.idPrestamo =  prestamoLibro.getIdPrestamo();
        this.fechaPrestamo = prestamoLibro.getFechaPrestamo();
        this.fechaEstimadaDevolucion = prestamoLibro.getFechaEstimadaDevolucion();
        this.estadoPrestamo = prestamoLibro.getEstadoPrestamo();
        this.observaciones =  prestamoLibro.getObservaciones();

        this.idBibliotecario = prestamoLibro.getBibliotecario().getIdusuario();
        this.idAlumno = prestamoLibro.getAlumno().getIdusuario();
        this.idLibro = prestamoLibro.getLibro().getIdlibro();
        
        this.nombreLibro = prestamoLibro.getLibro().getDescripcion();
        this.nombreCompletoAlumno = prestamoLibro.getAlumno().getNombre() + " " + prestamoLibro.getAlumno().getApellido();
        this.nombreCompletoBibliotecario = prestamoLibro.getBibliotecario().getNombre() + " " + prestamoLibro.getBibliotecario().getApellido();
    }
}

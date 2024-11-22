/*package com.biblioteca.unaBiblio.dto;

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
    private Date fechaDevolucion;
    private String estadoPrestamo;
    private String observaciones;
    private int idAlumno;
    private int idLibro;
    private int idBibliotecario;

    public PrestamoLibroDTO(PrestamoLibro prestamoLibro) {
        this.idPrestamo =  prestamoLibro.getIdPrestamo();
        this.fechaPrestamo = prestamoLibro.getFechaPrestamo();
        this.fechaDevolucion = prestamoLibro.getFechaDevolucion();
        this.estadoPrestamo = prestamoLibro.getEstadoPrestamo();
        this.observaciones =  prestamoLibro.getObservaciones();
        
        this.idAlumno = prestamoLibro.getAlumno().getIdAlumno();
        this.idLibro = prestamoLibro.getLibro().getIdLibro();
        this.idBibliotecario = prestamoLibro.getBibliotecario().getIdBibliotecario();
    }
}*/

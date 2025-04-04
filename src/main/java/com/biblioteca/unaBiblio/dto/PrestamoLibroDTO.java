package com.biblioteca.unaBiblio.dto;


import java.time.LocalDateTime;

import com.biblioteca.unaBiblio.models.EstadoPrestamo;
import com.biblioteca.unaBiblio.models.PrestamoLibro;
import com.biblioteca.unaBiblio.models.TipoPrestamo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoLibroDTO {
    private int idprestamo;
    private LocalDateTime fechaprestamo;
    private TipoPrestamo tipoprestamo;
    private LocalDateTime fechaestimadadevolucion;
    private EstadoPrestamo estadoprestamo;
    private int idalumno;
    private int idusuario;
    private int idbiblioteca;
    
    private String nombreCompletoAlumno;
    private String nombreCompletoUsuario;
    
    

    public PrestamoLibroDTO(PrestamoLibro prestamoLibro) {
        this.idprestamo =  prestamoLibro.getIdprestamo();
        this.fechaprestamo = prestamoLibro.getFechaprestamo();
        this.tipoprestamo = prestamoLibro.getTipoprestamo();
        this.fechaestimadadevolucion = prestamoLibro.getFechaestimadadevolucion();
        this.estadoprestamo = prestamoLibro.getEstadoprestamo();

        this.idalumno = prestamoLibro.getAlumno().getIdalumno();
        this.idusuario = prestamoLibro.getUsuario().getIdusuario();
        this.idbiblioteca = prestamoLibro.getBiblioteca().getIdbiblioteca();
        
        this.nombreCompletoAlumno = prestamoLibro.getAlumno().getNombre() + " " + prestamoLibro.getAlumno().getApellido();
        this.nombreCompletoUsuario = prestamoLibro.getUsuario().getNombre() + " " + prestamoLibro.getUsuario().getApellido();
    }
}

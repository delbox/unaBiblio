package com.biblioteca.unaBiblio.dto;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.biblioteca.unaBiblio.models.EstadoPrestamo;
import com.biblioteca.unaBiblio.models.PrestamoLibro;
import com.biblioteca.unaBiblio.models.TipoPrestamo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
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
    
    //Lista de detalles del prestamo
    @Builder.Default
    private List<DetallePrestamoDTO> detalles;
    
  /*Traer el cuerpo completo de los campos relacionados
    private AlumnoDTO alumno;
    private UsuarioDTO usuario;
    private BibliotecaDTO biblioteca;*/
    
    private String nombreCompletoAlumno;
    private String nombreCompletoUsuario;
    
    //Constructor vacio
    public PrestamoLibroDTO() {}
    
    //Constructor desde entidad PrestamoLibro
    public PrestamoLibroDTO(PrestamoLibro prestamoLibro) {
        this.idprestamo =  prestamoLibro.getIdprestamo();
        this.fechaprestamo = prestamoLibro.getFechaprestamo();
        this.tipoprestamo = prestamoLibro.getTipoprestamo();
        this.fechaestimadadevolucion = prestamoLibro.getFechaestimadadevolucion();
        this.estadoprestamo = prestamoLibro.getEstadoprestamo();

        this.idalumno = prestamoLibro.getAlumno().getIdalumno();
        this.idusuario = prestamoLibro.getUsuario().getIdusuario();
        this.idbiblioteca = prestamoLibro.getBiblioteca().getIdbiblioteca();
        
        /*this.alumno = new AlumnoDTO(prestamoLibro.getAlumno());
        this.usuario = new UsuarioDTO(prestamoLibro.getUsuario());
        this.biblioteca = new BibliotecaDTO(prestamoLibro.getBiblioteca());*/
        
        this.nombreCompletoAlumno = prestamoLibro.getAlumno().getNombre() + " " + prestamoLibro.getAlumno().getApellido();
        this.nombreCompletoUsuario = prestamoLibro.getUsuario().getNombre() + " " + prestamoLibro.getUsuario().getApellido();
        
        //Convertir detalles a DTO
        this.detalles = prestamoLibro.getDetalles().stream()
        				.map(DetallePrestamoDTO::new)
        				.collect(Collectors.toList());
        		
    }
}

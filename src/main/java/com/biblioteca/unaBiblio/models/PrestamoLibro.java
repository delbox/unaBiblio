package com.biblioteca.unaBiblio.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prestamo_libro")
public class PrestamoLibro {
	
	//Definicion de los campos de Biblioteca
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prestamo", nullable = false)
	private int idPrestamo;
	
	@Column(name="fecha_prestamo", length = 200)
	private Date fechaPrestamo;
	
	@Column(name="fecha_devolucion")
	private Date fechaDevolucion;

    @Column(name="estado_prestamo")
    private String estadoPrestamo;

    @Column(name="observaciones")
    private String observaciones;
    
    @ManyToOne
    @JoinColumn(name="id_bibliotecario", nullable = false)
    private Usuario bibliotecario;

    @ManyToOne
    @JoinColumn(name="id_alumno", nullable = false)
    private Usuario alumno;
    
    @ManyToOne
    @JoinColumn(name="id_libro", nullable = false)
    private Libro libro;
	
}

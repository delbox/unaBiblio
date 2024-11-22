/*package com.biblioteca.unaBiblio.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;

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
    @JoinColumn(name="id_alumno", nullable = false)
    private Alumno alumno;
    
    @ManyToOne
    @JoinColumn(name="id_libro", nullable = false)
    private Libro libro;
    
    @ManyToOne
    @JoinColumn(name="id_bibliotecario", nullable = false)
    private Bibliotecario bibliotecario;
	
}*/

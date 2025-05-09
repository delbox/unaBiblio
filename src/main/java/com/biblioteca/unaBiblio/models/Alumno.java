package com.biblioteca.unaBiblio.models;


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


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "alumnos")

public class Alumno {
	
	//Definicion de los campos de Alumno
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_alumno", nullable = false)
	private int idalumno;
	
	@Builder.Default
	@Column(name = "activo", nullable = false)
	private Boolean activo = true;

	@Column(name="nombre", length = 200, nullable = false)
	private String nombre;
	
	@Column(name="apellido", length = 200, nullable = false)
	private String apellido;
	
	@Column(name="cedula", length = 20, unique = true)
	private String cedula;
	
	@Column(name="email", length = 100, nullable = false)
	private String email;
	
	@Column(name="telefono", length = 20, nullable = false)
	private String telefono;

    @ManyToOne
    @JoinColumn(name="id_biblioteca", nullable = false)
    private Biblioteca biblioteca;
    
}

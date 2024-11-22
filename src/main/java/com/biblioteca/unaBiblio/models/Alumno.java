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
	private int idAlumno;
	
	@Column(name="nombre_apellido", length= 200)
	private String nombreApellido;
	
	@ManyToOne
    @JoinColumn(name="id_biblioteca", nullable = false)
    private Biblioteca biblioteca;
	
	@ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario usuario;
}*/

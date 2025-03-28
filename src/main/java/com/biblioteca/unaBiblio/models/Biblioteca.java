package com.biblioteca.unaBiblio.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "bibliotecas")
public class Biblioteca {
	
	//Definicion de los campos de Biblioteca
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idbiblioteca", nullable = false)
	private int idbiblioteca;
	
	
	@Column(name = "descripcion", length = 200, nullable = false)
	private String descripcion;
	
	
	@Column(name = "estado", nullable = false)
	private Boolean estado;
	
}




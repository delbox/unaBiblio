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
	@Column(name = "id_biblioteca", nullable = false)
	private int idbiblioteca;
	
	@Column(name = "descripcion", length = 200, nullable = false)
	private String descripcion;
	
	@Column(name = "direccion", length = 200, nullable = false)
	private String direccion;
	
	@Column(name = "telefono", length = 50, nullable = false)
	private String telefono;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@Column(name = "activo", nullable = false)
	private Boolean activo;
	
}




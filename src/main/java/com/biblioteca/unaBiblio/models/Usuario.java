/*package com.biblioteca.unaBiblio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "usuarios")
public class Usuario {
	
	//Definicion de los campos de Usuario
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario", nullable = false)
	private int idusuario;
	
	@Column(name = "nombre", length = 100)
	private String nombre;
	
	@Column(name = "apellido", length = 100)
	private String apellido;
	
	@Column(name = "usuario", length = 100)
	private String usuario;
	
	@Column(name = "password", length = 50)
	private String password;
	
	@Enumerated(EnumType.STRING)
    private Rol rol;
	
	@Builder.Default
	@Column(name = "estado", nullable = false)
	private Boolean estado = true;
	
	@Column(name = "cedula", length = 20)
	private String cedula;
	
}*/

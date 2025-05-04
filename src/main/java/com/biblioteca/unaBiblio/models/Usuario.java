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
@Table(name = "usuarios")
public class Usuario {
	
	//Definicion de los campos de Usuario
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", nullable = false)
	private int idusuario;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "apellido", length = 100, nullable = false)
	private String apellido;
	
	@Column(name="cedula", length = 20, unique = true, nullable = false)
	private String cedula;
	
	@Column(name = "usuario", length = 100, nullable = false, unique = true)
	private String usuario;
	
	@Column(name = "password", length = 200, nullable = false)
	private String password;
	
	@Builder.Default
	@Column(name = "activo", nullable = false)
	private Boolean activo = true;
	
	//Relacion con la tabla roles
	@ManyToOne
	@JoinColumn(name= "id_rol", nullable = false)
	private Rol rol;
	
}

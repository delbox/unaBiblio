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
@Table(name = "bibliotecarios")

public class Bibliotecario {
	
	//Definicion de los campos de Biblioteca
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_bibliotecario", nullable = false)
	private int idBibliotecario;

	@Column(name="nombre_apellido", length = 200)
	private String nombreApellido;

    @Column(name="cargo", length = 200)
	private String cargo;
    
    @ManyToOne
    @JoinColumn(name="id_biblioteca", nullable = false)
    private Biblioteca biblioteca;
	
	@ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario usuario;
	
}

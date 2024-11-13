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
@Table(name = "libros")
public class Libro {
	
	//Definicion de los campos de Libro
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro", nullable = false)
	private int idLibro;
	
	@Column(name="nombre_libro", length = 200)
	private String nombreLibro;
	
    @Column(name="autor", length = 200)
	private String autor;

    @Column(name="editorial", length = 200)
	private String editorial;

    @Column(name="anio_publicacion", length = 10)
	private int anioPublicacion;
    
    //Clave foranea a la tabla de bibliotecas
    @ManyToOne
    @JoinColumn(name="id_biblioteca", nullable = false)
    private Biblioteca biblioteca;
}

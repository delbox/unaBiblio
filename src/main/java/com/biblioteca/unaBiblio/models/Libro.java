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
@Table(name = "libros")
public class Libro {
	
	//Definicion de los campos de Libro
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro", nullable = false)
	private int idlibro;
	
	@Column(name="titulo", length = 200, nullable = false)
	private String titulo;
	
    @Column(name="autor", length = 200, nullable = false)
	private String autor;

    @Column(name="editorial", length = 200, nullable = false)
	private String editorial;

    @Column(name="anio_publicacion", length = 10)
	private int aniopublicacion;
    
    @Column(name="isbn", length = 200, unique = true)
    private String isbn;
    
    /*@Column(name="codigoqr", length = 50)
    private String codigoQr;
    
    @Column(name = "estado", nullable = false)
	private Boolean estado;
    
    
    //Clave foranea a la tabla de bibliotecas
    @ManyToOne
    @JoinColumn(name="idbiblioteca", nullable = false)
    private Biblioteca biblioteca;*/
}

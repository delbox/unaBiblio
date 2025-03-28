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
@Table(name = "libros")
public class Libro {
	
	//Definicion de los campos de Libro
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idlibro", nullable = false)
	private int idlibro;
	
	@Column(name="descripcion", length = 200)
	private String descripcion;
	
    @Column(name="autor", length = 200)
	private String autor;

    @Column(name="editorial", length = 200)
	private String editorial;

    @Column(name="aniopublicacion", length = 10)
	private int anioPublicacion;
    
    @Column(name="codigoqr", length = 50)
    private String codigoQr;
    
    @Column(name = "estado", nullable = false)
	private Boolean estado;
    
    
    //Clave foranea a la tabla de bibliotecas
    @ManyToOne
    @JoinColumn(name="idbiblioteca", nullable = false)
    private Biblioteca biblioteca;
}*/

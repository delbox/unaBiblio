package com.biblioteca.unaBiblio.models;



import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "ejemplares")
public class Ejemplar {
	
	//Definicion de los campos de Biblioteca
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ejemplar", nullable = false)
	private int idejemplar;
	
	@Column(name = "codigo", length = 200, nullable = false, unique = true)
	private String codigo;
	
	@Enumerated(EnumType.STRING) //Guarda el enum como String en la BD
	@Column(name = "estado", length = 200, nullable = false)
	private EstadoEjemplar estado;
	
	@ManyToOne
    @JoinColumn(name="id_libro", nullable = false)
    private Libro libro;
	
}

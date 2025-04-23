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
@Table(name = "stock_biblioteca")
public class Stock {
	
	//Definicion de los campos de Biblioteca
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_stock", nullable = false)
	private int codstock;
		
	@ManyToOne
    @JoinColumn(name="id_libro", nullable = false)
    private Libro libro;
	
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	
	@ManyToOne
    @JoinColumn(name="id_biblioteca", nullable = false)
    private Biblioteca biblioteca;
	
}

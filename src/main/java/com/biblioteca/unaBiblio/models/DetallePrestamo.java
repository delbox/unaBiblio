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
@Table(name = "detalle_prestamo")
public class DetallePrestamo {
	
	//Definicion de los campos de Biblioteca
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle", nullable = false)
	private int coddetalle;
		
	@ManyToOne
    @JoinColumn(name="id_ejemplar", nullable = false)
    private Ejemplar ejemplar;
	
	@Builder.Default
	@Column(name = "activo", nullable = false)
	private Boolean activo = true;
	
	@ManyToOne
    @JoinColumn(name="id_prestamo", nullable = false)
    private PrestamoLibro prestamo;
	
}

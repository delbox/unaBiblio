package com.biblioteca.unaBiblio.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "devoluciones")
public class Devolucion {
	
	//Definicion de los campos de devolucion
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_devolucion", nullable = false)
	private int iddevolucion;
	
	@OneToOne
	@JoinColumn(name = "id_detalle", referencedColumnName = "id_detalle", nullable = false, unique = true)
	private DetallePrestamo detalleprestamo;
	
	
	@Column(name="fecha_devolucion_real", nullable = false)
	private LocalDateTime fechadevolucionreal;

    @Column(name="observaciones", length = 200)
    private String observaciones;
	
}

package com.biblioteca.unaBiblio.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;


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
	private int idDevolucion;
	
	@Column(name="fecha_devolucion", length = 200)
	private Date fechaDevolucion;

    @Column(name="observaciones")
    private String observaciones;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="id_prestamo", nullable = false)
    @JsonBackReference // Evita la serialización de Prestamo al serializar Devolucion
    private PrestamoLibro prestamo;
	
}

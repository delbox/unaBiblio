package com.biblioteca.unaBiblio.models;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alertas")

public class Alerta {
	//Definicion de los campos de Alertas
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "idalerta", nullable = false)
		private int idAlerta;
		
		@Column(name = "fechacreacion")
		//@Temporal(TemporalType.DATE)
	    private LocalDate fechaCreacion;
		
		@Column(name = "fechaatencion")
		//@Temporal(TemporalType.DATE)
	    private LocalDate fechaAtencion;
		
		@Column(name="codigoqr", length = 50)
	    private String codigoQr;
		
		@Column(name="descripcion", length = 200)
		private String descripcion;
		
		@Column(name = "estado", nullable = false)
		private Boolean estado;
		
	    //Clave foranea a la tabla de bibliotecas
	    @ManyToOne
	    @JoinColumn(name="idbiblioteca", nullable = false)
	    private Biblioteca biblioteca;
	    
	    @ManyToOne
	    @JoinColumn(name="idusuario", nullable = false)
	    private Usuario usuario;
}

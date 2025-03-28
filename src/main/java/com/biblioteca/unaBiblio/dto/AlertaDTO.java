/*package com.biblioteca.unaBiblio.dto;


import java.time.LocalDate;

import java.util.Date;

import com.biblioteca.unaBiblio.models.Alerta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlertaDTO {
	
	private int idAlerta;
    private LocalDate fechaCreacion;
    private LocalDate fechaAtencion;
    private String codigoQr;
    private String descripcion;
    private Boolean estado;
    private int idBiblioteca;
    private int idUsuario;
    
         
  
    public AlertaDTO(Alerta alerta) {  	
    	
        this.idAlerta = alerta.getIdAlerta();
        this.fechaCreacion = alerta.getFechaCreacion();
        this.fechaAtencion = alerta.getFechaAtencion();
        this.codigoQr = alerta.getCodigoQr();
        this.descripcion = alerta.getDescripcion();
        this.estado = alerta.getEstado();
        this.idBiblioteca = alerta.getBiblioteca().getIdbiblioteca();
        this.idUsuario = alerta.getUsuario().getIdusuario();
    }




}
*/
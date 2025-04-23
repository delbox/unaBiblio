package com.biblioteca.unaBiblio.dto;

import com.biblioteca.unaBiblio.models.Stock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
	
	private int codstock;
	private int idlibro;
	private int cantidad;
	private int idbiblioteca;
	
	public StockDTO(Stock stock) {
		this.codstock = stock.getCodstock();
		this.idlibro = stock.getLibro().getIdlibro();
		this.cantidad = stock.getCantidad();
		this.idbiblioteca = stock.getBiblioteca().getIdbiblioteca();
	}
}

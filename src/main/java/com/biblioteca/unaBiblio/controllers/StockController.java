package com.biblioteca.unaBiblio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.unaBiblio.dto.StockDTO;
import com.biblioteca.unaBiblio.models.Stock;
import com.biblioteca.unaBiblio.services.StockService;




@RestController
@RequestMapping("/libro/stock")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@GetMapping("/all")
	public List<StockDTO> getAllStock() {
		return stockService.getAllStock();
	}
	
	@PostMapping()
	public Stock crearStock(@RequestBody StockDTO stockDTO) {
		return stockService.agregarStock(stockDTO);
	}
}

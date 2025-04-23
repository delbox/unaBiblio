package com.biblioteca.unaBiblio.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.unaBiblio.dto.StockDTO;
import com.biblioteca.unaBiblio.models.Biblioteca;
import com.biblioteca.unaBiblio.models.Libro;
import com.biblioteca.unaBiblio.models.Stock;
import com.biblioteca.unaBiblio.repositories.BibliotecaRepository;
import com.biblioteca.unaBiblio.repositories.EjemplarRepository;
import com.biblioteca.unaBiblio.repositories.LibroRepository;
import com.biblioteca.unaBiblio.repositories.StockRepository;




@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired 
	private LibroRepository libroRepository;
	
	@Autowired 
	private BibliotecaRepository bibliotecaRepository;
	
	@Autowired
	private EjemplarRepository ejemplarRepository;
	
	public List<StockDTO> getAllStock() {
		List<Stock> stocks = stockRepository.findAll();
		return stocks.stream()
			   .map(s -> new StockDTO(s.getCodstock(),s.getLibro().getIdlibro(),s.getCantidad(),s.getBiblioteca().getIdbiblioteca()))
			   .collect(Collectors.toList());
	}
	
	public Stock agregarStock(StockDTO stockDTO) {
		Libro libro = libroRepository.findById(stockDTO.getIdlibro())
					.orElseThrow(() -> new RuntimeException("Libro no encontrado"));
		
		Biblioteca biblioteca = bibliotecaRepository.findById(stockDTO.getIdbiblioteca())
					.orElseThrow(() -> new RuntimeException("Biblioteca no encontrada"));
		
		//Verificar si ya existe stock para ese libro y biblioteca
		Optional<Stock> stockExistente = stockRepository.findByLibroAndBiblioteca(libro, biblioteca);
		if( stockExistente.isPresent()) {
			throw new RuntimeException("Ya existe un stock registrado para este libro en esta biblioteca");
		}
					
		//Contar la cantidad de ejemplares del libro en esa biblioteca
		int cantidad = ejemplarRepository.countByLibroAndBiblioteca(libro,biblioteca);
		
		Stock stock = Stock.builder()
			  .libro(libro)
			  .biblioteca(biblioteca)
			  .cantidad(cantidad)
			  .build();
		
		return stockRepository.save(stock);
	}
}

package com.biblioteca.unaBiblio.repositories;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.unaBiblio.models.Biblioteca;
import com.biblioteca.unaBiblio.models.Libro;
import com.biblioteca.unaBiblio.models.Stock;




@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {
	Optional<Stock> findByLibroAndBiblioteca(Libro libro, Biblioteca biblioteca);
	
	Optional<Stock> findByLibro_IdlibroAndBiblioteca_Idbiblioteca(int idLibro, int idBiblioteca);
}

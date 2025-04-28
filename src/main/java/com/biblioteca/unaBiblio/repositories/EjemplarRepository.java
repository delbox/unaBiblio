package com.biblioteca.unaBiblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.unaBiblio.models.Biblioteca;
import com.biblioteca.unaBiblio.models.Ejemplar;
import com.biblioteca.unaBiblio.models.EstadoEjemplar;
import com.biblioteca.unaBiblio.models.Libro;





@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar,Integer> {
	int countByLibroAndBiblioteca(Libro libro, Biblioteca biblioteca);
	
	int countByLibroAndBibliotecaAndEstado(Libro libro, Biblioteca biblioteca, EstadoEjemplar estado);
}

package com.biblioteca.unaBiblio.repositories;

import java.util.List;

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
	
	//Ejemplares disponibles por id libro
	List<Ejemplar> findByLibro_IdlibroAndEstadoOrderByIdejemplarAsc(int idLibro, EstadoEjemplar estado);
	
	//Ejemplares por id libro
	List<Ejemplar> findByLibro_Idlibro(int idLibro);
}

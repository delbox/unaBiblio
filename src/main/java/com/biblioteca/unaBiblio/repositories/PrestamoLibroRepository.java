package com.biblioteca.unaBiblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.unaBiblio.models.PrestamoLibro;



@Repository
public interface PrestamoLibroRepository extends JpaRepository<PrestamoLibro,Integer> {
	
}




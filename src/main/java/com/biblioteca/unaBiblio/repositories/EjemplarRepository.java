package com.biblioteca.unaBiblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.unaBiblio.models.Ejemplar;



@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar,Integer> {
	
}

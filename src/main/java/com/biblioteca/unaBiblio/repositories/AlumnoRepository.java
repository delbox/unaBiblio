package com.biblioteca.unaBiblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.unaBiblio.models.Alumno;



@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {
	
}




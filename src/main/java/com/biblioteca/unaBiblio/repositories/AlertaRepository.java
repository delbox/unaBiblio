package com.biblioteca.unaBiblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.unaBiblio.models.Alerta;



@Repository
public interface AlertaRepository extends JpaRepository<Alerta,Integer> {
	
}

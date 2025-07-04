package com.biblioteca.unaBiblio.repositories;

import com.biblioteca.unaBiblio.models.Devolucion;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DevolucionRepository extends JpaRepository<Devolucion, Integer> {
	
	Optional<Devolucion> findByDetalleprestamoCoddetalle(Integer coddetalle);
}









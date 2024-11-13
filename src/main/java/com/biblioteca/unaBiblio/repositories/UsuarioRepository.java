package com.biblioteca.unaBiblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.unaBiblio.models.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
	
}

/*package com.biblioteca.unaBiblio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.biblioteca.unaBiblio.models.PrestamoLibro;




@Repository
public interface PrestamoLibroRepository extends JpaRepository<PrestamoLibro,Integer> {
	
	@Query("SELECT p FROM PrestamoLibro p WHERE p.alumno.idusuario = :idusuario")
	List<PrestamoLibro> findByAlumnoIdUsuario(int idusuario);
}

*/


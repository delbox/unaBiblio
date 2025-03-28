/*package com.biblioteca.unaBiblio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biblioteca.unaBiblio.models.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
	Optional<Usuario> findByUsuario(String usuario);
	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END " +
	"FROM Usuario u " + 
	"WHERE u.idusuario = :id AND u.rol = 'ROLE_ALUMNO'")
	boolean existeByIdAlumno(@Param("id") int id);
	
}
*/
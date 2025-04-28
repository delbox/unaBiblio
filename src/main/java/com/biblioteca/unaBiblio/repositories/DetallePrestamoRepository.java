package com.biblioteca.unaBiblio.repositories;




import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biblioteca.unaBiblio.models.Biblioteca;
import com.biblioteca.unaBiblio.models.DetallePrestamo;
import com.biblioteca.unaBiblio.models.EstadoEjemplar;
import com.biblioteca.unaBiblio.models.Libro;
import com.biblioteca.unaBiblio.models.PrestamoLibro;





@Repository
public interface DetallePrestamoRepository extends JpaRepository<DetallePrestamo,Integer> {
	@Query("SELECT COUNT(dp) " +
		       "FROM DetallePrestamo dp " +
		       "WHERE dp.ejemplar.libro = :libro " +
		       "AND dp.ejemplar.biblioteca = :biblioteca " +
		       "AND dp.ejemplar.estado = :estado")
	int countByLibroAndBibliotecaAndEstado(@Param("libro") Libro libro,
										   @Param("biblioteca") Biblioteca biblioteca,
										   @Param("estado") EstadoEjemplar estado);	
	
	List<DetallePrestamo> findByPrestamo_Idprestamo(int idprestamo);
	
	//Para devoluciones
	Optional<DetallePrestamo> findByPrestamo(PrestamoLibro prestamo);
	//List<DetallePrestamo> findByPrestamo(PrestamoLibro prestamo);
}

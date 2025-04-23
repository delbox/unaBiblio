package com.biblioteca.unaBiblio.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.biblioteca.unaBiblio.models.DetallePrestamo;




@Repository
public interface DetallePrestamoRepository extends JpaRepository<DetallePrestamo,Integer> {
	
}

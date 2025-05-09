/*package com.biblioteca.unaBiblio.services;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.unaBiblio.dto.DetallePrestamoDTO;
import com.biblioteca.unaBiblio.models.Biblioteca;
import com.biblioteca.unaBiblio.models.DetallePrestamo;
import com.biblioteca.unaBiblio.models.Ejemplar;
import com.biblioteca.unaBiblio.models.EstadoEjemplar;
import com.biblioteca.unaBiblio.models.Libro;
import com.biblioteca.unaBiblio.models.PrestamoLibro;
import com.biblioteca.unaBiblio.models.Stock;
import com.biblioteca.unaBiblio.repositories.DetallePrestamoRepository;
import com.biblioteca.unaBiblio.repositories.EjemplarRepository;
import com.biblioteca.unaBiblio.repositories.StockRepository;





@Service
public class DetallePrestamoService {
	
	@Autowired
	private DetallePrestamoRepository detallePrestamoRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private EjemplarRepository ejemplarRepository;
	
	@Autowired
	private EjemplarService ejemplarService;
	
	@Autowired
	private PrestamoLibroService prestamoLibroService;
	
	
	public List<DetallePrestamoDTO> getAllDetallePrestamo(){
        List<DetallePrestamo> detallePrestamo = detallePrestamoRepository.findAll();
        return detallePrestamo.stream()
                .map(DetallePrestamoDTO::new) // Convierte a DTO
                .collect(Collectors.toList());
    }
    
    
	public DetallePrestamoDTO agregarDetalle(DetallePrestamoDTO detallePrestamoDTO) {
		
    	Ejemplar ejemplar = ejemplarService.obtenerEjemplarPorId(detallePrestamoDTO.getIdejemplar());
    	
    	//Validar que el ejemplar este disponible
    	if(ejemplar.getEstado() != EstadoEjemplar.DISPONIBLE) {
    		throw new IllegalStateException("El ejemplar no está disponible.");
    	}
    	
    	//Validar que haya stock del libro en la biblioteca
    	Libro libro = ejemplar.getLibro();
    	Biblioteca biblioteca = ejemplar.getBiblioteca();
    	
    	//Consultar el stock
    	Stock stockLibro = stockRepository.findByLibroAndBiblioteca(libro, biblioteca)
    					.orElseThrow(() -> new RuntimeException("No se encontró el stock del libro en esta biblioteca"));
    	
    	
    	//Contar cuantos ejemplares de ese libro estan disponibles
    	int ejemplaresDisponibles = ejemplarRepository.countByLibroAndBibliotecaAndEstado(libro, biblioteca,EstadoEjemplar.DISPONIBLE);
    	
    	if( ejemplaresDisponibles <= 0 ) {
    		throw new IllegalStateException("No hay stock disponible para este libro en esta biblioteca.");
    	}
    	
    	// Crear y guardar el detalle del préstamo
    	DetallePrestamo detallePrestamo = new DetallePrestamo();
    	
    	detallePrestamo.setEjemplar(ejemplar);
    	detallePrestamo.setActivo(detallePrestamoDTO.getActivo());
    	
    	PrestamoLibro prestamo = prestamoLibroService.obtenerPrestamoPorId(detallePrestamoDTO.getIdprestamo());
    	detallePrestamo.setPrestamo(prestamo);
    	
    	//Guarda la entidad en el repositorio
    	DetallePrestamo nuevoDetallePrestamo = detallePrestamoRepository.save(detallePrestamo);
    	
    	//Convierte la entidad guardada a DTO y devuelve
    	return new DetallePrestamoDTO(nuevoDetallePrestamo);
    	
    }
	
	
}*/

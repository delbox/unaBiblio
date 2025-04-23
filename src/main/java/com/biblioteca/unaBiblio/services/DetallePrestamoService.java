package com.biblioteca.unaBiblio.services;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.unaBiblio.dto.DetallePrestamoDTO;
import com.biblioteca.unaBiblio.models.DetallePrestamo;
import com.biblioteca.unaBiblio.models.Ejemplar;
import com.biblioteca.unaBiblio.models.PrestamoLibro;
import com.biblioteca.unaBiblio.repositories.DetallePrestamoRepository;





@Service
public class DetallePrestamoService {
	
	@Autowired
	private DetallePrestamoRepository detallePrestamoRepository;
	
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
    
    
	/*public DetallePrestamoDTO agregarDetalle(DetallePrestamoDTO detallePrestamoDTO) {
		
    	DetallePrestamo detallePrestamo = new DetallePrestamo();
    	
    	Ejemplar ejemplar = ejemplarService.obtenerEjemplarPorId(detallePrestamoDTO.getIdejemplar());
    	
    	detallePrestamo.setEjemplar(ejemplar);
    	detallePrestamo.setActivo(detallePrestamoDTO.getActivo());
    	
    	PrestamoLibro prestamo = prestamoLibroService.obtenerPrestamoPorId(detallePrestamoDTO.getIdprestamo()); 
    	
    	
    	
    	    	
    	//Guarda la entidad en el repositorio
    	DetallePrestamo nuevoDetallePrestamo = detallePrestamoRepository.save(detallePrestamo);
    	
    	//Convierte la entidad guardada a DTO y devuelve
    	return new DetallePrestamoDTO(nuevoDetallePrestamo);
    	
    }*/
}

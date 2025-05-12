package com.biblioteca.unaBiblio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.unaBiblio.ResourceNotFoundException;
import com.biblioteca.unaBiblio.dto.EjemplarDTO;
import com.biblioteca.unaBiblio.exception.LibroInactivoException;
import com.biblioteca.unaBiblio.models.Biblioteca;
import com.biblioteca.unaBiblio.models.Ejemplar;
import com.biblioteca.unaBiblio.models.EstadoEjemplar;
import com.biblioteca.unaBiblio.models.Libro;
import com.biblioteca.unaBiblio.repositories.EjemplarRepository;



@Service
public class EjemplarService {
	
	@Autowired
	private EjemplarRepository ejemplarRepository;
	
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private BibliotecaService bibliotecaService;
	
	
	public List<EjemplarDTO> getAllEjemplares() {
		List<Ejemplar> ejemplares = ejemplarRepository.findAll();
		return ejemplares.stream()
				.map(e -> new EjemplarDTO(e.getIdejemplar(),e.getCodigo(),e.getEstado(),e.getLibro().getIdlibro(),e.getBiblioteca().getIdbiblioteca()))
				.collect(Collectors.toList());
	}
	
	
	public EjemplarDTO agregarEjemplar(EjemplarDTO ejemplarDTO) {
		Ejemplar ejemplar = new Ejemplar();
		
		ejemplar.setIdejemplar(ejemplarDTO.getIdejemplar());
		ejemplar.setCodigo(ejemplarDTO.getCodigo());
		ejemplar.setEstado(ejemplarDTO.getEstado());
		
		Libro libro = libroService.obtenerLibroPorId(ejemplarDTO.getIdlibro());
		
		//Validacion: el libro debe estar activo
		if(!libro.getActivo()) {
			throw new LibroInactivoException("El libro no se encuentra activo, no puedes agregar el ejemplar");
		}
		
		ejemplar.setLibro(libro);
		
		//Si se especifica el ID de la biblioteca, usarlo, sino usar el ID 1 por defecto
		int idBiblioteca = (ejemplarDTO.getIdbiblioteca() != null) ? ejemplarDTO.getIdbiblioteca() : 1;
		Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(idBiblioteca);
		ejemplar.setBiblioteca(biblioteca);
		
		//Guardar la entidad en el repositorio
		Ejemplar nuevoEjemplar = ejemplarRepository.save(ejemplar);
		
		//Convierte la entidad guardada a DTO y devuelve
		return new EjemplarDTO(nuevoEjemplar);
	
	}
	
	public EjemplarDTO actualizarEjemplar(int id, EjemplarDTO ejemplarDTO) {
		//Buscar ejemplar por id
		Ejemplar ejemplarExistente = ejemplarRepository.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("Ejemplar no encontrado con id: " + id));
				 
		//Actualizar los campos de ejemplar
		ejemplarExistente.setCodigo(ejemplarDTO.getCodigo());
		ejemplarExistente.setEstado(ejemplarDTO.getEstado());
		
		Libro libro = libroService.obtenerLibroPorId(ejemplarDTO.getIdlibro());
		ejemplarExistente.setLibro(libro);
		
		//Guardar el ejemplar actualizado en la base de datos
		Ejemplar ejemplarActualizado = ejemplarRepository.save(ejemplarExistente);
		
		//Devolver el ejemplar como DTO
		return new EjemplarDTO(ejemplarActualizado);
				
	}
	
	public void eliminarEjemplar(int id) {
    	//Buscar el ejemplar por ID
    	Ejemplar ejemplarExistente = ejemplarRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Ejemplar no encontrado con id: " + id));
    	
    	//Eliminar usuario
    	ejemplarRepository.delete(ejemplarExistente);
    	
	}
	
   public Ejemplar obtenerEjemplarPorId(int id) {
		// Busca el ejemplar por ID
		Ejemplar ejemplar = ejemplarRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ejemplar no encontrado con id: " + id));
		
		// Devuelve el ejemplar si todo es válido
		return ejemplar;
   }
   
   //Obtener ejemplares disponibles por id libro
   public List<EjemplarDTO> obtenerEjemplaresDisponiblesPorLibro(int idlibro) {
	   List<Ejemplar> ejemplaresDisponibles = ejemplarRepository.findByLibro_IdlibroAndEstadoOrderByIdejemplarAsc(idlibro, EstadoEjemplar.DISPONIBLE);
	   return ejemplaresDisponibles.stream()
		        .map(e -> new EjemplarDTO(e)) 
		        .collect(Collectors.toList()); 
   }
		
}

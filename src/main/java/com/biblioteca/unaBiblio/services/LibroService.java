package com.biblioteca.unaBiblio.services;





import com.biblioteca.unaBiblio.ResourceNotFoundException;
import com.biblioteca.unaBiblio.dto.LibroDTO;
import com.biblioteca.unaBiblio.models.Libro;
import com.biblioteca.unaBiblio.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {


    @Autowired
    private LibroRepository libroRepository;
    
    
    
    public List<LibroDTO> getAllLibros() {
        List<Libro> libros = libroRepository.findAll();
        return libros.stream()
            .map(l -> new LibroDTO(l.getIdlibro(),l.getActivo(),l.getTitulo(),l.getAutor(),l.getEditorial(),l.getAniopublicacion(),l.getIsbn()))
            .collect(Collectors.toList());
    }

    public LibroDTO agregarLibro(LibroDTO libroDTO) {
    	//Convierte DTO a entidad, guarda en la base de datos y convierte de nuevo a DTO
    	Libro libro = new Libro();
    	
    	//Aqui se mapea los campos del DTO a la entidad
    	libro.setActivo(libroDTO.getActivo() != null ? libroDTO.getActivo() : true);
        libro.setTitulo(libroDTO.getTitulo());
        libro.setAutor(libroDTO.getAutor());
        libro.setEditorial(libroDTO.getEditorial());
        libro.setAniopublicacion(libroDTO.getAniopublicacion());
        libro.setIsbn(libroDTO.getIsbn());
        
        /*Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(libroDTO.getIdBiblioteca());
        libro.setBiblioteca(biblioteca);*/
    	
    	//Guarda la entidad en el repositorio
    	Libro nuevoLibro = libroRepository.save(libro);
    	
    	//Convierte la entidad guardada a DTO y devuelve
    	return new LibroDTO(nuevoLibro);
    }
    
    public LibroDTO actualizarLibro(int id, LibroDTO libroDTO) {
        // Buscar la libro por ID
        Libro libroExistente = libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado con id: " + id));

        // Actualizar los campos de la libro
        libroExistente.setActivo(libroDTO.getActivo());
        libroExistente.setTitulo(libroDTO.getTitulo());
        libroExistente.setAutor(libroDTO.getAutor());
        libroExistente.setEditorial(libroDTO.getEditorial());
        libroExistente.setAniopublicacion(libroDTO.getAniopublicacion());
        libroExistente.setIsbn(libroDTO.getIsbn());
        
        // Guardar la libro actualizada en la base de datos
        Libro libroActualizado = libroRepository.save(libroExistente);

        // Devolver la libro actualizada como DTO
        return new LibroDTO(libroActualizado);
    }
    
    public void eliminarLibro(int id) {
        // Buscar el libro por ID
        Libro libroExistente = libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado con id: " + id));

        // Eliminar libro
        libroRepository.delete(libroExistente);
    }
    
    public Libro obtenerLibroPorId(int id) {
    	return libroRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado con id: " + id));
    }
}

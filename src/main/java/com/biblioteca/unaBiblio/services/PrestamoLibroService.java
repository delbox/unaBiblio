package com.biblioteca.unaBiblio.services;


import com.biblioteca.unaBiblio.ResourceNotFoundException;
import com.biblioteca.unaBiblio.dto.PrestamoLibroDTO;
import com.biblioteca.unaBiblio.models.Alumno;
import com.biblioteca.unaBiblio.models.Biblioteca;
import com.biblioteca.unaBiblio.models.EstadoPrestamo;
import com.biblioteca.unaBiblio.models.PrestamoLibro;
import com.biblioteca.unaBiblio.models.TipoPrestamo;
import com.biblioteca.unaBiblio.models.Usuario;
import com.biblioteca.unaBiblio.repositories.PrestamoLibroRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PrestamoLibroService {

    @Autowired
    private PrestamoLibroRepository prestamoLibroRepository;
    
    
    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BibliotecaService bibliotecaService;
    
    public List<PrestamoLibroDTO> getAllPrestamos(){
        List<PrestamoLibro> prestamos = prestamoLibroRepository.findAll();
        return prestamos.stream()
                .map(PrestamoLibroDTO::new) // Convierte a DTO
                .collect(Collectors.toList());
    }
    
    
	public PrestamoLibroDTO agregarPrestamo(PrestamoLibroDTO prestamoLibroDTO) {
    	PrestamoLibro prestamoLibro = new PrestamoLibro();
    	
    	//obtener la fecha actual para el prestamo
    	LocalDateTime fechaActual = LocalDateTime.now();
    	prestamoLibro.setFechaprestamo(fechaActual);
    	
    	TipoPrestamo tipoPrestamo = prestamoLibroDTO.getTipoprestamo();
    	prestamoLibro.setTipoprestamo(tipoPrestamo);
    	
    	if ( tipoPrestamo == TipoPrestamo.LOCAL ) {
    		prestamoLibro.setFechaestimadadevolucion(fechaActual);
    	} else {
    		//Calcula la fecha estimada de devolucion (5 dias despues)
        	LocalDateTime fechaEstimadaDevolucion = fechaActual.plusDays(5);
        	prestamoLibro.setFechaestimadadevolucion(fechaEstimadaDevolucion);
    	}
    	
    	prestamoLibro.setEstadoprestamo(EstadoPrestamo.ACTIVO);
    	
    	Alumno alumno = alumnoService.obtenerAlumnoPorId(prestamoLibroDTO.getIdalumno());
    	Usuario usuario = usuarioService.obtenerUsuarioPorId(prestamoLibroDTO.getIdusuario());
    	Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(prestamoLibroDTO.getIdbiblioteca());
    	
    	prestamoLibro.setAlumno(alumno);
    	prestamoLibro.setUsuario(usuario);
    	prestamoLibro.setBiblioteca(biblioteca);
    	
    	//Guarda la entidad en el repositorio
    	PrestamoLibro nuevoPrestamoLibro = prestamoLibroRepository.save(prestamoLibro);
    	
    	//Convierte la entidad guardada a DTO y devuelve
    	return new PrestamoLibroDTO(nuevoPrestamoLibro);
    	
    }

	public void eliminarPrestamo(int id) {
		// Eliminar prestamo por ID
		PrestamoLibro prestamoExistente = prestamoLibroRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Prestamo no encontrado con id: " + id));

		// Eliminar libro
		prestamoLibroRepository.delete(prestamoExistente);
	}
	
	public PrestamoLibro obtenerPrestamoPorId(int id) {
		// Busca el usuario por ID
		PrestamoLibro prestamo = prestamoLibroRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Prestamo no encontrado con id: " + id));
		
		// Devuelve el usuario si todo es válido
		return prestamo;
	}
	
	
	//Historial Prestamos
	/*public List<HistorialPrestamoDTO> obtenerHistorialPrestamoPorAlumno(int idAlumno) {
		
		//Validar si el usuario tiene el rol ROLE_ALUMNO
		boolean esAlumno = usuarioRepository.existeByIdAlumno(idAlumno);
		
		if( !esAlumno ) {
			throw new IllegalArgumentException("El usuario no tiene el rol alumno");
		}
		
	    List<PrestamoLibro> prestamos = prestamoLibroRepository.findByAlumnoIdUsuario(idAlumno);

	    // Convertir cada PrestamoLibro a HistorialPrestamoDTO
	    return prestamos.stream()
	        .map(HistorialPrestamoDTO::new) // Usa directamente el constructor del DTO
	        .collect(Collectors.toList());
	}*/
     
}

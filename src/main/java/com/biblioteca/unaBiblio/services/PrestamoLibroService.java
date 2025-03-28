/*package com.biblioteca.unaBiblio.services;

import com.biblioteca.unaBiblio.dto.HistorialPrestamoDTO;
import com.biblioteca.unaBiblio.dto.PrestamoLibroDTO;
import com.biblioteca.unaBiblio.models.Libro;
import com.biblioteca.unaBiblio.models.PrestamoLibro;
import com.biblioteca.unaBiblio.models.Usuario;
import com.biblioteca.unaBiblio.repositories.PrestamoLibroRepository;
import com.biblioteca.unaBiblio.repositories.UsuarioRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PrestamoLibroService {

    @Autowired
    private PrestamoLibroRepository prestamoLibroRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LibroService libroService;
    
    public List<PrestamoLibroDTO> getAllPrestamos(){
        List<PrestamoLibro> prestamos = prestamoLibroRepository.findAll();
        return prestamos.stream()
                .map(PrestamoLibroDTO::new) // Convierte a DTO
                .collect(Collectors.toList());
    }
    
    public PrestamoLibroDTO agregarPrestamo(PrestamoLibroDTO prestamoLibroDTO) {
    	PrestamoLibro prestamoLibro = new PrestamoLibro();
    	
    	//obtener la fecha actual para el prestamo
    	Date fechaActual = new Date();
    	prestamoLibro.setFechaPrestamo(fechaActual);
    	
    	//Calcula la fecha estimada de devolucion (3 dias despues)
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(fechaActual);
    	calendar.add(Calendar.DATE, 3);
    	Date fechaEstimadaDevolucion = calendar.getTime();
    	prestamoLibro.setFechaEstimadaDevolucion(fechaEstimadaDevolucion);
    	
    	
    	prestamoLibro.setEstadoPrestamo(prestamoLibroDTO.getEstadoPrestamo());
    	prestamoLibro.setObservaciones(prestamoLibroDTO.getObservaciones());
    	
    	Usuario alumno = usuarioService.obtenerUsuarioAlumnoPorId(prestamoLibroDTO.getIdAlumno());
    	Libro libro = libroService.obtenerLibroPorId(prestamoLibroDTO.getIdLibro());
    	Usuario bibliotecario = usuarioService.obtenerUsuarioBibliotecarioPorId(prestamoLibroDTO.getIdBibliotecario());
    	
    	prestamoLibro.setAlumno(alumno);
    	prestamoLibro.setLibro(libro);
    	prestamoLibro.setBibliotecario(bibliotecario);
    	
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
	
	
	//Historial Prestamos
	public List<HistorialPrestamoDTO> obtenerHistorialPrestamoPorAlumno(int idAlumno) {
		
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
	}
     
}*/

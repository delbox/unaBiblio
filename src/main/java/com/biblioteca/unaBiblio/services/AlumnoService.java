/*package com.biblioteca.unaBiblio.services;

import com.biblioteca.unaBiblio.dto.AlumnoDTO;
import com.biblioteca.unaBiblio.models.Alumno;
import com.biblioteca.unaBiblio.models.Biblioteca;
import com.biblioteca.unaBiblio.models.Usuario;
import com.biblioteca.unaBiblio.repositories.AlumnoRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @Autowired
    private BibliotecaService bibliotecaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    public List<AlumnoDTO> getAllAlumnos(){
    	List<Alumno> alumnos = alumnoRepository.findAll();
    	return alumnos.stream()
    		   .map(b-> new AlumnoDTO(b.getIdAlumno(),b.getNombreApellido(),b.getBiblioteca().getId_biblioteca(),b.getUsuario().getId_usuario()))
    		   .collect(Collectors.toList());
    }
    
    public AlumnoDTO agregarAlumno(AlumnoDTO alumnoDTO) {
    	Alumno alumno = new Alumno();
    	
    	alumno.setNombreApellido(alumnoDTO.getNombreApellido());
    	
    	Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(alumnoDTO.getIdBiblioteca());
    	
    	Usuario usuario = usuarioService.obtenerUsuarioPorId(alumnoDTO.getIdUsuario());
    	
    	alumno.setBiblioteca(biblioteca);
    	alumno.setUsuario(usuario);
    	
    	//Guarda la entidad en el repositorio
    	Alumno nuevoAlumno = alumnoRepository.save(alumno);
    	
    	//Convierte la entidad guardada a DTO y devuelve
    	return new AlumnoDTO(nuevoAlumno);
    	
    }
    
    public AlumnoDTO actualizarAlumno(int id, AlumnoDTO alumnoDTO) {
    	//Buscar alumno por ID
    	Alumno alumnoExistente = alumnoRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con id: " + id));
    	
    	//Actualizar los campos del Alumno
    	Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(alumnoDTO.getIdBiblioteca());
    	Usuario usuario = usuarioService.obtenerUsuarioPorId(alumnoDTO.getIdUsuario());
    	
    	alumnoExistente.setNombreApellido(alumnoDTO.getNombreApellido());
    	alumnoExistente.setBiblioteca(biblioteca);
    	alumnoExistente.setUsuario(usuario);
    	
    	//Guardar el alumno actualizado en la base de datos
    	Alumno alumnoActualizado = alumnoRepository.save(alumnoExistente);
    	
    	//Devolver el alumno actualizado como DTO
    	return new AlumnoDTO(alumnoActualizado);
    	
    }
    
    public void eliminarAlumno(int id) {
    	//Buscar el alumno por ID
    	Alumno alumnoExistente = alumnoRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con id: " + id));
    	
    	//Eliminar usuario
    	alumnoRepository.delete(alumnoExistente);
    }
    
    public Alumno obtenerAlumnoPorId(int id) {
    	return alumnoRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con id: " + id));
    }
}*/
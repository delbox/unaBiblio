package com.biblioteca.unaBiblio.services;

import com.biblioteca.unaBiblio.ResourceNotFoundException;
import com.biblioteca.unaBiblio.dto.AlumnoDTO;
import com.biblioteca.unaBiblio.models.Alumno;
import com.biblioteca.unaBiblio.models.Biblioteca;
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
    
    
    public List<AlumnoDTO> getAllAlumnos(){
    	List<Alumno> alumnos = alumnoRepository.findAll();
    	return alumnos.stream()
    		   .map(
    		    a-> new AlumnoDTO(a.getIdalumno(),a.getNombre(),a.getApellido(),a.getCedula(),a.getEmail(),a.getTelefono(),a.getBiblioteca().getIdbiblioteca()))
    		   	.collect(Collectors.toList());
    }
    
    
    public AlumnoDTO agregarAlumno(AlumnoDTO alumnoDTO) {
    	Alumno alumno = new Alumno();
    	
    	alumno.setNombre(alumnoDTO.getNombre());
    	alumno.setApellido(alumnoDTO.getApellido());
    	alumno.setCedula(alumnoDTO.getCedula());
    	alumno.setEmail(alumnoDTO.getEmail());
    	alumno.setTelefono(alumnoDTO.getTelefono());
    	
    	Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(alumnoDTO.getIdbiblioteca());
    	
    	alumno.setBiblioteca(biblioteca);
    	
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
    	Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(alumnoDTO.getIdbiblioteca());
    	
    	alumnoExistente.setNombre(alumnoDTO.getNombre());
    	alumnoExistente.setApellido(alumnoDTO.getApellido());
    	alumnoExistente.setCedula(alumnoDTO.getCedula());
    	alumnoExistente.setEmail(alumnoDTO.getEmail());
    	alumnoExistente.setTelefono(alumnoDTO.getTelefono());
    	alumnoExistente.setBiblioteca(biblioteca);
 
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
}
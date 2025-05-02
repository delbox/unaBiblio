package com.biblioteca.unaBiblio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.unaBiblio.ResourceNotFoundException;
import com.biblioteca.unaBiblio.dto.RolDTO;
import com.biblioteca.unaBiblio.models.Rol;
import com.biblioteca.unaBiblio.repositories.RolRepository;



@Service
public class RolService {
	
	@Autowired
    private RolRepository rolRepository;
	
	public List<RolDTO> getAllRoles() {
		List<Rol> roles = rolRepository.findAll();
		return roles.stream()
			   .map(r -> new RolDTO(r.getIdrol(),r.getDescripcion()))
			   .collect(Collectors.toList());
	}
	
	
	public RolDTO agregarRol(RolDTO rolDTO) {
		Rol rol = new Rol();
		
		rol.setDescripcion(rolDTO.getDescripcion());
		
		//Guarda la entidad en el repositorio
		Rol nuevoRol = rolRepository.save(rol);
		
		//Convierte la entidad guardada a DTO y devuelve
		return new RolDTO(nuevoRol);
		
	}
	
	public RolDTO actualizarRol(int id, RolDTO rolDTO) {
		//Buscar el rol por id
		Rol rolExistente = rolRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
		
		//Actualizar el campo descripcion
		rolExistente.setDescripcion(rolDTO.getDescripcion());
		
		//Guardar el rol actualizado en la base de datos
		Rol rolActualizado = rolRepository.save(rolExistente);
		
		//Devolver el rol como DTO
		return new RolDTO(rolActualizado);
	}
	
	public void eliminarRol(int id) {
    	//Buscar el usuario por ID
    	Rol rolExistente = rolRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
    	
    	//Eliminar rol
    	rolRepository.delete(rolExistente);
    }
	
	
	public Rol obtenerRolPorId(int id) {
    	return rolRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));
    }
	
}

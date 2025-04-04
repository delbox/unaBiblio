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
	
	
	
	public Rol obtenerRolPorId(int id) {
    	return rolRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));
    }
	
}

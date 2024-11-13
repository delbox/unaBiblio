package com.biblioteca.unaBiblio.services;


import com.biblioteca.unaBiblio.dto.UsuarioDTO;
import com.biblioteca.unaBiblio.models.Biblioteca;

import com.biblioteca.unaBiblio.models.Usuario;
import com.biblioteca.unaBiblio.repositories.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

	@Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private BibliotecaService bibliotecaService;
    
    public List<UsuarioDTO> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
            .map(b -> new UsuarioDTO(b.getId_usuario(),b.getCedula(),b.getContrasena(),b.getFacultad(),b.getBiblioteca().getId_biblioteca()))
            .collect(Collectors.toList());
    }
    
    
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) {
    	
    	Usuario usuario = new Usuario();
    	
    	usuario.setCedula(usuarioDTO.getCedula());
    	usuario.setContrasena(usuarioDTO.getContrasena());
    	usuario.setFacultad(usuarioDTO.getFacultad());
    	
    	Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(usuarioDTO.getIdBiblioteca());
    	usuario.setBiblioteca(biblioteca);
    	
    	//Guarda la entidad en el repositorio
    	Usuario nuevoUsuario = usuarioRepository.save(usuario);
    	
    	//Convierte la entidad guardada a DTO y devuelve
    	return new UsuarioDTO(nuevoUsuario);
    }
    
    public UsuarioDTO actualizarUsuario(int id, UsuarioDTO usuarioDTO) {
    	//Buscar libro por ID
    	Usuario usuarioExistente = usuarioRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
    	
    	//Actualizar los campos del usuario
    	usuarioExistente.setCedula(usuarioDTO.getCedula());
    	usuarioExistente.setContrasena(usuarioDTO.getContrasena());
    	usuarioExistente.setFacultad(usuarioDTO.getFacultad());
    	
    	Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(usuarioDTO.getIdBiblioteca());
    	usuarioExistente.setBiblioteca(biblioteca);
    	
    	//Guardar el usuario actualizado en la base de datos
    	Usuario usuarioActualizado = usuarioRepository.save(usuarioExistente);
    	
    	//Devolver el usuario actualizado como DTO
    	return new UsuarioDTO(usuarioActualizado);
    }
    
    public void eliminarUsuario(int id) {
    	//Buscar el usuario por ID
    	Usuario usuarioExistente = usuarioRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
    	
    	//Eliminar usuario
    	usuarioRepository.delete(usuarioExistente);
    }
    
    public Usuario obtenerUsuarioPorId(int id) {
    	return usuarioRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
    }
}
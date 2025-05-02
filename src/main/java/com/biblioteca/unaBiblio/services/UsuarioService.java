package com.biblioteca.unaBiblio.services;


import com.biblioteca.unaBiblio.ResourceNotFoundException;
import com.biblioteca.unaBiblio.dto.UsuarioDTO;
import com.biblioteca.unaBiblio.models.Rol;
import com.biblioteca.unaBiblio.models.Usuario;
import com.biblioteca.unaBiblio.repositories.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UsuarioService {

	@Autowired
    private UsuarioRepository usuarioRepository;
	
	
	@Autowired
	private RolService rolService;
	
    
    public List<UsuarioDTO> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
            .map(u -> new UsuarioDTO(u.getIdusuario(),u.getNombre(),u.getApellido(),u.getUsuario(),u.getPassword(),u.getActivo(),u.getRol().getIdrol()))
            .collect(Collectors.toList());
    }
    
    
   public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) {
    	
    	Usuario usuario = new Usuario();
    	
    	usuario.setNombre(usuarioDTO.getNombre());
    	usuario.setApellido(usuarioDTO.getApellido());
    	usuario.setUsuario(usuarioDTO.getUsuario());
    	
    	//Encriptar el password antes de guardarla
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	
    	String passwordEncriptado = passwordEncoder.encode(usuarioDTO.getPassword());
    	
    	usuario.setPassword(passwordEncriptado);
    	
    	usuario.setActivo(usuarioDTO.getActivo() != null ? usuarioDTO.getActivo() : true);
    	
    	Rol rol = rolService.obtenerRolPorId(usuarioDTO.getRol());
    	usuario.setRol(rol);
    	
    	
    	//Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(usuarioDTO.getIdBiblioteca());
    	//usuario.setBiblioteca(biblioteca);
    	
    	//Guarda la entidad en el repositorio
    	Usuario nuevoUsuario = usuarioRepository.save(usuario);
    	
    	//Convierte la entidad guardada a DTO y devuelve
    	return new UsuarioDTO(nuevoUsuario);
   }
   
   
    public UsuarioDTO actualizarUsuario(int id, UsuarioDTO usuarioDTO) {
    	//Buscar usuario por ID
    	Usuario usuarioExistente = usuarioRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
    	
    	//Actualizar los campos del usuario
    	
    	usuarioExistente.setNombre(usuarioDTO.getNombre());
    	usuarioExistente.setApellido(usuarioDTO.getApellido());
    	usuarioExistente.setUsuario(usuarioDTO.getUsuario());
    	
    	//Encriptar el password antes de guardarla
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String passwordEncriptado = passwordEncoder.encode(usuarioDTO.getPassword());
    	
    	
    	usuarioExistente.setPassword(passwordEncriptado);
    	usuarioExistente.setActivo(usuarioDTO.getActivo());
    	
    	Rol rol = rolService.obtenerRolPorId(usuarioDTO.getRol());
    	
    	usuarioExistente.setRol(rol);
    
    	/*Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(usuarioDTO.getIdBiblioteca());
    	usuarioExistente.setBiblioteca(biblioteca);*/
    	
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
		// Busca el usuario por ID
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
		
		// Devuelve el usuario si todo es válido
		return usuario;
	}
    

}


package com.biblioteca.unaBiblio.services;

import com.biblioteca.unaBiblio.dto.BibliotecarioDTO;
import com.biblioteca.unaBiblio.models.Biblioteca;
import com.biblioteca.unaBiblio.models.Bibliotecario;
import com.biblioteca.unaBiblio.models.Usuario;
import com.biblioteca.unaBiblio.repositories.BibliotecarioRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BibliotecarioService {

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;
    
    @Autowired
    private BibliotecaService bibliotecaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    public List<BibliotecarioDTO> getAllBibliotecarios() {
    	List<Bibliotecario> bibliotecarios = bibliotecarioRepository.findAll();
    	return bibliotecarios.stream()
    		.map(b-> new BibliotecarioDTO(b.getIdBibliotecario(),b.getNombreApellido(),b.getCargo(),b.getBiblioteca().getId_biblioteca(),b.getUsuario().getId_usuario()))
    		.collect(Collectors.toList());
    			
    }
    
    public BibliotecarioDTO agregarBibliotecario(BibliotecarioDTO bibliotecarioDTO) {
    	Bibliotecario bibliotecario = new Bibliotecario();
    	
    	bibliotecario.setNombreApellido(bibliotecarioDTO.getNombreApellido());
    	bibliotecario.setCargo(bibliotecarioDTO.getCargo());
    	
    	Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(bibliotecarioDTO.getIdBiblioteca());
    	
    	Usuario usuario = usuarioService.obtenerUsuarioPorId(bibliotecarioDTO.getIdUsuario());
    	
    	bibliotecario.setBiblioteca(biblioteca);
    	bibliotecario.setUsuario(usuario);
    	
    	//Guarda la entidad en el repositorio
    	Bibliotecario nuevoBibliotecario = bibliotecarioRepository.save(bibliotecario);
    	
    	//Convierte la entidad guardada a DTO y devuelve
    	return new BibliotecarioDTO(nuevoBibliotecario);
    	
    }
    
    public BibliotecarioDTO actualizarBibliotecario(int id, BibliotecarioDTO bibliotecarioDTO) {
    	//Buscar bibliotecario por ID
    	Bibliotecario bibliotecarioExistente = bibliotecarioRepository.findById(id)
    				  .orElseThrow(() -> new ResourceNotFoundException("Bibliotecario no encontrado con id: " + id));
    	
    	//Actualizar los campos del Bibliotecario
    	Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(bibliotecarioDTO.getIdBiblioteca());
    	Usuario usuario = usuarioService.obtenerUsuarioPorId(bibliotecarioDTO.getIdUsuario());
    	
    	bibliotecarioExistente.setNombreApellido(bibliotecarioDTO.getNombreApellido());
    	bibliotecarioExistente.setCargo(bibliotecarioDTO.getCargo());
    	bibliotecarioExistente.setBiblioteca(biblioteca);
    	bibliotecarioExistente.setUsuario(usuario);
    	
    	//Guardar el bibliotecario actualizado en la base de datos
    	Bibliotecario bibliotecarioActualizado = bibliotecarioRepository.save(bibliotecarioExistente);
    	
    	//Devolver el bibliotecario actualizado como DTO
    	return new BibliotecarioDTO(bibliotecarioActualizado);
    	
    }
    
    public void eliminarBibliotecario(int id) {
    	//Buscar el bibliotecario por ID
    	Bibliotecario bibliotecarioExistente = bibliotecarioRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Bibliotecario no encontrado con id: " + id));
    	
    	//Eliminar bibliotecario
    	bibliotecarioRepository.delete(bibliotecarioExistente);
    }
    
    public Bibliotecario obtenerBibliotecarioPorId(int id) {
    	return bibliotecarioRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Bibliotecario no encontrado con id: " + id));
    }

}
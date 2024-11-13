package com.biblioteca.unaBiblio.services;


import com.biblioteca.unaBiblio.dto.BibliotecaDTO;

import com.biblioteca.unaBiblio.models.Biblioteca;
import com.biblioteca.unaBiblio.repositories.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public List<BibliotecaDTO> getAllBibliotecas() {
        List<Biblioteca> bibliotecas = bibliotecaRepository.findAll();
        return bibliotecas.stream()
            .map(b -> new BibliotecaDTO(b.getId_biblioteca(), b.getFacultad(), b.getEstado()))
            .collect(Collectors.toList());
    }
    
    public BibliotecaDTO agregarBiblioteca(BibliotecaDTO bibliotecaDTO) {
    	//Convierte DTO a entidad, guarda en la base de datos y convierte de nuevo a DTO
    	Biblioteca biblioteca = new Biblioteca();
    	
    	//Aqui se mapea los campos del DTO a la entidad
    	biblioteca.setFacultad(bibliotecaDTO.getFacultad());
    	biblioteca.setEstado(bibliotecaDTO.getEstado());
    	
    	//Guarda la entidad en el repositorio
    	Biblioteca nuevaBiblioteca = bibliotecaRepository.save(biblioteca);
    	
    	//Convierte la entidad guardada a DTO y devuelve
    	return new BibliotecaDTO(nuevaBiblioteca);
    }
    
    public BibliotecaDTO actualizarBiblioteca(int id, BibliotecaDTO bibliotecaDTO) {
        // Buscar la biblioteca por ID
        Biblioteca bibliotecaExistente = bibliotecaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Biblioteca no encontrada con id: " + id));

        // Actualizar los campos de la biblioteca
        bibliotecaExistente.setFacultad(bibliotecaDTO.getFacultad());
        bibliotecaExistente.setEstado(bibliotecaDTO.getEstado());

        // Guardar la biblioteca actualizada en la base de datos
        Biblioteca bibliotecaActualizada = bibliotecaRepository.save(bibliotecaExistente);

        // Devolver la biblioteca actualizada como DTO
        return new BibliotecaDTO(bibliotecaActualizada);
    }
    
    public void eliminarBiblioteca(int id) {
        // Buscar la biblioteca por ID
        Biblioteca bibliotecaExistente = bibliotecaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Biblioteca no encontrada con id: " + id));

        // Eliminar la biblioteca
        bibliotecaRepository.delete(bibliotecaExistente);
    }
    
    public Biblioteca obtenerBibliotecaPorId(int id) {
    	return bibliotecaRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Biblioteca no encontrada con id: " + id));
    }
}
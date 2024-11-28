package com.biblioteca.unaBiblio.services;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.unaBiblio.dto.AlertaDTO;
import com.biblioteca.unaBiblio.models.Alerta;
import com.biblioteca.unaBiblio.models.Biblioteca;
import com.biblioteca.unaBiblio.models.Usuario;
import com.biblioteca.unaBiblio.repositories.AlertaRepository;


@Service
public class AlertaService {
	
	@Autowired
    private AlertaRepository alertaRepository;
    
    @Autowired
    private BibliotecaService bibliotecaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    
    public List<AlertaDTO> getAllAlertas(){
        List<Alerta> alertas = alertaRepository.findAll();
        return alertas.stream()
                .map(AlertaDTO::new) // Convierte a DTO
                .collect(Collectors.toList());
    }
    
    
    public AlertaDTO agregarAlerta(AlertaDTO alertaDTO) {
    	Alerta alerta = new Alerta();
    	
    	alerta.setFechaCreacion(alertaDTO.getFechaCreacion());
    	alerta.setFechaAtencion(alertaDTO.getFechaAtencion());
    	alerta.setCodigoQr(alertaDTO.getCodigoQr());
    	alerta.setDescripcion(alertaDTO.getDescripcion());
    	alerta.setEstado(alertaDTO.getEstado());
    	
    	Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(alertaDTO.getIdBiblioteca());
    	alerta.setBiblioteca(biblioteca);
    	
    	Usuario alumno = usuarioService.obtenerUsuarioAlumnoPorId(alertaDTO.getIdUsuario());
    	alerta.setUsuario(alumno);
    	
    	//Guardamos la entidad en el repositorio
    	Alerta nuevaAlerta = alertaRepository.save(alerta);
    	
    	//Convierte la entidad guardada a DTO y devuelve
    	return new AlertaDTO(nuevaAlerta);
    	
    }
    	
}

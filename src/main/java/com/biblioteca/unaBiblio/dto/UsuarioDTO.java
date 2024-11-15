package com.biblioteca.unaBiblio.dto;

import com.biblioteca.unaBiblio.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private int idUsuario;
    private String usuario;
    private String contrasena;
    private String facultad;
    private int idBiblioteca;
    

    public UsuarioDTO(Usuario usuario) {
        this.idUsuario = usuario.getId_usuario();
        this.usuario = usuario.getUsuario();
        this.contrasena = usuario.getContrasena();
        this.facultad = usuario.getFacultad();
        this.idBiblioteca = usuario.getBiblioteca().getId_biblioteca();
    }
}

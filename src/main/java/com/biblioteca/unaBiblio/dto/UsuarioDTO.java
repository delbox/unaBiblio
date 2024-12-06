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
    private int idusuario;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private String rol;
    private Boolean estado;
    private String cedula;
    

    public UsuarioDTO(Usuario usuario) {
        this.idusuario = usuario.getIdusuario();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.usuario = usuario.getUsuario();
        this.password = usuario.getPassword();
        this.rol = usuario.getRol().name();
        this.estado = usuario.getEstado();
        this.cedula = usuario.getCedula();
    }
}

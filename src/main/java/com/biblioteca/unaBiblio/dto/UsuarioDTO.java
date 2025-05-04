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
    private String cedula;
    private String usuario;
    private String password;
    private Boolean activo;
    private int rol;
   
    

    public UsuarioDTO(Usuario usuario) {
        this.idusuario = usuario.getIdusuario();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.cedula = usuario.getCedula();
        this.usuario = usuario.getUsuario();
        this.password = usuario.getPassword();
        this.activo = usuario.getActivo();
        this.rol = usuario.getRol().getIdrol();
    }
}

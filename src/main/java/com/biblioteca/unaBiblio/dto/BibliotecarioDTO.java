package com.biblioteca.unaBiblio.dto;

import com.biblioteca.unaBiblio.models.Bibliotecario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BibliotecarioDTO {
    private int idBibliotecario;
    private String nombreApellido;
    private String cargo;
    private int idBiblioteca;
    private int idUsuario;
    

    public BibliotecarioDTO(Bibliotecario bibliotecario) {
        this.idBibliotecario =  bibliotecario.getIdBibliotecario();
        this.nombreApellido = bibliotecario.getNombreApellido();
        this.cargo = bibliotecario.getCargo();
        this.idBiblioteca = bibliotecario.getBiblioteca().getId_biblioteca();
        this.idUsuario = bibliotecario.getUsuario().getId_usuario();
    }
}

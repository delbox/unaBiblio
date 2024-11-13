package com.biblioteca.unaBiblio.dto;

import com.biblioteca.unaBiblio.models.Alumno;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO {
    private int idAlumno;
    private String nombreApellido;
    private int idBiblioteca;
    private int idUsuario;

    public AlumnoDTO(Alumno alumno) {
        this.idAlumno = alumno.getIdAlumno();
        this.nombreApellido = alumno.getNombreApellido();
        this.idBiblioteca = alumno.getBiblioteca().getId_biblioteca();
        this.idUsuario = alumno.getUsuario().getId_usuario();
    }
}

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
    private int idalumno;
    private String nombre;
    private String apellido;
    private String cedula;
    private String email;
    private String telefono;
    private int idbiblioteca;

    public AlumnoDTO(Alumno alumno) {
        this.idalumno = alumno.getIdalumno();
        this.nombre = alumno.getNombre();
        this.apellido = alumno.getApellido();
        this.cedula = alumno.getCedula();
        this.email = alumno.getEmail();
        this.telefono = alumno.getTelefono();
        this.idbiblioteca = alumno.getBiblioteca().getIdbiblioteca();
        
    }
}

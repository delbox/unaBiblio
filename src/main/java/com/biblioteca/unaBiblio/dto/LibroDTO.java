/*package com.biblioteca.unaBiblio.dto;


import com.biblioteca.unaBiblio.models.Libro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {
    private int idlibro;
    private String descripcion;
    private String autor;
    private String editorial;
    private int aniopublicacion;
    private String codigoQr;
    private Boolean estado;
    private int idBiblioteca;

    public LibroDTO(Libro libro) {
        this.idlibro =  libro.getIdlibro();
        this.descripcion = libro.getDescripcion();
        this.autor = libro.getAutor();
        this.editorial = libro.getEditorial();
        this.aniopublicacion = libro.getAnioPublicacion();
        this.codigoQr = libro.getCodigoQr();
        this.estado = libro.getEstado();
        this.idBiblioteca = libro.getBiblioteca().getIdbiblioteca();
    }
}*/

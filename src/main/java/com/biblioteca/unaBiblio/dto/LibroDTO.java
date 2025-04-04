package com.biblioteca.unaBiblio.dto;


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
    private String titulo;
    private String autor;
    private String editorial;
    private int aniopublicacion;
    private String isbn;

    public LibroDTO(Libro libro) {
        this.idlibro =  libro.getIdlibro();
        this.titulo = libro.getTitulo();
        this.autor = libro.getAutor();
        this.editorial = libro.getEditorial();
        this.aniopublicacion = libro.getAniopublicacion();
        /*this.codigoQr = libro.getCodigoQr();
        this.estado = libro.getEstado();*/
        this.isbn = libro.getIsbn();
    }
}

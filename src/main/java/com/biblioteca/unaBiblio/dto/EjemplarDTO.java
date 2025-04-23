package com.biblioteca.unaBiblio.dto;




import com.biblioteca.unaBiblio.models.Ejemplar;
import com.biblioteca.unaBiblio.models.EstadoEjemplar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EjemplarDTO {
    private int idejemplar;
    private String codigo;
    private EstadoEjemplar estado;
    private int idlibro;
    private Integer idbiblioteca;

    public EjemplarDTO(Ejemplar ejemplar) {
        this.idejemplar = ejemplar.getIdejemplar();
        this.codigo = ejemplar.getCodigo();
        this.estado = ejemplar.getEstado();
        this.idlibro = ejemplar.getLibro().getIdlibro();
        this.idbiblioteca = ejemplar.getBiblioteca().getIdbiblioteca();
    }
}

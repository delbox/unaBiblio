package com.biblioteca.unaBiblio.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prestamos")
public class PrestamoLibro {
	
	//Definicion de los campos de Biblioteca
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prestamo", nullable = false)
	private int idprestamo;
	
	@Column(name="fecha_prestamo", nullable = false)
	private LocalDateTime fechaprestamo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_prestamo", length = 100, nullable = false)
	private TipoPrestamo tipoprestamo;
	
	@Column(name="fecha_estimada_devolucion", nullable = false)
	private LocalDateTime fechaestimadadevolucion;

	@Enumerated(EnumType.STRING)
    @Column(name="estado_prestamo", nullable = false)
    private EstadoPrestamo estadoprestamo;
    
    @ManyToOne
    @JoinColumn(name="id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="id_biblioteca", nullable = false)
    private Biblioteca biblioteca;
    
    /*@OneToMany(mappedBy = "prestamo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Permite serializar Devoluciones al serializar Prestamo
    private List<Devolucion> devoluciones = new ArrayList<>();*/
	
}

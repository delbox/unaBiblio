package com.biblioteca.unaBiblio.controllers;

import com.biblioteca.unaBiblio.models.Biblioteca;
import com.biblioteca.unaBiblio.models.DetallePrestamo;
import com.biblioteca.unaBiblio.models.Devolucion;
import com.biblioteca.unaBiblio.models.Ejemplar;
import com.biblioteca.unaBiblio.models.EstadoEjemplar;
import com.biblioteca.unaBiblio.models.EstadoPrestamo;
import com.biblioteca.unaBiblio.models.Libro;
import com.biblioteca.unaBiblio.models.PrestamoLibro;
import com.biblioteca.unaBiblio.models.Stock;
import com.biblioteca.unaBiblio.repositories.DetallePrestamoRepository;
import com.biblioteca.unaBiblio.repositories.DevolucionRepository;
import com.biblioteca.unaBiblio.repositories.EjemplarRepository;
import com.biblioteca.unaBiblio.repositories.PrestamoLibroRepository;
import com.biblioteca.unaBiblio.repositories.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionRepository devolucionRepository;

    @Autowired
    private PrestamoLibroRepository prestamoLibroRepository;
    
    @Autowired
    private DetallePrestamoRepository detallePrestamoRepository;
    
    @Autowired 
    private EjemplarRepository ejemplarRepository;
    
    @Autowired
    private StockRepository stockRepository;
    
    @GetMapping("/all")
    public List<Devolucion> obtenerDevoluciones() {
    	return devolucionRepository.findAll();
    }
    
    
    @PostMapping("/{idPrestamo}/detalle/{idDetalle}")
    public ResponseEntity<?> crearDevolucion(@RequestBody Devolucion devolucion, 
                                             @PathVariable Integer idPrestamo,
                                             @PathVariable Integer idDetalle) {
        Optional<PrestamoLibro> prestamoLibro = prestamoLibroRepository.findById(idPrestamo);

        if (!prestamoLibro.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Préstamo no encontrado");
        }

        Optional<DetallePrestamo> detalleOpt = detallePrestamoRepository.findById(idDetalle);

        if (!detalleOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalle del préstamo no encontrado");
        }

        DetallePrestamo detalle = detalleOpt.get();

        // Registrar devolución
        devolucion.setDetalleprestamo(detalle);
        devolucion.setFechadevolucionreal(LocalDateTime.now());
        devolucion.setObservaciones(devolucion.getObservaciones());

        devolucionRepository.save(devolucion);


        return ResponseEntity.status(HttpStatus.CREATED).body(devolucion);
    }
    
    @PutMapping("/cancelar/{idDevolucion}")
    public ResponseEntity<?> cancelarDevolucion(@PathVariable Integer idDevolucion) {
    	Optional<Devolucion> devolucionOpt = devolucionRepository.findById(idDevolucion);
    	
    	if(!devolucionOpt.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Devolucion no encontrada con ID: " + idDevolucion);
    	}
    	
    	Devolucion devolucion = devolucionOpt.get();
    	DetallePrestamo detalle = devolucion.getDetalleprestamo();
    	Ejemplar ejemplar = detalle.getEjemplar();
    	Libro libro = ejemplar.getLibro();
    	Biblioteca biblioteca = ejemplar.getBiblioteca();
    	
    	//1- Revertir estado del ejemplar a PRESTADO
    	ejemplar.setEstado(EstadoEjemplar.PRESTADO);
    	ejemplarRepository.save(ejemplar);
    	
    	//2- Marcar el detalle del prestamo como activo nuevamente
    	detalle.setActivo(true);
    	detallePrestamoRepository.save(detalle);
    	
    	//3- Restar 1 al stock
    	Optional<Stock> stockOpt = stockRepository.findByLibroAndBiblioteca(libro, biblioteca);
    	if(stockOpt.isPresent()) {
    		Stock stock = stockOpt.get();
    		stock.setCantidad(stock.getCantidad() - 1);
    		stockRepository.save(stock);
    	}
    	
    	//4- Eliminar la devolucion o bien usar un campo anulado(de forma opcional)
    	devolucionRepository.delete(devolucion);
    	
    	//5- Actualizar estado del prestamo a ACTIVO si al menos un detalle esta activo
    	PrestamoLibro prestamo = detalle.getPrestamo();
    	
    	boolean tieneEjemplaresActivos = prestamo.getDetalles().stream()
    			.anyMatch(d -> d.getActivo());
    	
    	if(tieneEjemplaresActivos) {
    		prestamo.setEstadoprestamo(EstadoPrestamo.ACTIVO);
    		prestamoLibroRepository.save(prestamo);
    	}
    	
    	return ResponseEntity.ok("Devolucion cancelada y revertida correctamente");
    	
    }
    
}

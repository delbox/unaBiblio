package com.biblioteca.unaBiblio.services;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PruebaConexionController {
	
	@Autowired
	private DataSource dataSource;
	
	
	@GetMapping("/verificarconexion")
	
	public String verificarConexion() {
		try (Connection connection = dataSource.getConnection()) {
			//Imprimimos un mensaje de respuesta
			//System.out.println("BD conectada");
			return connection.isValid(1) ? "Conexión exitosa con la base de datos biblioteca" : "Fallo la conexion a la base de datos";
		} catch (SQLException e) {
			return "Error al conectar con la base de datos: "+ e.getMessage();
		}
	}
}

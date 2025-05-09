package com.biblioteca.unaBiblio.exception;




public class LibroInactivoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LibroInactivoException(String mensaje) {
		super(mensaje);
	}
}

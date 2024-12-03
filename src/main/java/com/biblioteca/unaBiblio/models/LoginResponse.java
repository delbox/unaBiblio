package com.biblioteca.unaBiblio.models;

import com.biblioteca.unaBiblio.models.Usuario;

public class LoginResponse {

    public Usuario usuario;

	private String mensaje;
	
    private String token;

    public LoginResponse(Usuario usuario, String mensaje, String token) {

        this.usuario = usuario;
    	this.mensaje = mensaje;
        this.token = token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public String getMensaje() {
    	return mensaje;
    }
    
    public void setMensaje( String mensaje ) {
    	this.mensaje = mensaje;
    }
}

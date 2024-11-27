package com.biblioteca.unaBiblio.models;



public class LoginResponse {
	

	private String mensaje;
	
    private String token;

    public LoginResponse(String mensaje, String token) {
    	this.mensaje = mensaje;
        this.token = token;
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

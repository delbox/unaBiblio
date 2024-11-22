package com.biblioteca.unaBiblio.controllers;

import com.biblioteca.unaBiblio.models.LoginRequest;
import com.biblioteca.unaBiblio.models.Usuario;
import com.biblioteca.unaBiblio.models.LoginResponse;
import com.biblioteca.unaBiblio.repositories.UsuarioRepository;
import com.biblioteca.unaBiblio.services.ResourceNotFoundException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.security.Keys;

import java.security.Key;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Clave secreta para firmar el token
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            // Buscar el usuario por nombre de usuario
            Usuario usuario = usuarioRepository.findByUsuario(request.getUsuario())
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

            // Verificar password
            if (!usuario.getPassword().equals(request.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    Map.of("error", "Credenciales incorrectas", "status", HttpStatus.UNAUTHORIZED.value())
                );
            }

            // Generar un token JWT
            String token = Jwts.builder()
                    .setSubject(usuario.getUsuario())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Expira en 1 día
                    .signWith(SECRET_KEY)
                    .compact();

            // Retornar el token en la respuesta
            LoginResponse response = new LoginResponse(token);
            return ResponseEntity.ok(response);

        } catch (ResourceNotFoundException ex) {
            // En caso de que el usuario no exista, retornar un mensaje descriptivo
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error", ex.getMessage(), "status", HttpStatus.NOT_FOUND.value())
            );
        }
    }
}

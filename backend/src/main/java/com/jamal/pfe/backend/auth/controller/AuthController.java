package com.jamal.pfe.backend.auth.controller;

import com.jamal.pfe.backend.auth.dto.AuthResponse;
import com.jamal.pfe.backend.auth.dto.ForgotPasswordRequest;
import com.jamal.pfe.backend.auth.dto.LoginRequest;
import com.jamal.pfe.backend.auth.dto.RegisterRequest;
import com.jamal.pfe.backend.auth.dto.RegisterResponse;
import com.jamal.pfe.backend.auth.dto.ResetPasswordRequest;
import com.jamal.pfe.backend.auth.service.AuthService;
import com.jamal.pfe.backend.utilisateur.entity.Utilisateur;
import com.jamal.pfe.backend.utilisateur.repository.UtilisateurRepository;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;
    private final UtilisateurRepository utilisateurRepository;

    public AuthController(
            AuthService authService,
            UtilisateurRepository utilisateurRepository
    ) {
        this.authService = authService;
        this.utilisateurRepository = utilisateurRepository;
    }

    // ═══════════════════════════════════════════════════════════
    // POST /api/auth/register — Inscription CLIENT
    // ═══════════════════════════════════════════════════════════

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        try {
            RegisterResponse response = authService.register(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of(
                            "error", e.getMessage(),
                            "status", 409
                    ));
        }
    }

    // ═══════════════════════════════════════════════════════════
    // POST /api/auth/login — Connexion + JWT
    // ═══════════════════════════════════════════════════════════

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        try {
            String token = authService.login(request);

            Utilisateur user = utilisateurRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

            AuthResponse response = new AuthResponse();
            response.setToken(token);
            response.setEmail(user.getEmail());
            response.setRole(user.getRole());

            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                            "error", e.getMessage(),
                            "status", 401
                    ));
        }
    }

    // ═══════════════════════════════════════════════════════════
    // POST /api/auth/forgot-password
    // ═══════════════════════════════════════════════════════════

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        try {
            String message = authService.forgotPassword(request.getEmail());
            return ResponseEntity.ok(Map.of("message", message));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    // ═══════════════════════════════════════════════════════════
    // POST /api/auth/reset-password
    // ═══════════════════════════════════════════════════════════

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) {
        try {
            String message = authService.resetPassword(
                    request.getToken(),
                    request.getNewPassword()
            );
            return ResponseEntity.ok(Map.of("message", message));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}
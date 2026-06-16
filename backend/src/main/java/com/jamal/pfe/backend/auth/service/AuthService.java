package com.jamal.pfe.backend.auth.service;

import com.jamal.pfe.backend.auth.dto.LoginRequest;
import com.jamal.pfe.backend.auth.dto.RegisterRequest;
import com.jamal.pfe.backend.auth.dto.RegisterResponse;

public interface AuthService {

    /**
     * Inscription d'un nouvel utilisateur avec le rôle CLIENT.
     */
    RegisterResponse register(RegisterRequest request);

    /**
     * Authentification et génération du token JWT.
     */
    String login(LoginRequest request);

    /**
     * Demande de réinitialisation du mot de passe.
     */
    String forgotPassword(String email);

    /**
     * Réinitialisation du mot de passe avec token.
     */
    String resetPassword(String token, String newPassword);
}
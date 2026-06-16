package com.jamal.pfe.backend.auth.service.impl;

import com.jamal.pfe.backend.auth.dto.LoginRequest;
import com.jamal.pfe.backend.auth.dto.RegisterRequest;
import com.jamal.pfe.backend.auth.dto.RegisterResponse;
import com.jamal.pfe.backend.auth.security.JwtUtil;
import com.jamal.pfe.backend.auth.service.AuthService;
import com.jamal.pfe.backend.utilisateur.entity.Utilisateur;
import com.jamal.pfe.backend.utilisateur.repository.UtilisateurRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    private final UtilisateurRepository utilisateurRepository;
    private final JwtUtil jwtUtil;

    // Injection par constructeur (meilleure pratique)
    public AuthServiceImpl(
            UtilisateurRepository utilisateurRepository,
            JwtUtil jwtUtil
    ) {
        this.utilisateurRepository = utilisateurRepository;
        this.jwtUtil = jwtUtil;
    }

    // ═══════════════════════════════════════════════════════════
    // REGISTER — Inscription publique (rôle CLIENT automatique)
    // ═══════════════════════════════════════════════════════════

    @Override
    public RegisterResponse register(RegisterRequest request) {

        // 1. Vérifier si l'email existe déjà
        if (utilisateurRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Cet email est déjà utilisé");
        }

        // 2. Créer l'entité utilisateur
        Utilisateur user = new Utilisateur();
        user.setNom(request.getNom());
        user.setEmail(request.getEmail());

        // 3. Mot de passe en texte brut (dev/test uniquement)
        user.setPassword(request.getPassword());

        // 4. Assigner le rôle CLIENT automatiquement
        user.setRole("CLIENT");

        // 5. Sauvegarder en base de données
        Utilisateur savedUser = utilisateurRepository.save(user);

        // 6. Retourner la réponse (sans mot de passe)
        return new RegisterResponse(
                savedUser.getId(),
                savedUser.getNom(),
                savedUser.getEmail(),
                savedUser.getRole(),
                "Inscription réussie ! Vous pouvez maintenant vous connecter."
        );
    }

    // ═══════════════════════════════════════════════════════════
    // LOGIN — Authentification avec BCrypt + JWT
    // ═══════════════════════════════════════════════════════════

    @Override
    public String login(LoginRequest request) {

        // 1. Vérifier si l'utilisateur existe
        Utilisateur user = utilisateurRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        // 2. Vérifier le mot de passe en texte brut (dev/test uniquement)
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        // 3. Générer et retourner le token JWT
        return jwtUtil.generateToken(user.getEmail(), user.getRole());
    }

    // ═══════════════════════════════════════════════════════════
    // FORGOT PASSWORD — Demande de réinitialisation
    // ═══════════════════════════════════════════════════════════

    @Override
    public String forgotPassword(String email) {

        Utilisateur user = utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email introuvable"));

        String token = UUID.randomUUID().toString();

        user.setResetToken(token);
        user.setResetTokenExpiration(LocalDateTime.now().plusMinutes(15));

        utilisateurRepository.save(user);

        // ⚠️ Simulation email (à remplacer par un vrai service d'envoi)
        return "Lien de reset : http://localhost:3000/reset-password?token=" + token;
    }

    // ═══════════════════════════════════════════════════════════
    // RESET PASSWORD — Réinitialisation avec token
    // ═══════════════════════════════════════════════════════════

    @Override
    public String resetPassword(String token, String newPassword) {

        Utilisateur user = utilisateurRepository.findByResetToken(token);

        if (user == null) {
            throw new RuntimeException("Token invalide");
        }

        if (user.getResetTokenExpiration().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expiré");
        }

        // Mot de passe en texte brut (dev/test uniquement)
        user.setPassword(newPassword);
        user.setResetToken(null);
        user.setResetTokenExpiration(null);

        utilisateurRepository.save(user);

        return "Mot de passe modifié avec succès";
    }
}
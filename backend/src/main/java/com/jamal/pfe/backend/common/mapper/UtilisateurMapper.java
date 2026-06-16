package com.jamal.pfe.backend.common.mapper;

import com.jamal.pfe.backend.utilisateur.entity.Utilisateur;
import com.jamal.pfe.backend.utilisateur.dto.UtilisateurRequest;
import com.jamal.pfe.backend.utilisateur.dto.UtilisateurResponse;

public class UtilisateurMapper {

    public static Utilisateur toEntity(UtilisateurRequest req) {
        Utilisateur u = new Utilisateur();

        u.setNom(req.getNom());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        u.setRole(req.getRole());

        return u;
    }

    public static UtilisateurResponse toResponse(Utilisateur u) {
        UtilisateurResponse r = new UtilisateurResponse();

        r.setId(u.getId());
        r.setNom(u.getNom());
        r.setEmail(u.getEmail());
        r.setRole(u.getRole());

        return r;
    }
}
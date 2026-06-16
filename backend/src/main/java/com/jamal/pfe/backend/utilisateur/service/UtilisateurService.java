package com.jamal.pfe.backend.utilisateur.service;

import com.jamal.pfe.backend.utilisateur.dto.UtilisateurRequest;
import com.jamal.pfe.backend.utilisateur.dto.UtilisateurResponse;

import java.util.List;

public interface UtilisateurService {

    UtilisateurResponse create(UtilisateurRequest request);

    List<UtilisateurResponse> findAll();

    void delete(Long id);
}
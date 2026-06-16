package com.jamal.pfe.backend.utilisateur.service.impl;

import com.jamal.pfe.backend.common.mapper.UtilisateurMapper;
import com.jamal.pfe.backend.utilisateur.dto.UtilisateurRequest;
import com.jamal.pfe.backend.utilisateur.dto.UtilisateurResponse;
import com.jamal.pfe.backend.utilisateur.entity.Utilisateur;
import com.jamal.pfe.backend.utilisateur.repository.UtilisateurRepository;
import com.jamal.pfe.backend.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository repo;

    public UtilisateurServiceImpl(UtilisateurRepository repo) {
        this.repo = repo;
    }

    @Override
    public UtilisateurResponse create(UtilisateurRequest request) {
        Utilisateur u = UtilisateurMapper.toEntity(request);

        // Quand le SUPER_ADMIN crée un compte,
        // le rôle par défaut est ADMIN
        u.setRole("ADMIN");

        // Mot de passe en texte brut (dev/test uniquement)
        // u.setPassword(u.getPassword()); // déjà défini par le mapper

        return UtilisateurMapper.toResponse(repo.save(u));
    }

    @Override
    public List<UtilisateurResponse> findAll() {
        return repo.findAll()
                .stream()
                .map(UtilisateurMapper::toResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
package com.jamal.pfe.backend.conteneur.service;

import com.jamal.pfe.backend.conteneur.dto.ConteneurRequest;
import com.jamal.pfe.backend.conteneur.dto.ConteneurResponse;

import java.util.List;

public interface ConteneurService {

    ConteneurResponse create(ConteneurRequest request);

    List<ConteneurResponse> findAll();

    ConteneurResponse findById(Long id);

    ConteneurResponse findByNumeroConteneur(String numeroConteneur);

    ConteneurResponse update(Long id, ConteneurRequest request);

    void delete(Long id);
}
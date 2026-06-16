package com.jamal.pfe.backend.conteneur.service.impl;

import com.jamal.pfe.backend.common.exception.ResourceNotFoundException;
import com.jamal.pfe.backend.conteneur.dto.ConteneurRequest;
import com.jamal.pfe.backend.conteneur.dto.ConteneurResponse;
import com.jamal.pfe.backend.conteneur.entity.Conteneur;
import com.jamal.pfe.backend.conteneur.repository.ConteneurRepository;
import com.jamal.pfe.backend.conteneur.service.ConteneurService;
import com.jamal.pfe.backend.shared.enums.StatutConteneur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConteneurServiceImpl implements ConteneurService {

    private final ConteneurRepository conteneurRepository;

    public ConteneurServiceImpl(ConteneurRepository conteneurRepository) {
        this.conteneurRepository = conteneurRepository;
    }

    @Override
    public ConteneurResponse create(ConteneurRequest request) {
        Conteneur conteneur = new Conteneur();

        conteneur.setNumeroConteneur(request.getNumeroConteneur());
        conteneur.setNomNavire(request.getNomNavire());
        conteneur.setPortOrigine(request.getPortOrigine());
        conteneur.setPortDestination(request.getPortDestination());
        conteneur.setDateArriveePrevue(request.getDateArriveePrevue());
        conteneur.setTypeMarchandise(request.getTypeMarchandise());

        if (request.getStatut() == null) {
            conteneur.setStatut(StatutConteneur.EN_MER);
        } else {
            conteneur.setStatut(request.getStatut());
        }

        return mapToResponse(conteneurRepository.save(conteneur));
    }

    @Override
    public List<ConteneurResponse> findAll() {
        return conteneurRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ConteneurResponse findById(Long id) {
        Conteneur conteneur = conteneurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Conteneur introuvable avec id : " + id));

        return mapToResponse(conteneur);
    }

    public ConteneurResponse findByNumeroConteneur(String numeroConteneur) {
        Conteneur conteneur = conteneurRepository.findByNumeroConteneur(numeroConteneur)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Conteneur introuvable avec numéro : " + numeroConteneur
                ));

        return mapToResponse(conteneur);
    }

    @Override
    public ConteneurResponse update(Long id, ConteneurRequest request) {
        Conteneur conteneur = conteneurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Conteneur introuvable avec id : " + id));

        conteneur.setNumeroConteneur(request.getNumeroConteneur());
        conteneur.setNomNavire(request.getNomNavire());
        conteneur.setPortOrigine(request.getPortOrigine());
        conteneur.setPortDestination(request.getPortDestination());
        conteneur.setDateArriveePrevue(request.getDateArriveePrevue());
        conteneur.setTypeMarchandise(request.getTypeMarchandise());
        conteneur.setStatut(request.getStatut());

        return mapToResponse(conteneurRepository.save(conteneur));
    }

    @Override
    public void delete(Long id) {
        Conteneur conteneur = conteneurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Conteneur introuvable avec id : " + id));

        conteneurRepository.delete(conteneur);
    }

    private ConteneurResponse mapToResponse(Conteneur conteneur) {
        ConteneurResponse response = new ConteneurResponse();

        response.setId(conteneur.getId());
        response.setNumeroConteneur(conteneur.getNumeroConteneur());
        response.setNomNavire(conteneur.getNomNavire());
        response.setPortOrigine(conteneur.getPortOrigine());
        response.setPortDestination(conteneur.getPortDestination());
        response.setDateArriveePrevue(conteneur.getDateArriveePrevue());
        response.setTypeMarchandise(conteneur.getTypeMarchandise());
        response.setStatut(conteneur.getStatut());

        return response;
    }
}
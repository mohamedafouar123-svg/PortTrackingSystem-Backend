package com.jamal.pfe.backend.tracking.service.impl;

import com.jamal.pfe.backend.common.exception.ResourceNotFoundException;
import com.jamal.pfe.backend.conteneur.entity.Conteneur;
import com.jamal.pfe.backend.conteneur.repository.ConteneurRepository;
import com.jamal.pfe.backend.tracking.dto.StatutUpdateRequest;
import com.jamal.pfe.backend.tracking.dto.TrackingResponse;
import com.jamal.pfe.backend.tracking.entity.TrackingHistorique;
import com.jamal.pfe.backend.tracking.repository.TrackingRepository;
import com.jamal.pfe.backend.tracking.service.TrackingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrackingServiceImpl implements TrackingService {

    private final ConteneurRepository conteneurRepository;
    private final TrackingRepository trackingRepository;

    public TrackingServiceImpl(ConteneurRepository conteneurRepository,
                               TrackingRepository trackingRepository) {
        this.conteneurRepository = conteneurRepository;
        this.trackingRepository = trackingRepository;
    }

    @Override
    public TrackingResponse updateStatut(Long conteneurId, StatutUpdateRequest request) {
        Conteneur conteneur = conteneurRepository.findById(conteneurId)
                .orElseThrow(() -> new ResourceNotFoundException("Conteneur introuvable avec id : " + conteneurId));
                if (conteneur.getStatut().equals(request.getNouveauStatut())) {
                    throw new RuntimeException("Le conteneur possède déjà ce statut");
                }
        conteneur.setStatut(request.getNouveauStatut());
        conteneurRepository.save(conteneur);

        TrackingHistorique historique = new TrackingHistorique();
        historique.setConteneur(conteneur);
        historique.setStatut(request.getNouveauStatut());
        historique.setDateChangement(LocalDateTime.now());

        return mapToResponse(trackingRepository.save(historique));
    }

    @Override
    public List<TrackingResponse> historique(Long conteneurId) {
        return trackingRepository.findByConteneurId(conteneurId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private TrackingResponse mapToResponse(TrackingHistorique historique) {
        TrackingResponse response = new TrackingResponse();

        response.setId(historique.getId());
        response.setConteneurId(historique.getConteneur().getId());
        response.setNumeroConteneur(historique.getConteneur().getNumeroConteneur());
        response.setStatut(historique.getStatut());
        response.setDateChangement(historique.getDateChangement());

        return response;
    }
}
package com.jamal.pfe.backend.geolocalisation.service.impl;

import com.jamal.pfe.backend.common.exception.ResourceNotFoundException;
import com.jamal.pfe.backend.common.mapper.GeolocalisationMapper;
import com.jamal.pfe.backend.conteneur.entity.Conteneur;
import com.jamal.pfe.backend.conteneur.repository.ConteneurRepository;
import com.jamal.pfe.backend.geolocalisation.dto.GeolocalisationRequest;
import com.jamal.pfe.backend.geolocalisation.dto.GeolocalisationResponse;
import com.jamal.pfe.backend.geolocalisation.entity.Geolocalisation;
import com.jamal.pfe.backend.geolocalisation.repository.GeolocalisationRepository;
import com.jamal.pfe.backend.geolocalisation.service.GeolocalisationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GeolocalisationServiceImpl implements GeolocalisationService {

    private final GeolocalisationRepository geoRepo;
    private final ConteneurRepository conteneurRepo;

    public GeolocalisationServiceImpl(GeolocalisationRepository geoRepo,
                                     ConteneurRepository conteneurRepo) {
        this.geoRepo = geoRepo;
        this.conteneurRepo = conteneurRepo;
    }

    @Override
    public GeolocalisationResponse create(GeolocalisationRequest request) {

        Conteneur conteneur = conteneurRepo.findById(request.getConteneurId())
                .orElseThrow(() -> new ResourceNotFoundException("Conteneur introuvable"));

        Geolocalisation g = new Geolocalisation();

        g.setLatitude(request.getLatitude());
        g.setLongitude(request.getLongitude());
        g.setDatePosition(LocalDateTime.now());
        g.setConteneur(conteneur);

        return GeolocalisationMapper.toResponse(geoRepo.save(g));
    }

    @Override
    public List<GeolocalisationResponse> findByConteneur(Long conteneurId) {
        return geoRepo.findByConteneurId(conteneurId)
                .stream()
                .map(GeolocalisationMapper::toResponse)
                .toList();
    }
}
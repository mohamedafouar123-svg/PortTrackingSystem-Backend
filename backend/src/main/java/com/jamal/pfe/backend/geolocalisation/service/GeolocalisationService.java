package com.jamal.pfe.backend.geolocalisation.service;

import com.jamal.pfe.backend.geolocalisation.dto.GeolocalisationRequest;
import com.jamal.pfe.backend.geolocalisation.dto.GeolocalisationResponse;

import java.util.List;

public interface GeolocalisationService {

    GeolocalisationResponse create(GeolocalisationRequest request);

    List<GeolocalisationResponse> findByConteneur(Long conteneurId);
}
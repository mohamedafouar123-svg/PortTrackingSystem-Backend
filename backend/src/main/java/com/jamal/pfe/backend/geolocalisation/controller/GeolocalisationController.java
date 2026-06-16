package com.jamal.pfe.backend.geolocalisation.controller;

import com.jamal.pfe.backend.audit.AuditService;
import com.jamal.pfe.backend.geolocalisation.dto.GeolocalisationRequest;
import com.jamal.pfe.backend.geolocalisation.dto.GeolocalisationResponse;
import com.jamal.pfe.backend.geolocalisation.service.GeolocalisationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/geolocalisation")
@CrossOrigin(origins = "*")
public class GeolocalisationController {

    private final GeolocalisationService service;
    private final AuditService auditService;

    public GeolocalisationController(
            GeolocalisationService service,
            AuditService auditService
    ) {
        this.service = service;
        this.auditService = auditService;
    }

    // ==================== CREATE ====================

    @PostMapping
    public GeolocalisationResponse create(
            @RequestBody GeolocalisationRequest request
    ) {

        GeolocalisationResponse response =
                service.create(request);

        auditService.log(
                "AJOUT_GEOLOCALISATION",
                "Ajout position GPS conteneur ID : "
                        + request.getConteneurId()
        );

        return response;
    }

    // ==================== GET BY CONTENEUR ====================

    @GetMapping("/{conteneurId}")
    public List<GeolocalisationResponse> getByConteneur(
            @PathVariable Long conteneurId
    ) {
        return service.findByConteneur(conteneurId);
    }
}
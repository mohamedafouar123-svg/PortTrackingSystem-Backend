package com.jamal.pfe.backend.tracking.controller;

import com.jamal.pfe.backend.audit.AuditService;
import com.jamal.pfe.backend.tracking.dto.StatutUpdateRequest;
import com.jamal.pfe.backend.tracking.dto.TrackingResponse;
import com.jamal.pfe.backend.tracking.service.TrackingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracking")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
public class TrackingController {

    private final TrackingService trackingService;
    private final AuditService auditService;

    public TrackingController(
            TrackingService trackingService,
            AuditService auditService
    ) {
        this.trackingService = trackingService;
        this.auditService = auditService;
    }

    // ==================== UPDATE STATUT ====================

    @PutMapping("/{conteneurId}/statut")
    public TrackingResponse updateStatut(
            @PathVariable Long conteneurId,
            @RequestBody StatutUpdateRequest request
    ) {

        TrackingResponse response =
                trackingService.updateStatut(
                        conteneurId,
                        request
                );

        auditService.log(
                "MODIFICATION_STATUT",
                "Changement statut conteneur ID : "
                        + conteneurId
                        + " -> "
                        + request.getNouveauStatut()
        );

        return response;
    }

    // ==================== HISTORIQUE ====================

    @GetMapping("/{conteneurId}/historique")
    public List<TrackingResponse> historique(
            @PathVariable Long conteneurId
    ) {
        return trackingService.historique(conteneurId);
    }
}
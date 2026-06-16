package com.jamal.pfe.backend.tracking.service;

import com.jamal.pfe.backend.tracking.dto.StatutUpdateRequest;
import com.jamal.pfe.backend.tracking.dto.TrackingResponse;
import java.util.List;

public interface TrackingService {
    TrackingResponse updateStatut(Long conteneurId, StatutUpdateRequest request);
    List<TrackingResponse> historique(Long conteneurId);
}
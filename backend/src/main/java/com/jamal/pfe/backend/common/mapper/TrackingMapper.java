package com.jamal.pfe.backend.common.mapper;

import com.jamal.pfe.backend.tracking.entity.TrackingHistorique;
import com.jamal.pfe.backend.tracking.dto.TrackingResponse;

public class TrackingMapper {

    public static TrackingResponse toResponse(TrackingHistorique historique) {

        TrackingResponse response = new TrackingResponse();

        response.setId(historique.getId());
        response.setConteneurId(historique.getConteneur().getId());
        response.setNumeroConteneur(
                historique.getConteneur().getNumeroConteneur()
        );
        response.setStatut(historique.getStatut());
        response.setDateChangement(historique.getDateChangement());

        return response;
    }
}
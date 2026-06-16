package com.jamal.pfe.backend.common.mapper;

import com.jamal.pfe.backend.geolocalisation.entity.Geolocalisation;
import com.jamal.pfe.backend.geolocalisation.dto.GeolocalisationResponse;

public class GeolocalisationMapper {

    public static GeolocalisationResponse toResponse(Geolocalisation g) {

        GeolocalisationResponse r = new GeolocalisationResponse();

        r.setId(g.getId());
        r.setLatitude(g.getLatitude());
        r.setLongitude(g.getLongitude());
        r.setDatePosition(g.getDatePosition());
        r.setConteneurId(g.getConteneur().getId());

        return r;
    }
}
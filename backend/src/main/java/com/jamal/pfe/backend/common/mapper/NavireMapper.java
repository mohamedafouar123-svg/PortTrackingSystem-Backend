package com.jamal.pfe.backend.common.mapper;

import com.jamal.pfe.backend.navire.dto.NavireRequest;
import com.jamal.pfe.backend.navire.dto.NavireResponse;
import com.jamal.pfe.backend.navire.entity.Navire;

public class NavireMapper {

    public static Navire toEntity(NavireRequest request) {
        Navire navire = new Navire();

        navire.setNom(request.getNom());
        navire.setCompagnie(request.getCompagnie());
        navire.setImmatriculation(request.getImmatriculation());
        navire.setType(request.getType());

        return navire;
    }

    public static NavireResponse toResponse(Navire navire) {
        NavireResponse response = new NavireResponse();

        response.setId(navire.getId());
        response.setNom(navire.getNom());
        response.setCompagnie(navire.getCompagnie());
        response.setImmatriculation(navire.getImmatriculation());
        response.setType(navire.getType());

        return response;
    }
}
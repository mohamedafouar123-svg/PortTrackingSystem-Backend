package com.jamal.pfe.backend.common.mapper;

import com.jamal.pfe.backend.conteneur.entity.Conteneur;
import com.jamal.pfe.backend.conteneur.dto.ConteneurRequest;
import com.jamal.pfe.backend.conteneur.dto.ConteneurResponse;

public class ConteneurMapper {

    public static Conteneur toEntity(ConteneurRequest request) {
        Conteneur c = new Conteneur();

        c.setNumeroConteneur(request.getNumeroConteneur());
        c.setNomNavire(request.getNomNavire());
        c.setPortOrigine(request.getPortOrigine());
        c.setPortDestination(request.getPortDestination());
        c.setDateArriveePrevue(request.getDateArriveePrevue());
        c.setTypeMarchandise(request.getTypeMarchandise());
        c.setStatut(request.getStatut());

        return c;
    }

    public static ConteneurResponse toResponse(Conteneur c) {
        ConteneurResponse r = new ConteneurResponse();

        r.setId(c.getId());
        r.setNumeroConteneur(c.getNumeroConteneur());
        r.setNomNavire(c.getNomNavire());
        r.setPortOrigine(c.getPortOrigine());
        r.setPortDestination(c.getPortDestination());
        r.setDateArriveePrevue(c.getDateArriveePrevue());
        r.setTypeMarchandise(c.getTypeMarchandise());
        r.setStatut(c.getStatut());

        return r;
    }
}
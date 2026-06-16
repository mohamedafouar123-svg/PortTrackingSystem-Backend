package com.jamal.pfe.backend.tracking.dto;

import com.jamal.pfe.backend.shared.enums.StatutConteneur;

public class StatutUpdateRequest {
    private StatutConteneur nouveauStatut;

    public StatutConteneur getNouveauStatut() {
        return nouveauStatut;
    }

    public void setNouveauStatut(StatutConteneur nouveauStatut) {
        this.nouveauStatut = nouveauStatut;
    }
}
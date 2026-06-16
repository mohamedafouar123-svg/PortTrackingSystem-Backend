package com.jamal.pfe.backend.tracking.dto;

import com.jamal.pfe.backend.shared.enums.StatutConteneur;
import java.time.LocalDateTime;

public class TrackingResponse {
    private Long id;
    private Long conteneurId;
    private String numeroConteneur;
    private StatutConteneur statut;
    private LocalDateTime dateChangement;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getConteneurId() { return conteneurId; }
    public void setConteneurId(Long conteneurId) { this.conteneurId = conteneurId; }

    public String getNumeroConteneur() { return numeroConteneur; }
    public void setNumeroConteneur(String numeroConteneur) { this.numeroConteneur = numeroConteneur; }

    public StatutConteneur getStatut() { return statut; }
    public void setStatut(StatutConteneur statut) { this.statut = statut; }

    public LocalDateTime getDateChangement() { return dateChangement; }
    public void setDateChangement(LocalDateTime dateChangement) { this.dateChangement = dateChangement; }
}
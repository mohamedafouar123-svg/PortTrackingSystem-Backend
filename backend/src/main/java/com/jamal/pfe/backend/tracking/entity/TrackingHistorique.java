package com.jamal.pfe.backend.tracking.entity;

import com.jamal.pfe.backend.conteneur.entity.Conteneur;
import com.jamal.pfe.backend.shared.enums.StatutConteneur;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tracking_historique")
public class TrackingHistorique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "conteneur_id", nullable = false)
    private Conteneur conteneur;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutConteneur statut;

    @Column(nullable = false)
    private LocalDateTime dateChangement;

    public TrackingHistorique() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conteneur getConteneur() {
        return conteneur;
    }

    public void setConteneur(Conteneur conteneur) {
        this.conteneur = conteneur;
    }

    public StatutConteneur getStatut() {
        return statut;
    }

    public void setStatut(StatutConteneur statut) {
        this.statut = statut;
    }

    public LocalDateTime getDateChangement() {
        return dateChangement;
    }

    public void setDateChangement(LocalDateTime dateChangement) {
        this.dateChangement = dateChangement;
    }
}
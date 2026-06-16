package com.jamal.pfe.backend.conteneur.entity;

import com.jamal.pfe.backend.shared.enums.StatutConteneur;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "conteneurs")
public class Conteneur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroConteneur;

    @Column(nullable = false)
    private String nomNavire;

    @Column(nullable = false)
    private String portOrigine;

    @Column(nullable = false)
    private String portDestination;

    @Column(nullable = false)
    private LocalDate dateArriveePrevue;

    @Column(nullable = false)
    private String typeMarchandise;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutConteneur statut;

    @Column(name = "client_email")
    private String clientEmail;

    public Conteneur() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroConteneur() {
        return numeroConteneur;
    }

    public void setNumeroConteneur(String numeroConteneur) {
        this.numeroConteneur = numeroConteneur;
    }

    public String getNomNavire() {
        return nomNavire;
    }

    public void setNomNavire(String nomNavire) {
        this.nomNavire = nomNavire;
    }

    public String getPortOrigine() {
        return portOrigine;
    }

    public void setPortOrigine(String portOrigine) {
        this.portOrigine = portOrigine;
    }

    public String getPortDestination() {
        return portDestination;
    }

    public void setPortDestination(String portDestination) {
        this.portDestination = portDestination;
    }

    public LocalDate getDateArriveePrevue() {
        return dateArriveePrevue;
    }

    public void setDateArriveePrevue(LocalDate dateArriveePrevue) {
        this.dateArriveePrevue = dateArriveePrevue;
    }

    public String getTypeMarchandise() {
        return typeMarchandise;
    }

    public void setTypeMarchandise(String typeMarchandise) {
        this.typeMarchandise = typeMarchandise;
    }

    public StatutConteneur getStatut() {
        return statut;
    }

    public void setStatut(StatutConteneur statut) {
        this.statut = statut;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
}
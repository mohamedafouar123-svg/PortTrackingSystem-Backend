package com.jamal.pfe.backend.conteneur.dto;

import com.jamal.pfe.backend.shared.enums.StatutConteneur;
import java.time.LocalDate;

public class ConteneurRequest {
    private String numeroConteneur;
    private String nomNavire;
    private String portOrigine;
    private String portDestination;
    private LocalDate dateArriveePrevue;
    private String typeMarchandise;
    private StatutConteneur statut;
    private String clientEmail;

    public String getNumeroConteneur() { return numeroConteneur; }
    public void setNumeroConteneur(String numeroConteneur) { this.numeroConteneur = numeroConteneur; }

    public String getNomNavire() { return nomNavire; }
    public void setNomNavire(String nomNavire) { this.nomNavire = nomNavire; }

    public String getPortOrigine() { return portOrigine; }
    public void setPortOrigine(String portOrigine) { this.portOrigine = portOrigine; }

    public String getPortDestination() { return portDestination; }
    public void setPortDestination(String portDestination) { this.portDestination = portDestination; }

    public LocalDate getDateArriveePrevue() { return dateArriveePrevue; }
    public void setDateArriveePrevue(LocalDate dateArriveePrevue) { this.dateArriveePrevue = dateArriveePrevue; }

    public String getTypeMarchandise() { return typeMarchandise; }
    public void setTypeMarchandise(String typeMarchandise) { this.typeMarchandise = typeMarchandise; }

    public StatutConteneur getStatut() { return statut; }
    public void setStatut(StatutConteneur statut) { this.statut = statut; }

    public String getClientEmail() { return clientEmail; }
    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }
}
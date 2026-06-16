package com.jamal.pfe.backend.navire.dto;

public class NavireResponse {

    private Long id;
    private String nom;
    private String compagnie;
    private String immatriculation;
    private String type;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getCompagnie() { return compagnie; }
    public void setCompagnie(String compagnie) { this.compagnie = compagnie; }

    public String getImmatriculation() { return immatriculation; }
    public void setImmatriculation(String immatriculation) { this.immatriculation = immatriculation; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
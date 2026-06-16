package com.jamal.pfe.backend.port.dto;

public class PortResponse {

    private Long id;
    private String nom;
    private String pays;
    private String code;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPays() { return pays; }
    public void setPays(String pays) { this.pays = pays; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
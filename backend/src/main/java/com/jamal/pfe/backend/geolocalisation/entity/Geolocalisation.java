package com.jamal.pfe.backend.geolocalisation.entity;

import com.jamal.pfe.backend.conteneur.entity.Conteneur;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "geolocalisation")
public class Geolocalisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;

    private LocalDateTime datePosition;

    @ManyToOne
    @JoinColumn(name = "conteneur_id")
    private Conteneur conteneur;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public LocalDateTime getDatePosition() { return datePosition; }
    public void setDatePosition(LocalDateTime datePosition) { this.datePosition = datePosition; }

    public Conteneur getConteneur() { return conteneur; }
    public void setConteneur(Conteneur conteneur) { this.conteneur = conteneur; }
}
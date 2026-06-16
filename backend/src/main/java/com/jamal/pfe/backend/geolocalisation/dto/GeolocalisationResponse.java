package com.jamal.pfe.backend.geolocalisation.dto;

import java.time.LocalDateTime;

public class GeolocalisationResponse {

    private Long id;
    private double latitude;
    private double longitude;
    private LocalDateTime datePosition;
    private Long conteneurId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public LocalDateTime getDatePosition() { return datePosition; }
    public void setDatePosition(LocalDateTime datePosition) { this.datePosition = datePosition; }

    public Long getConteneurId() { return conteneurId; }
    public void setConteneurId(Long conteneurId) { this.conteneurId = conteneurId; }
}
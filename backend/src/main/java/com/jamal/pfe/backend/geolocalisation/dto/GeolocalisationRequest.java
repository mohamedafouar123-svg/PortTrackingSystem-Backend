package com.jamal.pfe.backend.geolocalisation.dto;

public class GeolocalisationRequest {

    private double latitude;
    private double longitude;
    private Long conteneurId;

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public Long getConteneurId() { return conteneurId; }
    public void setConteneurId(Long conteneurId) { this.conteneurId = conteneurId; }
}
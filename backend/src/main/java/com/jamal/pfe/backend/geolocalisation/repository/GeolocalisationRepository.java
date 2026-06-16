package com.jamal.pfe.backend.geolocalisation.repository;

import com.jamal.pfe.backend.geolocalisation.entity.Geolocalisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeolocalisationRepository extends JpaRepository<Geolocalisation, Long> {
    List<Geolocalisation> findByConteneurId(Long conteneurId);
}
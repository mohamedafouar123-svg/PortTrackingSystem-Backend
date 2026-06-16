package com.jamal.pfe.backend.tracking.repository;

import com.jamal.pfe.backend.tracking.entity.TrackingHistorique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackingRepository extends JpaRepository<TrackingHistorique, Long> {
    List<TrackingHistorique> findByConteneurId(Long conteneurId);
}
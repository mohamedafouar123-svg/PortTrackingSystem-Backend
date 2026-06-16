package com.jamal.pfe.backend.navire.repository;

import com.jamal.pfe.backend.navire.entity.Navire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NavireRepository extends JpaRepository<Navire, Long> {
}
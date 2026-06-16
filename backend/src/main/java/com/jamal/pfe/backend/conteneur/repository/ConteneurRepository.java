package com.jamal.pfe.backend.conteneur.repository;

import com.jamal.pfe.backend.conteneur.entity.Conteneur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConteneurRepository extends JpaRepository<Conteneur, Long> {

    Optional<Conteneur> findByNumeroConteneur(String numeroConteneur);

}
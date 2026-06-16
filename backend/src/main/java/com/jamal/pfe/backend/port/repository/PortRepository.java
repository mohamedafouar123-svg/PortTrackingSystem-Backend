package com.jamal.pfe.backend.port.repository;

import com.jamal.pfe.backend.port.entity.Port;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortRepository extends JpaRepository<Port, Long> {
}
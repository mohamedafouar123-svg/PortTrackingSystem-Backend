package com.jamal.pfe.backend.port.service;

import com.jamal.pfe.backend.port.dto.PortRequest;
import com.jamal.pfe.backend.port.dto.PortResponse;

import java.util.List;

public interface PortService {

    PortResponse create(PortRequest request);

    List<PortResponse> findAll();

    void delete(Long id);
}
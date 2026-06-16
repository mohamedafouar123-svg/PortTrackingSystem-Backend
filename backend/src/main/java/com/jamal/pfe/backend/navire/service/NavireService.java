package com.jamal.pfe.backend.navire.service;

import com.jamal.pfe.backend.navire.dto.NavireRequest;
import com.jamal.pfe.backend.navire.dto.NavireResponse;

import java.util.List;

public interface NavireService {

    NavireResponse create(NavireRequest request);

    List<NavireResponse> findAll();

    void delete(Long id);
}
package com.jamal.pfe.backend.navire.service.impl;

import com.jamal.pfe.backend.common.mapper.NavireMapper;
import com.jamal.pfe.backend.navire.dto.NavireRequest;
import com.jamal.pfe.backend.navire.dto.NavireResponse;
import com.jamal.pfe.backend.navire.entity.Navire;
import com.jamal.pfe.backend.navire.repository.NavireRepository;
import com.jamal.pfe.backend.navire.service.NavireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavireServiceImpl implements NavireService {

    private final NavireRepository repository;

    public NavireServiceImpl(NavireRepository repository) {
        this.repository = repository;
    }

    @Override
    public NavireResponse create(NavireRequest request) {
        Navire navire = NavireMapper.toEntity(request);
        return NavireMapper.toResponse(repository.save(navire));
    }

    @Override
    public List<NavireResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(NavireMapper::toResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
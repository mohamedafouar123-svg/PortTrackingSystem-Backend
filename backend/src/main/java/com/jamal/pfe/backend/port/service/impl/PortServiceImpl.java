package com.jamal.pfe.backend.port.service.impl;

import com.jamal.pfe.backend.common.mapper.PortMapper;
import com.jamal.pfe.backend.port.dto.PortRequest;
import com.jamal.pfe.backend.port.dto.PortResponse;
import com.jamal.pfe.backend.port.entity.Port;
import com.jamal.pfe.backend.port.repository.PortRepository;
import com.jamal.pfe.backend.port.service.PortService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortServiceImpl implements PortService {

    private final PortRepository repo;

    public PortServiceImpl(PortRepository repo) {
        this.repo = repo;
    }

    @Override
    public PortResponse create(PortRequest request) {
        Port p = PortMapper.toEntity(request);
        return PortMapper.toResponse(repo.save(p));
    }

    @Override
    public List<PortResponse> findAll() {
        return repo.findAll()
                .stream()
                .map(PortMapper::toResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
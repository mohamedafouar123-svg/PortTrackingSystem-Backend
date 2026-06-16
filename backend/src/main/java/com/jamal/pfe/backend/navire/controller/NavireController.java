package com.jamal.pfe.backend.navire.controller;

import com.jamal.pfe.backend.navire.dto.NavireRequest;
import com.jamal.pfe.backend.navire.dto.NavireResponse;
import com.jamal.pfe.backend.navire.service.NavireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/navires")
@CrossOrigin(origins = "*")
public class NavireController {

    private final NavireService service;

    public NavireController(NavireService service) {
        this.service = service;
    }

    @PostMapping
    public NavireResponse create(@RequestBody NavireRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<NavireResponse> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
package com.jamal.pfe.backend.port.controller;

import com.jamal.pfe.backend.audit.AuditService;
import com.jamal.pfe.backend.port.dto.PortRequest;
import com.jamal.pfe.backend.port.dto.PortResponse;
import com.jamal.pfe.backend.port.service.PortService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ports")
@CrossOrigin(origins = "*")
public class PortController {

    private final PortService service;
    private final AuditService auditService;

    public PortController(
            PortService service,
            AuditService auditService
    ) {
        this.service = service;
        this.auditService = auditService;
    }

    // ==================== CREATE ====================

    @PostMapping
    public PortResponse create(
            @RequestBody PortRequest request
    ) {

        PortResponse response =
                service.create(request);

        auditService.log(
                "AJOUT_PORT",
                "Ajout du port : " + request.getNom()
        );

        return response;
    }

    // ==================== GET ALL ====================

    @GetMapping
    public List<PortResponse> findAll() {
        return service.findAll();
    }

    // ==================== DELETE ====================

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        service.delete(id);

        auditService.log(
                "SUPPRESSION_PORT",
                "Suppression du port ID : " + id
        );
    }
}
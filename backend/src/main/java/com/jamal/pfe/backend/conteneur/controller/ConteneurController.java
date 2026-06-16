package com.jamal.pfe.backend.conteneur.controller;

import com.jamal.pfe.backend.audit.AuditService;
import com.jamal.pfe.backend.conteneur.dto.ConteneurRequest;
import com.jamal.pfe.backend.conteneur.dto.ConteneurResponse;
import com.jamal.pfe.backend.conteneur.service.ConteneurService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conteneurs")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class ConteneurController {

    private final ConteneurService conteneurService;
    private final AuditService auditService;

    public ConteneurController(
            ConteneurService conteneurService,
            AuditService auditService
    ) {
        this.conteneurService = conteneurService;
        this.auditService = auditService;
    }

    // ==================== CREATE ====================

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN')")
    public ConteneurResponse create(@RequestBody ConteneurRequest request) {

        ConteneurResponse response = conteneurService.create(request);

        auditService.log(
                "AJOUT_CONTENEUR",
                "Ajout du conteneur : " + request.getNumeroConteneur()
        );

        return response;
    }

    // ==================== GET ALL ====================

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN', 'CLIENT')")
    public List<ConteneurResponse> findAll() {
        return conteneurService.findAll();
    }

    // ==================== GET BY ID ====================

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN', 'CLIENT')")
    public ConteneurResponse findById(@PathVariable Long id) {
        return conteneurService.findById(id);
    }

    // ==================== GET BY NUMERO ====================

    @GetMapping("/numero/{numero}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN', 'CLIENT')")
    public ConteneurResponse findByNumeroConteneur(
            @PathVariable String numero
    ) {
        return conteneurService.findByNumeroConteneur(numero);
    }

    // ==================== UPDATE ====================

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN')")
    public ConteneurResponse update(
            @PathVariable Long id,
            @RequestBody ConteneurRequest request
    ) {

        ConteneurResponse response = conteneurService.update(id, request);

        auditService.log(
                "MODIFICATION_CONTENEUR",
                "Modification du conteneur ID : " + id
        );

        return response;
    }

    // ==================== DELETE ====================

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN')")
    public void delete(@PathVariable Long id) {

        conteneurService.delete(id);

        auditService.log(
                "SUPPRESSION_CONTENEUR",
                "Suppression du conteneur ID : " + id
        );
    }
}
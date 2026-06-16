package com.jamal.pfe.backend.utilisateur.controller;

import com.jamal.pfe.backend.audit.AuditService;
import com.jamal.pfe.backend.utilisateur.dto.UtilisateurRequest;
import com.jamal.pfe.backend.utilisateur.dto.UtilisateurResponse;
import com.jamal.pfe.backend.utilisateur.service.UtilisateurService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
@PreAuthorize("hasRole('SUPER_ADMIN')")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final AuditService auditService;

    public UtilisateurController(
            UtilisateurService utilisateurService,
            AuditService auditService
    ) {
        this.utilisateurService = utilisateurService;
        this.auditService = auditService;
    }

    @GetMapping
    public List<UtilisateurResponse> findAll() {
        return utilisateurService.findAll();
    }

    @PostMapping
    public UtilisateurResponse create(@RequestBody UtilisateurRequest request) {
        UtilisateurResponse response = utilisateurService.create(request);

        auditService.log(
                "CREATION_ADMIN",
                "Création admin : " + request.getEmail()
        );

        return response;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        utilisateurService.delete(id);

        auditService.log(
                "SUPPRESSION_UTILISATEUR",
                "Suppression utilisateur ID : " + id
        );
    }
}
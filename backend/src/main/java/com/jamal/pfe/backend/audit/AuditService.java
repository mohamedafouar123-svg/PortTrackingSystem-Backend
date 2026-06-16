package com.jamal.pfe.backend.audit;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    private final AuditLogRepository repo;

    public AuditService(AuditLogRepository repo) {
        this.repo = repo;
    }

    public void log(String action, String details) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String email = "system";
        String role = "UNKNOWN";

        if (auth != null && auth.isAuthenticated()) {
            email = auth.getName();

            if (!auth.getAuthorities().isEmpty()) {
                role = auth.getAuthorities().iterator().next().getAuthority();
            }
        }

        repo.save(new AuditLog(email, role, action, details));
    }
}
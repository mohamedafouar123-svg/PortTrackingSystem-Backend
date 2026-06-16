package com.jamal.pfe.backend.audit;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private String role;
    private String action;

    @Column(length = 1000)
    private String details;

    private LocalDateTime dateAction;

    public AuditLog() {}

    public AuditLog(String userEmail, String role, String action, String details) {
        this.userEmail = userEmail;
        this.role = role;
        this.action = action;
        this.details = details;
        this.dateAction = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getUserEmail() { return userEmail; }
    public String getRole() { return role; }
    public String getAction() { return action; }
    public String getDetails() { return details; }
    public LocalDateTime getDateAction() { return dateAction; }

    public void setId(Long id) { this.id = id; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public void setRole(String role) { this.role = role; }
    public void setAction(String action) { this.action = action; }
    public void setDetails(String details) { this.details = details; }
    public void setDateAction(LocalDateTime dateAction) { this.dateAction = dateAction; }
}
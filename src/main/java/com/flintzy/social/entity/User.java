package com.flintzy.social.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String provider;   // GOOGLE / LOCAL / GITHUB etc.

    @Column(nullable = false)
    private String role;       // USER / ADMIN

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getProvider() {
        return provider;
    }

    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

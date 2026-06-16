package com.jamal.pfe.backend.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    // ─────────────────────────────────────
    // Password Encoder
    // ─────────────────────────────────────

    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    // ─────────────────────────────────────
    // Security Filter Chain
    // ─────────────────────────────────────

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // Disable CSRF
                .csrf(csrf -> csrf.disable())

                // Enable CORS
                .cors(Customizer.withDefaults())

                // Disable form login
                .formLogin(form -> form.disable())

                // Disable basic auth
                .httpBasic(basic -> basic.disable())

                // H2 console
                .headers(headers ->
                        headers.frameOptions(frame -> frame.disable())
                )

                // Stateless session
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // Authorization
                .authorizeHttpRequests(auth -> auth

                        // ─────────────────────────
                        // PUBLIC ENDPOINTS
                        // ─────────────────────────
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/error").permitAll()

                        // ─────────────────────────
                        // GET ACCESS (READ ONLY)
                        // CLIENT + ADMIN + SUPER_ADMIN
                        // ─────────────────────────

                        .requestMatchers(HttpMethod.GET, "/api/conteneurs/**")
                        .hasAnyRole("SUPER_ADMIN", "ADMIN", "CLIENT")

                        .requestMatchers(HttpMethod.GET, "/api/tracking/**")
                        .hasAnyRole("SUPER_ADMIN", "ADMIN", "CLIENT")

                        .requestMatchers(HttpMethod.GET, "/api/geolocalisation/**")
                        .hasAnyRole("SUPER_ADMIN", "ADMIN", "CLIENT")

                        // ─────────────────────────
                        // ADMIN / SUPER_ADMIN ONLY
                        // CREATE - UPDATE - DELETE
                        // ─────────────────────────

                        .requestMatchers("/api/conteneurs/**")
                        .hasAnyRole("SUPER_ADMIN", "ADMIN")

                        .requestMatchers("/api/tracking/**")
                        .hasAnyRole("SUPER_ADMIN", "ADMIN")

                        .requestMatchers("/api/geolocalisation/**")
                        .hasAnyRole("SUPER_ADMIN", "ADMIN")

                        // ─────────────────────────
                        // SUPER_ADMIN ONLY
                        // ─────────────────────────

                        .requestMatchers("/api/utilisateurs/**")
                        .hasRole("SUPER_ADMIN")

                        .requestMatchers("/api/audit/**")
                        .hasRole("SUPER_ADMIN")

                        // ─────────────────────────
                        // EVERYTHING ELSE
                        // ─────────────────────────

                        .anyRequest().authenticated()
                )

                // JWT Filter
                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }
}
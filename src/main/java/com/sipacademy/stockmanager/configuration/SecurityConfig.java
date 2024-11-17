package com.sipacademy.stockmanager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
            .anyRequest().permitAll() // Autoriser toutes les requêtes sans authentification
            .and()
            .csrf().disable(); // Désactiver CSRF si nécessaire
        return http.build();
    }
}
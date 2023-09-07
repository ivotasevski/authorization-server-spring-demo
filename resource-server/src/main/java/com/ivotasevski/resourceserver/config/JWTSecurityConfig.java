package com.ivotasevski.resourceserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class JWTSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authz -> authz
                        .anyRequest()
                        .hasAuthority("SCOPE_my.custom.scope"))
                .oauth2ResourceServer(oauth2 -> oauth2.jwt());
        return http.build();
    }
}
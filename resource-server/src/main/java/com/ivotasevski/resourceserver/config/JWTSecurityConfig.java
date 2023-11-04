package com.ivotasevski.resourceserver.config;

import com.ivotasevski.resourceserver.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class JWTSecurityConfig {

    @Bean
    public JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter() {
        return new JwtGrantedAuthoritiesConverter();
    }

    @Bean
    public Converter<Jwt, AbstractAuthenticationToken> customJwtAuthenticationConverter(
            JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter,
            AccountService accountService) {
        return new CustomJwtAuthenticationConverter(
                accountService,
                jwtGrantedAuthoritiesConverter);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           Converter<Jwt, AbstractAuthenticationToken> customJwtAuthenticationConverter) throws Exception {
        http.authorizeRequests(authz -> authz
                        .anyRequest()
                        .hasAuthority("SCOPE_my.custom.scope"))
                .oauth2ResourceServer(oauth2 -> oauth2.jwt().jwtAuthenticationConverter(customJwtAuthenticationConverter));
        return http.build();
    }
}
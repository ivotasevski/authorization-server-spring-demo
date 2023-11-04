package com.ivotasevski.resourceserver.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;

public class AccountToken extends JwtAuthenticationToken {
    private static final long serialVersionUID = 1L;
    private final CustomAccount account;

    public AccountToken(Jwt jwt, Collection<? extends GrantedAuthority> authorities, String name, CustomAccount account) {
        super(jwt, authorities, name);
        this.account = account;
    }

    public CustomAccount getAccount() {
        return account;
    }
}
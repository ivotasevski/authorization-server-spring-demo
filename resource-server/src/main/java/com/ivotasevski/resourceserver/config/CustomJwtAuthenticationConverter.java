package com.ivotasevski.resourceserver.config;

import com.ivotasevski.resourceserver.service.AccountService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;

import java.util.Collection;

public class CustomJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private final Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter;
    private AccountService accountService;

    public CustomJwtAuthenticationConverter(AccountService accountService, Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter) {
        this.accountService = accountService;
        this.jwtGrantedAuthoritiesConverter = jwtGrantedAuthoritiesConverter;
    }

    @Override
    public AbstractAuthenticationToken convert(Jwt source) {

        Collection<GrantedAuthority> authorities = jwtGrantedAuthoritiesConverter.convert(source);
        String principalClaimValue = source.getClaimAsString(JwtClaimNames.SUB);
        CustomAccount acc = accountService.getAccount(principalClaimValue);
        return new AccountToken(source, authorities, principalClaimValue, acc);
    }

}
package com.ivotasevski.authserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ConfigurationProperties(prefix = "com-ivo-oauth2-auth-server")
public class OAuth2AuthServerProperties {

    private List<OAuthClient> clients;

    public List<OAuthClient> getClients() {
        return clients;
    }

    public void setClients(List<OAuthClient> clients) {
        this.clients = clients;
    }

    public static class OAuthClient {
        private String clientId;
        private String clientSecret;
        private String scopes;

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public void setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
        }

        public List<String> getScopes() {
            if (scopes == null) {
                return new ArrayList<>();
            }
            return Arrays.stream(scopes.split(",")).toList();
        }

        public void setScopes(String scopes) {
            this.scopes = scopes;
        }
    }
}

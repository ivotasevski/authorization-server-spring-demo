package com.ivotasevski.resourceserver.service;

import com.ivotasevski.resourceserver.config.CustomAccount;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {

    public CustomAccount getAccount(String principal) {
        // query DB or other source
        return new CustomAccount(principal + "_" + UUID.randomUUID().toString());
    }
}
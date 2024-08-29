package com.example.security_database_demo.service;

import com.example.security_database_demo.payload.RegistrationRequest;

public interface RegistrationService {
    void save(RegistrationRequest registrationRequest);
}

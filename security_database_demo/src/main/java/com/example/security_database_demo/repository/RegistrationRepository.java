package com.example.security_database_demo.repository;

import com.example.security_database_demo.payload.RegistrationRequest;
import com.example.security_database_demo.service.RegistrationService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationRepository implements RegistrationService {
    private final JdbcTemplate jdbcTemplate;

    public RegistrationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(RegistrationRequest registrationRequest) {
        System.out.println("I am RegistrationRepository object.");
        System.out.println(registrationRequest);
        String firstName = registrationRequest.firstName();
        String lastName = registrationRequest.lastName();
        String username = registrationRequest.username();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
        String password = bCryptPasswordEncoder.encode(registrationRequest.password());
        boolean enabled = true;
        String role = "ROLE_USER";
        jdbcTemplate.update(
                "INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)",
                new Object[]{username, password, enabled}
        );
        jdbcTemplate.update(
                "INSERT INTO authorities (username, authority) VALUES (?, ?)",
                new Object[]{username, role}
        );

        jdbcTemplate.update(
                "INSERT INTO fullname_users (username, first_name, last_name) VALUES (?, ?, ?)",
                new Object[]{username, firstName, lastName}
        );

    }
}

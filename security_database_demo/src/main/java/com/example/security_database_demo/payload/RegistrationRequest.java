package com.example.security_database_demo.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegistrationRequest(
		
        @NotBlank(message = "The firstName is required.")
        @Size(min = 1, max = 20, message = "The firstName must be from 3 to 20 characters.")
        String firstName,

        @NotBlank(message = "The lastName is required.")
        @Size(min = 1, max = 20, message = "The lastName must be from 3 to 20 characters.")
        String lastName,

        @NotBlank(message = "The username is required.")
        @Size(min = 1, max = 20, message = "The username must be from 3 to 20 characters.")
        String username,

        @NotBlank(message = "The password is required.")
        @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$", message = "Password must be 8 characters long and combination of uppercase letters, lowercase letters, numbers, special characters.")
        String password
) {
}

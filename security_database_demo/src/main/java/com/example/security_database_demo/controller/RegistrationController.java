package com.example.security_database_demo.controller;

import com.example.security_database_demo.payload.RegistrationRequest;
import com.example.security_database_demo.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @GetMapping
    public String registration(Model model) {
        RegistrationRequest attributeValue =
                new RegistrationRequest("Almaz", "Begaliev",
                        "abegaliev", "Password1@");
        model.addAttribute("registrationRequest", attributeValue);
        return "registration";
    }

    @PostMapping
    public String greetingSubmit(
            @Valid @ModelAttribute RegistrationRequest registrationRequest,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        service.save(registrationRequest);
        return "result";
    }
}

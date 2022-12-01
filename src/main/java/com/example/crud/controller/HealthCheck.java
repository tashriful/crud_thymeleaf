package com.example.crud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/healthcheck")
public class HealthCheck {
    @GetMapping
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("Server is active and running");
    }
}

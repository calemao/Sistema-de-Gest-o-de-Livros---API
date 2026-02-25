package br.com.christianamsberg.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HomeController {
    
    @GetMapping
    public ResponseEntity<Map<String, String>> home() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Bem-vindo ao Sistema de Gestão de Biblioteca");
        response.put("version", "1.0.0");
        response.put("status", "Running");
        return ResponseEntity.ok(response);
    }
}

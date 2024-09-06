package com.example.gerenciamentotarefas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")  // Mapeia a URL raiz para este método
    public String home() {
        return "Bem-vindo à aplicação de gerenciamento de tarefas!";
    }
}


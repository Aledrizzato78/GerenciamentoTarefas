package com.example.gerenciamentotarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.gerenciamentotarefas")
public class GerenciamentoTarefasApplication {

    public static void main(String[] args) {
        SpringApplication.run(GerenciamentoTarefasApplication.class, args);
    }

}
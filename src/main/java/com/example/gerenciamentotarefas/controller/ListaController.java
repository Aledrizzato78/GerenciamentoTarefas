package com.example.gerenciamentotarefas.controller;

import com.example.gerenciamentotarefas.entity.ListaService;
import com.example.gerenciamentotarefas.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listas")
public class ListaController {

    @Autowired
    private ListaService listaService;

    // Criar uma nova lista
    @PostMapping
    public ListaService criarLista(@RequestBody String nome) {
        return listaService.criarLista(nome);
    }

    // Obter todas as listas
    @GetMapping
    public List<ListaService> listarListas() {
        return listaService.listarTodas();
    }

    // Atualizar o nome de uma lista
    @PutMapping("/{id}")
    public ListaService atualizarLista(@PathVariable Long id, @RequestBody String novoNome) {
        return listaService.atualizarLista(id, novoNome);
    }

    // Deletar uma lista
    @DeleteMapping("/{id}")
    public void deletarLista(@PathVariable Long id) {
        listaService.deletarLista(id);
    }
}

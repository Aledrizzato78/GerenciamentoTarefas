package com.example.gerenciamentotarefas.controller;

import com.example.gerenciamentotarefas.entity.Item;
import com.example.gerenciamentotarefas.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Retorna todos os itens
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // Retorna um item específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Optional<Item> itemOptional = itemService.getItemById(id);
        return itemOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Adiciona um novo item com validação
    @PostMapping
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) {
        Item novoItem = itemService.addItem(item);
        return ResponseEntity.ok(novoItem);
    }

    // Atualiza um item existente
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @Valid @RequestBody Item updatedItem) {
        try {
            return ResponseEntity.ok(itemService.updateItem(id, updatedItem));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Deleta um item pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    // Filtra itens pela prioridade
    @GetMapping("/prioridade")
    public List<Item> listarItensPorPrioridade(@RequestParam boolean prioridade) {
        return itemService.listarItensPorPrioridade(prioridade);
    }

    // Ordena itens pela prioridade (primeiro os itens prioritários)
    @GetMapping("/ordenar-prioridade")
    public List<Item> listarTodosOrdenadosPorPrioridade() {
        return itemService.listarTodosOrdenadosPorPrioridade();
    }

    // Filtra itens por estado e prioridade
    @GetMapping("/filtrar")
    public List<Item> listarItensPorEstadoEPrioridade(@RequestParam boolean concluido, @RequestParam boolean prioridade) {
        return itemService.listarItensPorEstadoEPrioridade(concluido, prioridade);
    }
}

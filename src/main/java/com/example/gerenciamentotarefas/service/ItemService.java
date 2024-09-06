package com.example.gerenciamentotarefas.service;

import com.example.gerenciamentotarefas.entity.Item;
import com.example.gerenciamentotarefas.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Retorna todos os itens
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Busca um item pelo ID
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    // Salva um novo item
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    // Atualiza um item existente
    public Item updateItem(Long id, Item updatedItem) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            item.setNome(updatedItem.getNome());
            item.setDescricao(updatedItem.getDescricao());
            item.setConcluido(updatedItem.isConcluido());
            return itemRepository.save(item);
        } else {
            throw new IllegalArgumentException("Item com ID " + id + " não encontrado.");
        }
    }

    // Deleta um item pelo ID
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    // Filtrar itens pelo estado (concluído ou não)
    public List<Item> listarItensPorEstado(boolean concluido) {
        return itemRepository.findByConcluido(concluido);
    }

    // Filtrar itens pela prioridade
    public List<Item> listarItensPorPrioridade(boolean prioridade) {
        return itemRepository.findByPrioridade(prioridade);
    }

    // Ordenar itens pela prioridade
    public List<Item> listarTodosOrdenadosPorPrioridade() {
        return itemRepository.findAllByOrderByPrioridadeDesc();
    }

    public List<Item> listarItensPorEstadoEPrioridade(boolean concluido, boolean prioridade) {
        return List.of();
    }
}




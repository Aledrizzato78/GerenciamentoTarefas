package com.example.gerenciamentotarefas.repository;

import com.example.gerenciamentotarefas.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    // Método para filtrar itens pelo estado concluído
    List<Item> findByConcluido(boolean concluido);

    // Método para filtrar itens pela prioridade
    List<Item> findByPrioridade(boolean prioridade);

    // Método para ordenar os itens pela prioridade (primeiro os prioritários)
    List<Item> findAllByOrderByPrioridadeDesc();
}

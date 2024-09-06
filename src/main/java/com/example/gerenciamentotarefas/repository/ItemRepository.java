package com.example.gerenciamentotarefas.repository;

import com.example.gerenciamentotarefas.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Aqui você pode definir consultas personalizadas se necessário
}

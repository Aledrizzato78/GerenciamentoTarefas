package com.example.gerenciamentotarefas.repository;

import com.example.gerenciamentotarefas.entity.ListaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends JpaRepository<ListaService, Long> {
}

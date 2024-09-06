package com.example.gerenciamentotarefas.repository;

import com.example.gerenciamentotarefas.entity.Lista;
import com.example.gerenciamentotarefas.service.ListaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends CrudRepository<Lista, Long> {
}


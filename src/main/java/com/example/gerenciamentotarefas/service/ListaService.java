package com.example.gerenciamentotarefas.service;

import com.example.gerenciamentotarefas.entity.Item;
import com.example.gerenciamentotarefas.entity.Lista;
import com.example.gerenciamentotarefas.repository.ItemRepository;
import com.example.gerenciamentotarefas.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;  // Repositório para gerenciar as operações no banco de dados

    @Autowired
    private ItemRepository itemRepository;  // Repositório de itens

    // Criar uma nova lista
    public Lista criarLista(String nome) {
        Lista lista = new Lista(nome);
        return listaRepository.save(lista);
    }

    // Adicionar um item a uma lista existente
    public Item adicionarItem(Long listaId, String titulo, boolean prioridade) {
        Optional<Lista> listaOpt = listaRepository.findById(listaId);
        if (listaOpt.isPresent()) {
            Lista lista = listaOpt.get();
            Item item = new Item(titulo, prioridade);
            item.setLista(lista);
            lista.getItens().add(item);
            itemRepository.save(item); // Salva o item no banco de dados
            listaRepository.save(lista); // Atualiza a lista com o novo item
            return item;
        } else {
            throw new RuntimeException("Lista não encontrada");
        }
    }

    // Obter todas as listas
    public Iterable<Lista> listarTodas() {
        return listaRepository.findAll();
    }

    // Deletar uma lista por ID
    public void deletarLista(Long listaId) {
        Optional<Lista> lista = listaRepository.findById(listaId);
        if (lista.isPresent()) {
            listaRepository.delete(lista.get());
        } else {
            throw new RuntimeException("Lista não encontrada");
        }
    }

    // Atualizar o nome de uma lista
    public Lista atualizarLista(Long listaId, String novoNome) {
        Optional<Lista> listaOpt = listaRepository.findById(listaId);
        if (listaOpt.isPresent()) {
            Lista lista = listaOpt.get();
            lista.setNome(novoNome);
            return listaRepository.save(lista);
        } else {
            throw new RuntimeException("Lista não encontrada");
        }
    }
}

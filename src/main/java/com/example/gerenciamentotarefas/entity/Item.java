package com.example.gerenciamentotarefas.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do item não pode estar em branco.")
    @Size(min = 3, max = 100, message = "O nome do item deve ter entre 3 e 100 caracteres.")
    @Column(nullable = false)
    private String nome;

    @Size(max = 255, message = "A descrição não pode ter mais de 255 caracteres.")
    private String descricao;

    private boolean concluido;

    private boolean prioridade;

    @ManyToOne
    @JoinColumn(name = "lista_id", nullable = false)
    @NotNull(message = "Cada item deve estar associado a uma lista.")
    private Lista lista;

    // Construtores
    public Item() {}

    public Item(String nome, String descricao, boolean prioridade, Lista lista) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.lista = lista;
        this.concluido = false; // por padrão, o item é não concluído
    }

    public Item(String titulo, boolean prioridade) {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public boolean isPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}

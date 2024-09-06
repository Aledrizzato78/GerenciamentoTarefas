package com.example.gerenciamentotarefas.entity;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    private boolean concluido;

    // Adicionando o relacionamento ManyToOne com Lista
    @ManyToOne
    @JoinColumn(name = "lista_id", nullable = false)
    private Lista lista;

    // Construtores
    public Item(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.concluido = false;
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

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}

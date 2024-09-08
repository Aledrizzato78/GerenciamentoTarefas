package com.example.gerenciamentotarefas.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "items")
public class Item {

    private static final String titulo = new String();;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do item não pode estar em branco.")
    @Size(min = 3, max = 100, message = "O nome do item deve ter entre 3 e 100 caracteres.")
    @Column(nullable = false)
    private String nome;

    @Size(max = 255, message = "A descrição não pode ter mais de 255 caracteres.")
    private String descricao;

    @Column(nullable = false)
    private boolean concluido;

    @Column(nullable = false)
    private boolean prioridade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lista_id")
    private Lista lista;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    // Construtores
    public Item(String titulo, boolean prioridade) {
        this.dataCriacao = LocalDateTime.now();
    }

    public Item(String nome, String descricao, boolean prioridade) {
        this(titulo, prioridade);
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluido = false;
    }

    public Item() {

    }

    public Item(String s, String s1, boolean b, Object o) {
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    // Métodos utilitários
    public void marcarComoConcluido() {
        this.concluido = true;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public void desmarcarComoConcluido() {
        this.concluido = false;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public void togglePrioridade() {
        this.prioridade = !this.prioridade;
        this.dataAtualizacao = LocalDateTime.now();
    }

    // Equals e HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // ToString
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", concluido=" + concluido +
                ", prioridade=" + prioridade +
                ", dataCriacao=" + dataCriacao +
                '}';
    }

    // Método para atualizar a data de atualização
    @PreUpdate
    protected void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}
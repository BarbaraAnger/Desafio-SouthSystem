package com.southsystem.desafio.model;

import org.springframework.stereotype.Component;

@Component
public class Item {
    private String id;
    private Integer quantidade;
    private Double preco;

    public Item() {
    }

    public Item(String id, Integer quantidade, Double preco) {
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}

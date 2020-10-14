package com.southsystem.desafio.model;

import java.util.Arrays;
import java.util.List;

public class Item {
    String id;
    Integer quantidade;
    Double preco;

    public Item mapearEntidade(String item) {
        List<String> informacoes;
        informacoes = Arrays.asList(item.split("-"));

        this.id = informacoes.get(0);
        this.quantidade = Integer.valueOf(informacoes.get(1));
        this.preco = Double.valueOf(informacoes.get(2));

        return this;
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

}

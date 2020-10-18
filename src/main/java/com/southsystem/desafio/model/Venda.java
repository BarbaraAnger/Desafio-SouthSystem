package com.southsystem.desafio.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Venda implements IDados {
    String idVenda;
    List<Item> listaDeItens;
    String nomeDoVendedor;

    @Override
    public Venda mapearDados(Object dados) {
        String linha = (String) dados;
        List<String> informacoes;
        String itens;
        listaDeItens = new ArrayList<>();

        informacoes = Arrays.asList(linha.split("ç"));
        this.idVenda = informacoes.get(1);

        itens = informacoes.get(2);
        itens = itens.substring(1, itens.length() - 1);

        for (String info : itens.split(",")) {
            Item item = new Item();
            listaDeItens.add(item.mapearEntidade(info));
        }
        this.nomeDoVendedor = informacoes.get(3);
        return this;
    }

    @Override
    public String getIdEntidade() {
        return "003";
    }

    @Override
    public String getIdentificadorUnico() {
        return this.nomeDoVendedor;
    }

    @Override
    public String getNome() {
        return this.nomeDoVendedor;
    }

    public String getIdVenda() {
        return idVenda;
    }

    public List<Item> getListaDeItens() {
        return listaDeItens;
    }

    public Double somarValorTotalDaVenda() {
        double valorTotalDaVenda = 0;
        for (Item item : listaDeItens) {
            valorTotalDaVenda =+ item.getPreco() * item.getQuantidade();
        }
        return valorTotalDaVenda;
    }

}

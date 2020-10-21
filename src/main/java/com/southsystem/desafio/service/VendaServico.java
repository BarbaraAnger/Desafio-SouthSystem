package com.southsystem.desafio.service;

import com.southsystem.desafio.model.IDados;
import com.southsystem.desafio.model.Item;
import com.southsystem.desafio.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VendaServico implements IDadosServico {
    private Venda venda;
    private List<Item> listaDeItens;

    public VendaServico() {
        venda = new Venda();
    }

    @Autowired
    public VendaServico(Venda venda) {
        this.venda = venda;
    }

    @Override
    public IDados mapearDados(Object dados) {
        String linha = (String) dados;
        List<String> informacoes;
        String itens;
        listaDeItens = new ArrayList<>();

        informacoes = Arrays.asList(linha.split("ç"));

        itens = informacoes.get(2);
        itens = itens.substring(1, itens.length() - 1);

        for (String info : itens.split(",")) {
            ItemServico itemServico = new ItemServico(new Item());
            listaDeItens.add(itemServico.mapearEntidade(info));
        }

        return new Venda(informacoes.get(1), listaDeItens, informacoes.get(3));
    }

    public Double somarValorTotalDaVenda(Venda venda) {
        double valorTotalDaVenda = 0;
        List<Item> listaDeItens = venda.getListaDeItens();
        for (Item item : listaDeItens) {
            valorTotalDaVenda =+ item.getPreco() * item.getQuantidade();
        }
        return valorTotalDaVenda;
    }

    @Override
    public String getIdEntidade() {
        return venda.getIdEntidade();
    }

    @Override
    public Venda getEntidade() {
        return this.venda;
    }
}

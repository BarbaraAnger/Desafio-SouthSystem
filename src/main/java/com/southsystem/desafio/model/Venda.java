package com.southsystem.desafio.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Venda implements IDados {
    private String idVenda;
    private List<Item> listaDeItens;
    private String nomeDoVendedor;

    public Venda() {
    }

    public Venda(String idVenda, List<Item> listaDeItens, String nomeDoVendedor) {
        this.idVenda = idVenda;
        this.listaDeItens = listaDeItens;
        this.nomeDoVendedor = nomeDoVendedor;
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

    public String getNomeDoVendedor() {
        return nomeDoVendedor;
    }
}

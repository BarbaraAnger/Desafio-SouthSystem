package com.southsystem.desafio.dominio;

import java.util.Arrays;
import java.util.List;

public class Cliente implements IDados {
    private String nome;
    private String cnpj;
    private String businessArea;

    @Override
    public Cliente mapearDados(Object dados) {
        String linha = (String) dados;
        List<String> informacoes;
        informacoes = Arrays.asList(linha.split("ç"));
        this.cnpj = informacoes.get(1);
        this.nome = informacoes.get(2);
        this.businessArea = informacoes.get(3);

        return this;
    }

    @Override
    public String getIdEntidade() {
        return "002";
    }

    @Override
    public String getIdentificadorUnico() {
        return this.getCnpj();
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getBusinessArea() {
        return businessArea;
    }

}

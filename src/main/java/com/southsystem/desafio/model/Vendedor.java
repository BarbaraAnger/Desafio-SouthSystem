package com.southsystem.desafio.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Vendedor implements IDados {
    String cpf;
    String nome;
    BigDecimal salario;
    Double rendimentosTotais;

    @Override
    public Vendedor mapearDados(Object dados) {
        String linha = (String) dados;
        List<String> informacoes;
        informacoes = Arrays.asList(linha.split("ç"));

        this.cpf = informacoes.get(1);
        this.nome = informacoes.get(2);
        this.salario = new BigDecimal(informacoes.get(3));

        return this;
    }

    @Override
    public String getIdEntidade() {
        return "001";
    }

    @Override
    public String getIdentificadorUnico() {
        return this.getCpf();
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Double getRendimentosTotais() {
        return rendimentosTotais;
    }

    public void setRendimentosTotais(Double rendimentosTotais) {
        this.rendimentosTotais = rendimentosTotais;
    }
}

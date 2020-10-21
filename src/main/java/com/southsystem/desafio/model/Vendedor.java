package com.southsystem.desafio.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Vendedor implements IDados {
    String cpf;
    String nome;
    BigDecimal salario;
    Double rendimentosTotais;

    public Vendedor() {
    }

    public Vendedor(String cpf, String nome, BigDecimal salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
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

    public Double getRendimentosTotais() {
        return rendimentosTotais;
    }

    public void setRendimentosTotais(Double rendimentosTotais) {
        this.rendimentosTotais = rendimentosTotais;
    }

}

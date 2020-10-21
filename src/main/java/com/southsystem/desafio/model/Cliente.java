package com.southsystem.desafio.model;

import org.springframework.stereotype.Component;

@Component
public class Cliente implements IDados {
    private String nome;
    private String cnpj;
    private String businessArea;

    public Cliente() {
    }

    public Cliente(String nome, String cnpj, String businessArea) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.businessArea = businessArea;
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

    @Override
    public String toString() {
        return getNome() + getBusinessArea() + getIdEntidade();
    }

}

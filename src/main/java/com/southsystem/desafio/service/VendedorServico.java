package com.southsystem.desafio.service;

import com.southsystem.desafio.model.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class VendedorServico implements IDadosServico {
    private Vendedor vendedor;

    public VendedorServico() {
        vendedor = new Vendedor();
    }

    @Autowired
    public VendedorServico(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public Vendedor mapearDados(Object dados) {
        String linha = (String) dados;
        List<String> informacoes;
        informacoes = Arrays.asList(linha.split("ç"));

        return new Vendedor(informacoes.get(1), informacoes.get(2), new BigDecimal(informacoes.get(3)));
    }

    @Override
    public String getIdEntidade() {
        return vendedor.getIdEntidade();
    }

    @Override
    public Vendedor getEntidade() {
        return this.vendedor;
    }
}

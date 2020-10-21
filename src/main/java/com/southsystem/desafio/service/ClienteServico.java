package com.southsystem.desafio.service;

import com.southsystem.desafio.model.Cliente;
import com.southsystem.desafio.model.IDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ClienteServico implements IDadosServico {
    private Cliente cliente;

    public ClienteServico() {
        cliente = new Cliente();
    }

    @Autowired
    public ClienteServico(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public IDados mapearDados(Object dados) {
        String linha = (String) dados;
        List<String> informacoes;
        informacoes = Arrays.asList(linha.split("ç"));


        return new Cliente(informacoes.get(1), informacoes.get(2), informacoes.get(3));
    }

    @Override
    public String getIdEntidade() {
        return cliente.getIdEntidade();
    }

    @Override
    public Cliente getEntidade() {
        return this.cliente;
    }
}

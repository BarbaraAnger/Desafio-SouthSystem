package com.southsystem.desafio.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelatorioServico {

    public List<String> mapearDadosRelatorioDAT(String quantidadeClientes, String quantidadePessoasVendedoras,
                                                String idVendaMaisCara, String nomePiorVendedor) {
        List<String> dados = new ArrayList<>();
        dados.add("Quantidade total de clientes: " + quantidadeClientes);
        dados.add("Quantidade total de pessoas vendedoras: " + quantidadePessoasVendedoras);
        dados.add("Id da venda mais cara: " + idVendaMaisCara);
        dados.add("Pior vendedor: " + nomePiorVendedor);

        return dados;
    }
}

package com.southsystem.desafio.service;

import com.southsystem.desafio.model.IDados;
import com.southsystem.desafio.model.Venda;
import com.southsystem.desafio.model.VendaVendedor;
import com.southsystem.desafio.model.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaVendedorServico implements IDadosServico {
    private VendaVendedor vendaVendedor;

    public VendaVendedorServico() {
        vendaVendedor = new VendaVendedor();
    }

    @Autowired
    public VendaVendedorServico(VendaVendedor vendaVendedor) {
        this.vendaVendedor = vendaVendedor;
    }

    @Override
    public IDados mapearDados(Object dados) {
        Venda venda;
        Vendedor vendedor;
        List<?> listaDeDados;
        VendaVendedor vendaVendedorNaoCadastrado = new VendaVendedor();

        listaDeDados = (List<?>) dados;
        venda = (Venda) listaDeDados.get(0);
        vendedor = (Vendedor) listaDeDados.get(1);
        List<VendaVendedor> listaVendaVendedor = (List<VendaVendedor>) listaDeDados.get(2);

        if (listaVendaVendedor.size() != 0) {
            for (VendaVendedor vendaVendedor : listaVendaVendedor) {
                if (vendaVendedor.getVendedor().getIdentificadorUnico()
                        .equals(vendedor.getIdentificadorUnico())) {
                    this.adicionarVendasDoVendedor(venda);
                    return vendaVendedor;
                }
            }
        }

        adicionarVendaVendedor(vendedor, venda, listaVendaVendedor);
        return vendaVendedorNaoCadastrado;
    }

    @Override
    public String getIdEntidade() {
        return vendaVendedor.getIdEntidade();
    }

    public void adicionarVendaVendedor(Vendedor vendedor, Venda venda, List<VendaVendedor> listaVendaVendedor) {
        vendaVendedor.setVendedor(vendedor);
        vendaVendedor.getVendasVendedor().add(venda);
        listaVendaVendedor.add(vendaVendedor);
    }

    public void adicionarVendasDoVendedor(Venda venda) {
        vendaVendedor.getVendasVendedor().add(venda);
    }

    public Double rendimentosTotaisVendedor(VendaVendedor vendaVendedor) {
        VendaServico vendaServico = new VendaServico(new Venda());
        double rendimentosTotaisDoVendedor = vendaVendedor.getVendasVendedor()
                .stream()
                .mapToDouble(vendaServico::somarValorTotalDaVenda)
                .sum();

        vendaVendedor.getVendedor().setRendimentosTotais(rendimentosTotaisDoVendedor);
        return rendimentosTotaisDoVendedor;
    }
}

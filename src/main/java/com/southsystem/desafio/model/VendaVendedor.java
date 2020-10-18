package com.southsystem.desafio.model;

import java.util.ArrayList;
import java.util.List;

public class VendaVendedor implements IDados {
    Vendedor vendedor;
    List<Venda> vendasVendedor = new ArrayList<>();

    @Override
    public VendaVendedor mapearDados(Object dados) {
        Venda venda = new Venda();
        Vendedor vendedor = new Vendedor();
        List<?> listaDeDados;

        listaDeDados = (List<?>) dados;
        venda = (Venda) listaDeDados.get(0);
        vendedor = (Vendedor) listaDeDados.get(1);
        List<VendaVendedor> listaVendaVendedor = (List<VendaVendedor>) listaDeDados.get(2);

        if (listaVendaVendedor.size() != 0) {
            for (VendaVendedor vendaVendedor : listaVendaVendedor) {
                if (vendaVendedor.getVendedor().getIdentificadorUnico()
                        .equals(vendedor.getIdentificadorUnico())) {
                    vendaVendedor.adicionarVendasDoVendedor(venda);
                    return this;
                }
            }
        }
        adicionarVendaVendedor(vendedor, venda, listaVendaVendedor);
        return this;
    }

    @Override
    public String getIdEntidade() {
        return "VendaVendedor";
    }

    @Override
    public String getIdentificadorUnico() {
        return null;
    }

    @Override
    public String getNome() {
        return null;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public List<Venda> getVendasVendedor() {
        return vendasVendedor;
    }

    private void adicionarVendaVendedor(Vendedor vendedor, Venda venda, List<VendaVendedor> listaVendaVendedor) {
        this.vendedor = vendedor;
        vendasVendedor.add(venda);
        listaVendaVendedor.add(this);
    }

    private void adicionarVendasDoVendedor(Venda venda) {
        this.vendasVendedor.add(venda);
    }

    public Double rendimentosTotaisVendedor() {
        double rendimentosTotaisDoVendedor = getVendasVendedor()
                .stream()
                .mapToDouble(Venda::somarValorTotalDaVenda)
                .sum();

        this.vendedor.setRendimentosTotais(rendimentosTotaisDoVendedor);
        return rendimentosTotaisDoVendedor;
    }
}

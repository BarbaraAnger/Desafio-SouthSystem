package com.southsystem.desafio.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VendaVendedor implements IDados {
    private Vendedor vendedor;
    private List<Venda> vendasVendedor = new ArrayList<>();

    public VendaVendedor() {
    }

    public VendaVendedor(Vendedor vendedor, List<Venda> vendasVendedor) {
        this.vendedor = vendedor;
        this.vendasVendedor = vendasVendedor;
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

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Venda> getVendasVendedor() {
        return vendasVendedor;
    }

}

package com.southsystem.desafio.service;

import com.southsystem.desafio.model.*;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArquivoLeituraServicoDATServico implements IArquivoLeituraServico {

    private List<IDados> dados;

    @Override
    public ArquivoLeituraServicoDATServico mapearEntidades(List<String> linhas) {
        dados = new ArrayList<>();
        Reflections reflections = new Reflections("com.southsystem.desafio.service");
        Set<Class<? extends IDadosServico>> modules = reflections.getSubTypesOf(IDadosServico.class);
        linhas.forEach(linha -> {
            for (Class<? extends IDadosServico> module : modules){
                Method method;
                try {
                    Object classe = module.getConstructor().newInstance();
                    method = module.getMethod("getIdEntidade");
                    String idEntidade = (String) method.invoke(classe);

                    if (linha.startsWith(idEntidade)) {
                        method = module.getMethod("mapearDados", Object.class);
                        IDados retorno = (IDados) method.invoke(classe, linha);
                        dados.add(retorno);
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    e.getMessage();
                }
            }
        });

        mapearRelacoes();
        return this;
    }

    private void mapearRelacoes() {
        List<IDados> vendas;
        List<IDados> vendedores;
        List<IDados> listaVendaVendedor = new ArrayList<>();

        vendas = dados
                .stream()
                .filter(classeDados -> classeDados instanceof Venda)
                .collect(Collectors.toList());
        vendedores = dados
                .stream()
                .filter(classeDados -> classeDados instanceof Vendedor)
                .collect(Collectors.toList());

        VendaVendedorServico vendaVendedorServico = new VendaVendedorServico(new VendaVendedor());

        for (IDados vendedor : vendedores) {
            vendas.forEach(venda -> {
                if (vendedor.getNome().equals(venda.getNome())) {
                    vendaVendedorServico.mapearDados(Arrays.asList(venda, vendedor, listaVendaVendedor));
                }
            });
        }
        dados.addAll(listaVendaVendedor);
    }

    @Override
    public String getExtensao() {
        return "dat";
    }

    public List<IDados> getDados() {
        return this.dados;
    }

    public Long contarClientes() {
        long numeroDeClientes;
        numeroDeClientes = getDados()
                .stream()
                .filter(dado -> dado instanceof Cliente)
                .count();

        return numeroDeClientes;
    }

    public Long contarVendedoras() {
        long numeroDeVendedoras;
        numeroDeVendedoras = getDados()
                .stream()
                .filter(dado -> dado instanceof Vendedor)
                .count();

        return numeroDeVendedoras;
    }

    public Venda buscarVendaMaisCara() {
        List<VendaVendedor> listaVendaVendedor = new ArrayList<>();

        for (IDados dado : getDados()) {
            if (dado instanceof VendaVendedor) {
                listaVendaVendedor.add((VendaVendedor) dado);
            }
        }

        Venda maiorVenda = new Venda();
        Double valorTotalVenda;
        double maiorValor = 0;
        VendaServico vendaServico = new VendaServico(new Venda());

        for (VendaVendedor vendaVendedor : listaVendaVendedor) {
            for (Venda venda : vendaVendedor.getVendasVendedor()) {
                valorTotalVenda = vendaServico.somarValorTotalDaVenda(venda);
                if (Math.max(valorTotalVenda, maiorValor) == valorTotalVenda) {
                    maiorValor = valorTotalVenda;
                    maiorVenda = venda;
                }
            }
        }

        return maiorVenda;
    }

    public Vendedor encontrarPiorVendedor() {
        List<VendaVendedor> listaVendaVendedor = new ArrayList<>();

        for (IDados dado : getDados()) {
            if (dado instanceof VendaVendedor) {
                listaVendaVendedor.add((VendaVendedor) dado);
            }
        }

        VendaVendedorServico vendaVendedorServico = new VendaVendedorServico(new VendaVendedor());
        Vendedor piorVendedor = new Vendedor();
        Double rendimentoTotalVendedor;
        double menorValor = 0;

        if (!listaVendaVendedor.isEmpty()) {
            menorValor = vendaVendedorServico.rendimentosTotaisVendedor(listaVendaVendedor.get(0));
        }

        for (VendaVendedor vendaVendedor : listaVendaVendedor) {
            rendimentoTotalVendedor = vendaVendedorServico.rendimentosTotaisVendedor(vendaVendedor);
            if (Math.min(rendimentoTotalVendedor, menorValor) == rendimentoTotalVendedor) {
                menorValor = rendimentoTotalVendedor;
                piorVendedor = vendaVendedor.getVendedor();
            }
        }

        return piorVendedor;
    }

}

package com.southsystem.desafio.service;

import com.southsystem.desafio.exception.ArquivoEntradaNaoEncontradoException;
import com.southsystem.desafio.exception.ImpossivelAcessarMetodoException;
import com.southsystem.desafio.exception.InstanciaIncorretaException;
import com.southsystem.desafio.exception.MetodoNaoEncontradoException;
import com.southsystem.desafio.model.Venda;
import com.southsystem.desafio.model.Vendedor;
import com.southsystem.desafio.repository.ArquivoRepositorio;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ArquivoServico {
    private ArquivoRepositorio arquivoRepositorio;

    @Autowired
    public ArquivoServico() {
        arquivoRepositorio = new ArquivoRepositorio();
    }

    /**
     * Método usado para buscar os arquivos que implementam a ArquivoLeitura.
     *
     * @return lista de arquivos encontrados.
     */
    public List<IArquivoLeituraServico> mapearArquivosImplementados() throws Exception {
        arquivoRepositorio = new ArquivoRepositorio();
        Reflections reflections = new Reflections("com.southsystem.desafio.model");
        Set<Class<? extends IArquivoLeituraServico>> modules = reflections.getSubTypesOf(IArquivoLeituraServico.class);

        List<File> arquivosDoDiretorio;
        arquivosDoDiretorio = arquivoRepositorio.buscarArquivosDoDiretorio();
        List<IArquivoLeituraServico> listaArquivoLeitura = new ArrayList<>();

        for (File arquivo : arquivosDoDiretorio) {
            for (Class<? extends IArquivoLeituraServico> module : modules) {
                Object classe;
                Method method;
                List<String> linhas;
                try {
                    linhas = Files.readAllLines(arquivo.toPath());
                    classe = module.getConstructor().newInstance();
                    method = module.getMethod("mapearEntidades", List.class);

                    listaArquivoLeitura.add((IArquivoLeituraServico) method.invoke(classe, linhas));
                } catch (InstanciaIncorretaException | MetodoNaoEncontradoException
                        | ArquivoEntradaNaoEncontradoException | InvocationTargetException | ImpossivelAcessarMetodoException e) {
                    throw e;
                }

            }
        }
        return listaArquivoLeitura;
    }

    public Long contarClientesNoArquivo(List<IArquivoLeituraServico> listaDeArquivoLeitura) {
        long numeroDeClientes = 0;
        for (IArquivoLeituraServico arquivo : listaDeArquivoLeitura) {
            numeroDeClientes += arquivo.contarClientes();
        }

        return numeroDeClientes;
    }

    public Long contarVendedorasNoArquivo(List<IArquivoLeituraServico> listaDeArquivoLeitura) {
        long numeroDeVendedoras = 0;

        for (IArquivoLeituraServico arquivo : listaDeArquivoLeitura) {
            numeroDeVendedoras += arquivo.contarVendedoras();
        }

        return numeroDeVendedoras;
    }

    public String buscarIdVendaMaisCaraNoArquivo(List<IArquivoLeituraServico> listaDeArquivoLeitura) {
        Venda maiorVenda = new Venda();
        double maiorValorVenda = 0;
        double valorVenda;
        for (IArquivoLeituraServico arquivo : listaDeArquivoLeitura) {
            Venda vendaMaisCara = arquivo.buscarVendaMaisCara();
            VendaServico vendaServico = new VendaServico(new Venda());
            valorVenda = vendaServico.somarValorTotalDaVenda(vendaMaisCara);

            if (Math.max(valorVenda, maiorValorVenda) == valorVenda) {
                maiorVenda = vendaMaisCara;
                maiorValorVenda = valorVenda;
            }
        }

        return maiorVenda.getIdVenda();
    }

    public Vendedor encontrarPiorVendedorNoArquivo(List<IArquivoLeituraServico> listaDeArquivoLeitura) {
        Vendedor piorVendedor;
        Double rendimentoTotalVendedorArquivo = null;
        Double rendimentoTotaisPiorVendedor;

        piorVendedor = new Vendedor();
        rendimentoTotaisPiorVendedor = listaDeArquivoLeitura.get(0).encontrarPiorVendedor().getRendimentosTotais();

        for (IArquivoLeituraServico arquivo : listaDeArquivoLeitura) {
            Vendedor piorVendedorArquivo;
            piorVendedorArquivo = arquivo.encontrarPiorVendedor();
            rendimentoTotalVendedorArquivo = piorVendedorArquivo.getRendimentosTotais();
            if (Math.min(rendimentoTotaisPiorVendedor, rendimentoTotalVendedorArquivo) == rendimentoTotalVendedorArquivo) {
                piorVendedor = piorVendedorArquivo;
                rendimentoTotaisPiorVendedor = rendimentoTotalVendedorArquivo;
            }
        }

        return piorVendedor;
    }
}

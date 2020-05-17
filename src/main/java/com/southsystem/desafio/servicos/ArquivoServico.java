package com.southsystem.desafio.servicos;

import com.southsystem.desafio.dominio.IArquivoLeitura;
import com.southsystem.desafio.dominio.Venda;
import com.southsystem.desafio.dominio.Vendedor;
import com.southsystem.desafio.dominio.excecoes.ArquivoEntradaNaoEncontradoException;
import com.southsystem.desafio.dominio.excecoes.ImpossivelAcessarMetodoException;
import com.southsystem.desafio.dominio.excecoes.InstanciaIncorretaException;
import com.southsystem.desafio.dominio.excecoes.MetodoNaoEncontradoException;
import com.southsystem.desafio.repositorio.ArquivoRepositorio;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ArquivoServico {
    ArquivoRepositorio arquivoRepositorio;

    public ArquivoServico() {
    }

    public ArquivoServico(ArquivoRepositorio arquivoRepositorio) {
        this.arquivoRepositorio = arquivoRepositorio;
    }

    /**
     * Método usado para buscar os arquivos que implementam a ArquivoLeitura.
     *
     * @return lista de arquivos encontrados.
     */
    public List<IArquivoLeitura> mapearArquivosImplementados() throws Exception {
        arquivoRepositorio = new ArquivoRepositorio();
        Reflections reflections = new Reflections("com.southsystem.desafio.dominio");
        Set<Class<? extends IArquivoLeitura>> modules = reflections.getSubTypesOf(IArquivoLeitura.class);

        List<File> arquivosDoDiretorio;
        arquivosDoDiretorio = arquivoRepositorio.buscarArquivosDoDiretorio();
        List<IArquivoLeitura> listaArquivoLeitura = new ArrayList<>();

        for (File arquivo : arquivosDoDiretorio) {
            for (Class<? extends IArquivoLeitura> module : modules) {
                Object classe;
                Method method;
                List<String> linhas;
                try {
                    linhas = Files.readAllLines(arquivo.toPath());
                    classe = module.getConstructor().newInstance();
                    method = module.getMethod("mapearEntidades", List.class);

                    listaArquivoLeitura.add((IArquivoLeitura) method.invoke(classe, linhas));
                } catch (InstanciaIncorretaException | MetodoNaoEncontradoException
                        | ArquivoEntradaNaoEncontradoException | InvocationTargetException | ImpossivelAcessarMetodoException e) {
                    throw e;
                }

            }
        }
        return listaArquivoLeitura;
    }

    public Long contarClientes(List<IArquivoLeitura> listaDeArquivoLeitura) {
        long numeroDeClientes = 0;
        for (IArquivoLeitura arquivo : listaDeArquivoLeitura) {
            numeroDeClientes += arquivo.contarClientes();
        }

        return numeroDeClientes;
    }

    public Long contarVendedoras(List<IArquivoLeitura> listaDeArquivoLeitura) {
        long numeroDeVendedoras = 0;

        for (IArquivoLeitura arquivo : listaDeArquivoLeitura) {
            numeroDeVendedoras += arquivo.contarVendedoras();
        }

        return numeroDeVendedoras;
    }

    public String buscarIdVendaMaisCara(List<IArquivoLeitura> listaDeArquivoLeitura) {
        Venda maiorVenda = new Venda();
        double maiorValorVenda = 0;
        double valorVenda;
        for (IArquivoLeitura arquivo : listaDeArquivoLeitura) {
            Venda vendaMaisCara = arquivo.buscarVendaMaisCara();
            valorVenda = vendaMaisCara.somarValorTotalDaVenda();

            if (Math.max(valorVenda, maiorValorVenda) == valorVenda) {
                maiorVenda = vendaMaisCara;
                maiorValorVenda = valorVenda;
            }
        }

        return maiorVenda.getIdVenda();
    }

    public Vendedor encontrarPiorVendedor(List<IArquivoLeitura> listaDeArquivoLeitura) {
        Vendedor piorVendedor;
        Double rendimentoTotalVendedorArquivo = null;
        Double rendimentoTotaisPiorVendedor;

        piorVendedor = new Vendedor();
        rendimentoTotaisPiorVendedor = listaDeArquivoLeitura.get(0).encontrarPiorVendedor().getRendimentosTotais();

        for (IArquivoLeitura arquivo : listaDeArquivoLeitura) {
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

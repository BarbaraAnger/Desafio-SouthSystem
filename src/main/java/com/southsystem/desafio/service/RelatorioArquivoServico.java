package com.southsystem.desafio.service;

import com.southsystem.desafio.repository.RelatorioDATRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioArquivoServico {
    private ArquivoServico arquivoServico;
    private RelatorioServico relatorioServico;
    private RelatorioDATRepositorio relatorioDATRepositorio;

    @Autowired
    public RelatorioArquivoServico(ArquivoServico arquivoServico, RelatorioServico relatorioServico,
                                   RelatorioDATRepositorio relatorioDATRepositorio) {
        this.arquivoServico = arquivoServico;
        this.relatorioServico = relatorioServico;
        this.relatorioDATRepositorio = relatorioDATRepositorio;
    }

    public void mapearDadosArquivoEscritaDAT() throws Exception {
        List<IArquivoLeituraServico> listaArquivoLeitura;
        listaArquivoLeitura = arquivoServico.mapearArquivosImplementados();
        String quantidadeClientes;
        String quantidadePessoasVendedoras;
        String idVendaMaisCara;
        String piorVendedor;
        List<String> dados;

        quantidadeClientes = arquivoServico.contarClientesNoArquivo(listaArquivoLeitura).toString();
        quantidadePessoasVendedoras = arquivoServico.contarVendedorasNoArquivo(listaArquivoLeitura).toString();
        idVendaMaisCara = arquivoServico.buscarIdVendaMaisCaraNoArquivo(listaArquivoLeitura);
        piorVendedor = arquivoServico.encontrarPiorVendedorNoArquivo(listaArquivoLeitura).getNome();
        dados = relatorioServico.mapearDadosRelatorioDAT(quantidadeClientes, quantidadePessoasVendedoras,
                idVendaMaisCara, piorVendedor);

        relatorioDATRepositorio.gerarArquivoRelatorioDAT(dados);
    }
}

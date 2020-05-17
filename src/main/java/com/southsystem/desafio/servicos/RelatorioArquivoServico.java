package com.southsystem.desafio.servicos;

import com.southsystem.desafio.dominio.IArquivoLeitura;
import com.southsystem.desafio.repositorio.RelatorioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioArquivoServico {
    ArquivoServico arquivoServico;
    RelatorioServico relatorioServico;
    RelatorioRepositorio relatorioRepositorio;

    @Autowired
    public RelatorioArquivoServico(ArquivoServico arquivoServico, RelatorioServico relatorioServico,
                                   RelatorioRepositorio relatorioRepositorio) {
        this.arquivoServico = arquivoServico;
        this.relatorioServico = relatorioServico;
        this.relatorioRepositorio = relatorioRepositorio;
    }

    public void mapearDadosArquivoEscritaDAT() throws Exception {
        List<IArquivoLeitura> listaArquivoLeitura;
        listaArquivoLeitura = arquivoServico.mapearArquivosImplementados();
        String quantidadeClientes;
        String quantidadePessoasVendedoras;
        String idVendaMaisCara;
        String piorVendedor;
        List<String> dados;

        quantidadeClientes = arquivoServico.contarClientes(listaArquivoLeitura).toString();
        quantidadePessoasVendedoras = arquivoServico.contarVendedoras(listaArquivoLeitura).toString();
        idVendaMaisCara = arquivoServico.buscarIdVendaMaisCara(listaArquivoLeitura);
        piorVendedor = arquivoServico.encontrarPiorVendedor(listaArquivoLeitura).getNome();
        dados = relatorioServico.mapearDadosRelatorioDAT(quantidadeClientes, quantidadePessoasVendedoras,
                idVendaMaisCara, piorVendedor);

        relatorioRepositorio.gerarArquivoRelatorioDAT(dados);
    }
}

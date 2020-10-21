package com.southsystem.desafio.service;

import com.southsystem.desafio.model.IDados;
import com.southsystem.desafio.model.Venda;
import com.southsystem.desafio.model.Vendedor;

import java.util.List;

/**
 * Interface de leitura do arquivo.
 */
public interface IArquivoLeituraServico {
    /**
     * Lista que contém as linhas do arquivo.
     */
    List<String> linhas = null;

    /**
     * Variavel que contem a extensão do arquivo.
     */
    String extensao = null;

    /**
     * Método para mapear o arquivo completo.
     * @param linhas passa por parametro as linhas de um arquivo.
     * @return a leitura do arquivo.
     */
    IArquivoLeituraServico mapearEntidades(List<String> linhas);

    /**
     * Método para obter a extensao do arquivo.
     * @return extensao do arquivo.
     */
    String getExtensao();

    /**
     * Retorna uma lista de dados.
     * @return a lista de dados.
     */
    List<IDados> getDados();

    /**
     * Método que conta clientes do arquivo.
     * @return quantidade de clientes.
     */
    Long contarClientes();

    /**
     * Método para contar pessoas vendedoras.
     * @return long com a quantidade de pessoas vendedoras.
     */
    Long contarVendedoras();

    /**
     * Método para buscar a venda mais cara.
     * @return a entidade venda, mais cara.
     */
    Venda buscarVendaMaisCara();

    /**
     * Método para retornar o pior vendedor.
     * @return a entidade vendedor populada, do pior vendedor.
     */
    Vendedor encontrarPiorVendedor();
}

package com.southsystem.desafio.model;

import java.util.List;

/**
 * Interface de leitura do arquivo.
 */
public interface IArquivoLeitura {
    /**
     * Lista que contém as linhas do arquivo.
     */
    List<String> linhas = null;

    /**
     * Variavel que contem a extensão do arquivo.
     */
    public final String extensao = null;

    /**
     * Método para mapear o arquivo completo.
     * @param linhas passa por parametro as linhas de um arquivo.
     * @return a leitura do arquivo.
     */
    public IArquivoLeitura mapearEntidades(List<String> linhas);

    /**
     * Método para obter a extensao do arquivo.
     * @return extensao do arquivo.
     */
    public String getExtensao();

    /**
     * Retorna uma lista de dados.
     * @return a lista de dados.
     */
    public List<IDados> getDados();

    /**
     * Método que conta clientes do arquivo.
     * @return quantidade de clientes.
     */
    public Long contarClientes();

    /**
     * Método para contar pessoas vendedoras.
     * @return long com a quantidade de pessoas vendedoras.
     */
    public Long contarVendedoras();

    /**
     * Método para buscar a venda mais cara.
     * @return a entidade venda, mais cara.
     */
    public Venda buscarVendaMaisCara();

    /**
     * Método para retornar o pior vendedor.
     * @return a entidade vendedor populada, do pior vendedor.
     */
    public Vendedor encontrarPiorVendedor();
}

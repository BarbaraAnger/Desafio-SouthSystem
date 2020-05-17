package com.southsystem.desafio.dominio;

/**
 * Interface de dados.
 */
public interface IDados {
    /**
     * Retorna nome referente ao dado da entidade.
     */
    final String nome = null;

    /**
     * Retorna id da entidade.
     */
    final String idEntidade = null;

    /**
     * Retorna identificador unico.
     */
    final String identificadorUnico = null;

    /**
     * Método para mapear os dados de acordo com a entidade.
     * @param dados objeto de dados para mapear.
     * @return dados mapeados.
     */
    public IDados mapearDados(Object dados);

    /**
     * Método para pegar o id da entidade.
     * @return um id.
     */
    public String getIdEntidade();

    /**
     * Método para retornar o identificador unico.
     * @return o identificador unico da entidade.
     */
    public String getIdentificadorUnico();

    /**
     * Método para pegar nome referente a entidade.
     * @return uma string nome.
     */
    public String getNome();
}

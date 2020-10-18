package com.southsystem.desafio.dominio;

/**
 * Interface de dados.
 */
public interface IDados {
    /**
     * Retorna nome referente ao dado da entidade.
     */
    String nome = null;

    /**
     * Retorna id da entidade.
     */
    String idEntidade = null;

    /**
     * Retorna identificador unico.
     */
    String identificadorUnico = null;

    /**
     * Método para mapear os dados de acordo com a entidade.
     * @param dados objeto de dados para mapear.
     * @return dados mapeados.
     */
    IDados mapearDados(Object dados);

    /**
     * Método para pegar o id da entidade.
     * @return um id.
     */
    String getIdEntidade();

    /**
     * Método para retornar o identificador unico.
     * @return o identificador unico da entidade.
     */
    String getIdentificadorUnico();

    /**
     * Método para pegar nome referente a entidade.
     * @return uma string nome.
     */
    String getNome();
}

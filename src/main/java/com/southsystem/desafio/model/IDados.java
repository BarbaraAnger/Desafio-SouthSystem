package com.southsystem.desafio.model;

/**
 * Interface de dados.
 */
public interface IDados {

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

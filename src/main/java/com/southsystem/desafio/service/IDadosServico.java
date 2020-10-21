package com.southsystem.desafio.service;

import com.southsystem.desafio.model.IDados;

public interface IDadosServico {

    /**
     * Mapeia os dados do arquivo para passar na entidade.
     */
    IDados mapearDados(Object dados);

    /**
     * Método para pegar o id da entidade.
     * @return um id.
     */
    String getIdEntidade();

    /**
     * Metodo que retorna a entidade.
     */
    IDados getEntidade();
}

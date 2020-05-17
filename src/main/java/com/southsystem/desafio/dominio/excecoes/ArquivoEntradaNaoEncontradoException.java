package com.southsystem.desafio.dominio.excecoes;

import java.io.IOException;

public class ArquivoEntradaNaoEncontradoException extends IOException {

    public ArquivoEntradaNaoEncontradoException() {
        super("Arquivo de entrada não encontrado.");
    }
}

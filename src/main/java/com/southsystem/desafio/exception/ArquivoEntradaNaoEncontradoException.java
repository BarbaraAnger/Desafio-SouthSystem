package com.southsystem.desafio.exception;

import java.io.IOException;

public class ArquivoEntradaNaoEncontradoException extends IOException {

    public ArquivoEntradaNaoEncontradoException() {
        super("Arquivo de entrada não encontrado.");
    }
}

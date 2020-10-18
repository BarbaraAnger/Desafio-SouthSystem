package com.southsystem.desafio.exception;

public class MetodoNaoEncontradoException extends NoSuchMethodException {

    public MetodoNaoEncontradoException() {
        super("Há algum método que não existe sendo chamado.");
    }
}

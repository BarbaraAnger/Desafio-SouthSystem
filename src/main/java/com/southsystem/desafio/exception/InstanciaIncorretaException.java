package com.southsystem.desafio.exception;

public class InstanciaIncorretaException extends InstantiationException {

    public InstanciaIncorretaException() {
        super("Há uma classe que foi instanciada incorretamente.");
    }
}

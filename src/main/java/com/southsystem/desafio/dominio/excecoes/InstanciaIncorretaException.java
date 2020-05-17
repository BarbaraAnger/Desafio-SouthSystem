package com.southsystem.desafio.dominio.excecoes;

public class InstanciaIncorretaException extends InstantiationException {

    public InstanciaIncorretaException() {
        super("Há uma classe que foi instanciada incorretamente.");
    }
}

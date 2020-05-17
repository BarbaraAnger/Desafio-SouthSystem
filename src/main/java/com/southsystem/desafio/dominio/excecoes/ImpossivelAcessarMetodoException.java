package com.southsystem.desafio.dominio.excecoes;

public class ImpossivelAcessarMetodoException extends IllegalAccessException {

    public ImpossivelAcessarMetodoException() {
        super("Impossivel acessar método, verifique se o mesmo é privado.");
    }
}

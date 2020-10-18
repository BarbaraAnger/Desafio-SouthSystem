package com.southsystem.desafio.repositorio;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class ArquivoRepositorio {
    public List<File> buscarArquivosDoDiretorio() {
        String separador = File.separator;
        String diretorio = System.getProperty("user.home") + separador + "data" + separador + "in";
        return Arrays.asList(Objects.requireNonNull(new File(diretorio).listFiles()));
    }
}

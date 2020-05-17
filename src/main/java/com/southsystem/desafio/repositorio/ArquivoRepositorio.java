package com.southsystem.desafio.repositorio;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class ArquivoRepositorio {
    public List<File> buscarArquivosDoDiretorio() {
        String separador = File.separator;
        String diretorio = System.getProperty("user.home") + separador + "data" + separador + "in";
        return Arrays.asList(Objects.requireNonNull(new File(diretorio).listFiles()));
    }
}

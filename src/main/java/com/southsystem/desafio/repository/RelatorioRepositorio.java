package com.southsystem.desafio.repository;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class RelatorioRepositorio {
    public void gerarArquivoRelatorioDAT(List<String> linhas) {
        String dataAtual;
        String nomeArquivo;
        String separador;
        String diretorio;
        File file;

        dataAtual = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date(System.currentTimeMillis()));
        nomeArquivo = dataAtual + ".done.dat";
        separador = File.separator;
        diretorio = System.getProperty("user.home") + separador + "data" + separador + "out" + separador;
        file = new File(diretorio + nomeArquivo);

        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (String linha : linhas) {
                printWriter.println(linha);
            }
        } catch (FileNotFoundException e) {
            if(!file.canWrite()) {
                System.out.println("Sem permissão para criar arquivo no diretorio.");
            }
            e.printStackTrace();
        }
    }
}

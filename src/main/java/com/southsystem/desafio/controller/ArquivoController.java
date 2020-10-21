package com.southsystem.desafio.controller;

import com.southsystem.desafio.service.RelatorioArquivoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ArquivoController {
    RelatorioArquivoServico relatorioArquivoServico;

    @Autowired
    public ArquivoController(RelatorioArquivoServico relatorioArquivoServico) {
        this.relatorioArquivoServico = relatorioArquivoServico;
    }

    @RequestMapping("processar-arquivos")
    public String processarArquivos() throws Exception {
        try {
            relatorioArquivoServico.mapearDadosArquivoEscritaDAT();
            return "Arquivo de saída gerado!";
        } catch (Exception e) {
             e.printStackTrace();
            throw e;
        }
    }
}

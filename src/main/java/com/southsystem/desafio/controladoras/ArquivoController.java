package com.southsystem.desafio.controladoras;

import com.southsystem.desafio.servicos.RelatorioArquivoServico;
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
        relatorioArquivoServico.mapearDadosArquivoEscritaDAT();
        return "Arquivo de saída gerado!";
    }
}

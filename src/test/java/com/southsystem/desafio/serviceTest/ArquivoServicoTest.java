package com.southsystem.desafio.serviceTest;

import com.southsystem.desafio.service.ArquivoServico;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArquivoServicoTest {
    private ArquivoServico arquivoServico;

    @Before
    public void setUp() {
        arquivoServico = new ArquivoServico();
    }

    @Test
    public void retornarNumeroDeClientes() {

    }
}

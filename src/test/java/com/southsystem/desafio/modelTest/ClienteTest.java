package com.southsystem.desafio.modelTest;

import com.southsystem.desafio.model.Cliente;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteTest {
    private Cliente cliente;

    @Before
    public void setUp() {
        cliente = new Cliente("Paulo", "92282132313", "rural");
    }

    @Test
    public void testarPegarDadosDoCliente() {
        System.out.println(cliente.toString());
    }
}

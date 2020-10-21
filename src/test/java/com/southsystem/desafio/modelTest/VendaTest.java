package com.southsystem.desafio.modelTest;

import com.southsystem.desafio.model.Item;
import com.southsystem.desafio.model.Venda;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class VendaTest {
    private Venda venda;

    @Before
    public void setUp() {
        venda = new Venda("1", List.of(new Item("1", 10, Double.valueOf("20"))), "Paulo");
    }

    @Test
    public void testarPegarDadosDoCliente() {
        System.out.println(venda.toString());
    }
}

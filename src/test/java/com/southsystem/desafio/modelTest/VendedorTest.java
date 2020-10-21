package com.southsystem.desafio.modelTest;

import com.southsystem.desafio.model.Vendedor;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class VendedorTest {
    private Vendedor vendedor;

    @Before
    public void setup() {
        vendedor = new Vendedor("9999999999", "Paulo", BigDecimal.ONE);
    }

    @Test
    public void testarPegarInformacoes() {
        System.out.println(vendedor.toString());
    }
}

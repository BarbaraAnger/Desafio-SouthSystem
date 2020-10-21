package com.southsystem.desafio.service;

import com.southsystem.desafio.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemServico {
    private Item item;

    @Autowired
    public ItemServico(Item item) {
        this.item = item;
    }

    public Item mapearEntidade(String item) {
        List<String> informacoes;
        informacoes = Arrays.asList(item.split("-"));

        String id = informacoes.get(0);
        Integer quantidade = Integer.valueOf(informacoes.get(1));
        Double preco = Double.valueOf(informacoes.get(2));

        return new Item(id, quantidade, preco);
    }
}

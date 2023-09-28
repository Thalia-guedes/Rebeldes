package com.zup.rebeldes.service;

import java.math.BigDecimal;

public record CadastroCompra(
        String nome_item,
        BigDecimal preco) {
}

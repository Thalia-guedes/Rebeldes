package com.zup.rebeldes.service;

import com.zup.rebeldes.model.ComprasModel;
import com.zup.rebeldes.model.RebeldeModel;

public record CadastroInventario(
        int quantidade,
        RebeldeModel rebelde_id,
        ComprasModel compras_id) {
}

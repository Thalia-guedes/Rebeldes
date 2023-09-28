package com.zup.rebeldes.service;

import com.zup.rebeldes.model.Localizacao;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CadastroRebelde(

        String nome_rebelde,
        @Min(0)
        int idade_rebelde,
        @NotBlank
        String genero_rebelde,

        Localizacao localizacao_rebelde) {
}

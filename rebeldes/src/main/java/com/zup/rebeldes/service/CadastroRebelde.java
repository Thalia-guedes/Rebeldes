package com.zup.rebeldes.service;

import com.zup.rebeldes.model.Localizacao;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record CadastroRebelde(
        @NotBlank
        String nome,
         @NotBlank
         int idade,
         @NotBlank
         String genero,
         @NotBlank
         @Valid
        Localizacao localizacao) {
}

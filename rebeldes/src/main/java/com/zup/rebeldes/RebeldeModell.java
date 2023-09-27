package com.zup.rebeldes;

import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class RebeldeModell {
    private String nome;
    private int idade;
    private String genero;
    private Localizacao localizacao;
    private List<ItemModell> inventario ;

}

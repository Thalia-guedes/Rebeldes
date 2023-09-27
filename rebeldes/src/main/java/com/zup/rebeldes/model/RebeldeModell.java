package com.zup.rebeldes.model;

import com.zup.rebeldes.model.ItemModell;
import com.zup.rebeldes.model.Localizacao;
import com.zup.rebeldes.service.CadastroRebelde;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Table(name = "rebeldes")
public class RebeldeModell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_rebelde")
    private String nome;

    @Column(name = "idade_rebelde")
    private int idade;

    @Column(name = "genero_rebelde")
    private String genero;

    @Column(name = "localizacao_rebelde")
    private Localizacao localizacao;

    @Column(name = "inventario_rebelde")
    private List<ItemModell> inventario ;

    //@Column(name = "denuncia_rebelde")
    private int denuncia;

    public RebeldeModell(CadastroRebelde cadastroRebelde){
        this.nome= cadastroRebelde.nome();
        this.idade=cadastroRebelde.idade();
        this.genero=cadastroRebelde.genero();
        this.localizacao=cadastroRebelde.localizacao();
    }
}

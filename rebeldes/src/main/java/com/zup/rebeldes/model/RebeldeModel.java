package com.zup.rebeldes.model;

import com.zup.rebeldes.service.CadastroRebelde;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Table(name = "rebeldes")
@Entity
public class RebeldeModel {
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

    @Embedded
    @OneToMany(mappedBy = "rebelde", cascade = CascadeType.ALL)
    private List<ItemModel> inventario ;

    @Column(name = "denuncia_rebelde")
    private int denuncia;

    public RebeldeModel(CadastroRebelde cadastroRebelde){
        this.nome= cadastroRebelde.nome_rebelde();
        this.idade=cadastroRebelde.idade_rebelde();
        this.genero=cadastroRebelde.genero_rebelde();
        this.localizacao=cadastroRebelde.localizacao_rebelde();
    }
}

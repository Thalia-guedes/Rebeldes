package com.zup.rebeldes.model;

import com.zup.rebeldes.service.AtualizarLocalizacaoRebelde;
import com.zup.rebeldes.service.CadastroInventario;
import com.zup.rebeldes.service.CadastroRebelde;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

    @Enumerated(EnumType.STRING)
    private Localizacao localizacao;

    @Embedded
    @OneToMany(mappedBy = "rebelde", cascade = CascadeType.ALL)
    private List<InventarioModel> inventario;

    @Column(name = "denuncia_rebelde")
    private int denuncia;

    private boolean traidor;

    public RebeldeModel(CadastroRebelde cadastroRebelde) {
        this.nome = cadastroRebelde.nome_rebelde();
        this.idade = cadastroRebelde.idade_rebelde();
        this.genero = cadastroRebelde.genero_rebelde();
        this.localizacao = cadastroRebelde.localizacao_rebelde();
        this.inventario = new ArrayList<>();
    }

    public void atualizarInformacoes(AtualizarLocalizacaoRebelde atualizar) {
        if (atualizar.nome_rebelde() != null) {
            this.nome = atualizar.nome_rebelde();
        }
        if (atualizar.localizacao_rebelde() != null) {
            this.localizacao = atualizar.localizacao_rebelde();
        }
    }

    //Método para incrementar o contador de marcações como traidor
    public void incrementarContadorMarcacoesTraidor() {
        this.denuncia++;
    }

    // Método para zerar o contador de marcações
    public void zerarContadorMarcacoesTraidor() {
        this.denuncia = 0;
    }

    // Método para obter o contador de marcações
    public int getContadorMarcacoesTraidor() {
        return denuncia;
    }

    // Método para marcar como traidor se atingiu o limite de marcações
    public void marcarComoTraidor() {
        if (denuncia >= 3) {
            this.traidor = true;
        }
    }

    // Método para verificar se é traidor
    public boolean isTraidor() {
        return traidor;
    }
}

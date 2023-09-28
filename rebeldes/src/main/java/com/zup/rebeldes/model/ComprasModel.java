package com.zup.rebeldes.model;

import com.zup.rebeldes.service.CadastroCompra;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "compras")
public class ComprasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_compra;
    @Column(nullable = false)
    private String nome_item;
    @Column(nullable = false)
    private BigDecimal preco;

    public ComprasModel(CadastroCompra cadastro) {
        this.nome_item = cadastro.nome_item();
        this.preco = cadastro.preco();
    }
}

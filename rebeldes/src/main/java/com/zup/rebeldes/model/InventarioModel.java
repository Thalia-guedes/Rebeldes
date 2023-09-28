package com.zup.rebeldes.model;

import com.zup.rebeldes.service.CadastroInventario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "inventario")
public class InventarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inventario;
    @Column(nullable = false)
    private int quantidade;
    @ManyToOne
    @JoinColumn(name = "rebelde_id", referencedColumnName = "id")
    private RebeldeModel rebelde;
    @ManyToOne
    @JoinColumn(name = "compra_id", referencedColumnName = "id_compra")
    private ComprasModel compra;

    public InventarioModel(CadastroInventario cadastro) {
        this.quantidade = cadastro.quantidade();
        this.rebelde = cadastro.rebelde_id();
        this.compra = cadastro.compras_id();
    }
}

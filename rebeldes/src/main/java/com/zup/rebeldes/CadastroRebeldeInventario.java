package com.zup.rebeldes;

import com.zup.rebeldes.model.InventarioModel;
import com.zup.rebeldes.model.RebeldeModel;
import com.zup.rebeldes.service.CadastroInventario;
import com.zup.rebeldes.service.CadastroRebelde;
import lombok.Data;

import java.util.List;

@Data
public class CadastroRebeldeInventario {
    private CadastroRebelde cadastroRebelde;
    private CadastroInventario cadastroInventario;

    public void preencherInventario(RebeldeModel rebelde) {
        List<InventarioModel> inventario = rebelde.getInventario();
//        for (InventarioModel item : inventario) {
//            item.setQuantidade(this.getCadastroInventario().quantidade());
//            item.setCompra(this.getCadastroInventario().compras_id());
//        }
        inventario.add(new InventarioModel(cadastroInventario));
    }
}

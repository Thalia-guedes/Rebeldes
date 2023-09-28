package com.zup.rebeldes.controller;
import com.zup.rebeldes.model.InventarioModel;
import com.zup.rebeldes.repository.InventarioRepository;
import com.zup.rebeldes.service.CadastroInventario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventario")
public class InventarioController {
    @Autowired
    private InventarioRepository repository;

    @RequestMapping
    @Transactional
    public ResponseEntity cadastrarInventario(@RequestBody @Valid CadastroInventario cadastro){
        var inventario = new InventarioModel(cadastro);
        repository.save(inventario);
        return ResponseEntity.ok(inventario);
    }
}
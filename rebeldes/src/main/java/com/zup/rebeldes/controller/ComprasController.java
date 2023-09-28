package com.zup.rebeldes.controller;

import com.zup.rebeldes.model.ComprasModel;
import com.zup.rebeldes.repository.ComprasRepository;
import com.zup.rebeldes.service.CadastroCompra;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("compras")
public class ComprasController {
    @Autowired
    private ComprasRepository repository;

    @RequestMapping
    @Transactional
    public ResponseEntity cadastrarCompra(@RequestBody @Valid CadastroCompra cadastro){
        var compra = new ComprasModel(cadastro);
        repository.save(compra);
        return ResponseEntity.ok(compra);
    }
}

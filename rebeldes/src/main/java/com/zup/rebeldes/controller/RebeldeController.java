package com.zup.rebeldes.controller;

import com.zup.rebeldes.CadastroRebeldeInventario;
import com.zup.rebeldes.model.RebeldeModel;
import com.zup.rebeldes.repository.RebeldeRepository;
import com.zup.rebeldes.service.CadastroRebelde;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rebeldes")
public class RebeldeController {
    @Autowired
    private RebeldeRepository rebeldeRepository;

    @RequestMapping
    @Transactional
    public ResponseEntity cadastrarRebelde(@RequestBody @Valid CadastroRebeldeInventario cadastro){
        var rebelde=new RebeldeModel(cadastro.getCadastroRebelde());
        cadastro.preencherInventario(rebelde);
        rebeldeRepository.save(rebelde);
        return ResponseEntity.ok(rebelde);
    }
}

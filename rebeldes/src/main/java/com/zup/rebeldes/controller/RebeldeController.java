package com.zup.rebeldes.controller;

import com.zup.rebeldes.service.CadastroRebelde;
import com.zup.rebeldes.model.RebeldeModel;
import com.zup.rebeldes.repository.RebeldeRepository;
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
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroRebelde cadastroRebelde){
        var rebelde=new RebeldeModel(cadastroRebelde);
        rebeldeRepository.save(rebelde);
        return ResponseEntity.ok(rebelde);

    }

}

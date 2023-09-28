package com.zup.rebeldes.controller;

import com.zup.rebeldes.CadastroRebeldeInventario;
import com.zup.rebeldes.model.RebeldeModel;
import com.zup.rebeldes.repository.RebeldeRepository;
import com.zup.rebeldes.service.AtualizarLocalizacaoRebelde;
import com.zup.rebeldes.service.CadastroRebelde;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("rebeldes")
public class RebeldeController {
    @Autowired
    private RebeldeRepository rebeldeRepository;

    @RequestMapping
    @Transactional
    public ResponseEntity cadastrarRebelde(@RequestBody @Valid CadastroRebelde cadastro) {
        var rebelde = new RebeldeModel(cadastro);
        rebeldeRepository.save(rebelde);
        return ResponseEntity.ok(rebelde);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarLocalizacao(@RequestBody AtualizarLocalizacaoRebelde atualizarLocalizacaoRebelde) {
        var rebelde = rebeldeRepository.getReferenceById(atualizarLocalizacaoRebelde.id());
        rebelde.atualizarInformacoes(atualizarLocalizacaoRebelde);

        return ResponseEntity.ok(rebelde);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {


        if (rebeldeOptional.isPresent()) {
            RebeldeModel rebelde = rebeldeOptional.get();

            // Incrementa o contador de marcações
            rebelde.incrementarContadorMarcacoesTraidor();

            // Marca como traidor se atingiu o limite de marcações
            rebelde.marcarComoTraidor();

            // Exclui o rebelde
            reexcluirRebelde(rebelde);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rebelde não encontrado.");
        }
    }
}

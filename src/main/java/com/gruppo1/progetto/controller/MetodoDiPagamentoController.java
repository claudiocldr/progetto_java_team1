package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.MetodoDiPagamentoSenzaIdDto;
import com.gruppo1.progetto.dto.MetodoDiPagamentoDto;
import com.gruppo1.progetto.services.MetodoDiPagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/api/metodo_di_pagamento")
public class MetodoDiPagamentoController {

    @Autowired
    public MetodoDiPagamentoService metodoDiPagamentoService;


    @PostMapping("/create")
    @Operation(summary = "Create a new payment method")
    public ResponseEntity<Optional<MetodoDiPagamentoDto>> createMDP(@RequestBody MetodoDiPagamentoSenzaIdDto metodoDiPagamentoDto, @RequestParam Long clienteId, @RequestParam Long indirizzo_id, @RequestParam String author) {

           return ResponseEntity.ok().body(Optional.of(metodoDiPagamentoService.createMetodoDiPagamento(metodoDiPagamentoDto,clienteId,indirizzo_id, author))) ;
    }

    @GetMapping("/find")
    @Operation(summary = "Gets payment method by ID", description= "payment method must exist")
    public ResponseEntity<MetodoDiPagamentoDto> readMDP(@RequestParam Long id) {
        return ResponseEntity.ok().body(metodoDiPagamentoService.readMetodoDiPagamento(id));
    }
//
    @PutMapping("/update")
    @Operation(summary = "Update payment method by id", description= "payment method must exist")
    public ResponseEntity<MetodoDiPagamentoDto> updateMDPById(@RequestParam Long metodoDiPagamentoId, @RequestBody MetodoDiPagamentoSenzaIdDto metodoDiPagamentoDto, @RequestParam String author) throws Exception {
            MetodoDiPagamentoDto response = metodoDiPagamentoService.updateMetodoDiPagamento(metodoDiPagamentoId, metodoDiPagamentoDto, author);
            return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete payment method by id", description= "payment method must exist")
    public ResponseEntity<MetodoDiPagamentoDto> deleteMDPById(@RequestParam Long id) {
           return ResponseEntity.ok().body(metodoDiPagamentoService.deleteMetodoDiPagamento(id));
    }
}

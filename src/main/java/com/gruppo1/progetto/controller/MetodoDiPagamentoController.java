package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.dto.MetodoDiPagamentoDto;
import com.gruppo1.progetto.services.MetodoDiPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/metodo_di_pagamento")
public class MetodoDiPagamentoController {

    @Autowired
    public MetodoDiPagamentoService metodoDiPagamentoService;


    @PostMapping("/")
    public ResponseEntity<Optional<MetodoDiPagamentoDto>> createMDP(@RequestBody MetodoDiPagamentoDto metodoDiPagamentoDto, @RequestBody ClienteDto clienteDto, @RequestParam Long indirizzo_id, @RequestParam String author) {

           return ResponseEntity.ok().body(Optional.of(metodoDiPagamentoService.createMetodoDiPagamento(metodoDiPagamentoDto,clienteDto,indirizzo_id, author))) ;
    }

//    @GetMapping("/")
//    public ResponseEntity<MetodoDiPagamentoDto> readMDP(@RequestParam Long id) {
//        return ResponseEntity.ok().body(metodoDiPagamentoService.readMetodoDiPagamento(id));
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<String> updateMDPById(@RequestBody MetodoDiPagamentoDto metodoDiPagamentoDto, @RequestParam Long id, @RequestParam String author) throws Exception {
//        try {
//            metodoDiPagamentoService.updateMetodoDiPagamento(metodoDiPagamentoDto, id, author);
//            return ResponseEntity.ok().body("modifica del metodo di pagamento effettuata con successo");
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("c'è stato un problema con l'aggiornamento del metodo di pagamento");
//        }
//    }
//
//    @DeleteMapping("/")
//    public ResponseEntity<String> deleteMDPById(@RequestParam Long id) {
//        try {
//            metodoDiPagamentoService.deleteMetodoDiPagamento(id);
//            return ResponseEntity.ok().body("Metodo di pagamento correttamente cancellato");
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Errore nella cancellazione del metodo di pagamento");
//        }
//    }
}

package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.MetodoDiPagamentoDto;
import com.gruppo1.progetto.services.MetodoDiPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/metodo_di_pagamento")
public class MetodoDiPagamentoController {

    @Autowired
    private MetodoDiPagamentoService metodoDiPagamentoService;


    @PostMapping("/")
    ResponseEntity<String> createMDP(@RequestBody MetodoDiPagamentoDto metodoDiPagamentoDto, @RequestParam String author) {
        try {
            metodoDiPagamentoService.createMetodoDiPagamento(metodoDiPagamentoDto, author);
            return ResponseEntity.ok().body("Metodo di pagamento correttamente inserito");
        } catch (Exception e) {
            Logger logger = Logger.getLogger("insertMetodoDPLogger");
            logger.log(new LogRecord(Level.WARNING, " " + e));
            return ResponseEntity.badRequest().body("C'è stato un problema con l'inserimento del metodo di pagamento");
        }
    }

    @GetMapping("/")
    ResponseEntity<MetodoDiPagamentoDto> readMDP(@RequestParam Long id) {
        return ResponseEntity.ok().body(metodoDiPagamentoService.readMetodoDiPagamento(id));
    }

//    @PutMapping("/update")
//    ResponseEntity<String> updateMDPById(@RequestBody MetodoDiPagamentoDto metodoDiPagamentoDto, @RequestParam Long id, @RequestParam String author) throws Exception {
//        try {
//            metodoDiPagamentoService.updateMetodoDiPagamento(metodoDiPagamentoDto, id, author);
//            return ResponseEntity.ok().body("modifica del metodo di pagamento effettuata con successo");
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("c'è stato un problema con l'aggiornamento del metodo di pagamento");
//        }
//    }

    @DeleteMapping("/")
    ResponseEntity<String> deleteMDPById(@RequestParam Long id) {
        try {
            metodoDiPagamentoService.deleteMetodoDiPagamento(id);
            return ResponseEntity.ok().body("Metodo di pagamento correttamente cancellato");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Errore nella cancellazione del metodo di pagamento");
        }
    }
}

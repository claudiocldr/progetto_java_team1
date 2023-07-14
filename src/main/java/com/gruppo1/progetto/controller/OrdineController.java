package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.OrdineDto;
import com.gruppo1.progetto.models.Ordine;
import com.gruppo1.progetto.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/ordine")
public class OrdineController {
    @Autowired
    public OrdineService ordineService;

    @GetMapping("/")
    ResponseEntity<OrdineDto> readOrdineById(@RequestParam Long id) {
       return ResponseEntity.ok().body(ordineService.readOrdine(id));
    }

    @PostMapping("/")
    ResponseEntity<String> insertOrdine (@RequestBody OrdineDto ordineDto, @RequestParam String author)
    {   try {
        ordineService.createOrdine(ordineDto, author);
        return ResponseEntity.ok().body("ordine correttamente creato");}
        catch (Exception e) {
        Logger logger = Logger.getLogger("insertOrdineLogger");
        logger.log(new LogRecord(Level.WARNING, " " + e));
        return ResponseEntity.badRequest().body("C'è stato un problema con l'inserimento dell'ordine");

        }
    }

    @PutMapping("/update")
    ResponseEntity<String> updateOrdineById(@RequestBody OrdineDto ordineDto, @RequestParam Long id, @RequestParam String author) throws Exception {
        try {ordineService.updateOrdine(ordineDto, id, author);
            return ResponseEntity.ok().body("modifica dell'ordine effettuata con successo");} catch (Exception e) {
            return ResponseEntity.badRequest().body("c'è stato un problema con l'aggiornamento dell'ordine");
        }

    }






}

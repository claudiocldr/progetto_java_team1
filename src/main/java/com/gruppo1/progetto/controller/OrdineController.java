package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.OrdineDto;
import com.gruppo1.progetto.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordine")
public class OrdineController {
    @Autowired
    OrdineService ordineService;

    @PutMapping("/update")
    ResponseEntity<String> updateOrdineById(@RequestBody OrdineDto ordineDto, @RequestParam Long id, @RequestParam String author) throws Exception {
        try {ordineService.updateOrdine(ordineDto, id, author);
            return ResponseEntity.ok().body("modifica dell'ordine effettuata con successo");} catch (Exception e) {
            return ResponseEntity.badRequest().body("c'è stato un problema con l'aggiornamento dell'ordine");
        }

    }






}

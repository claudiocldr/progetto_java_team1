package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.CarrelloDto;
import com.gruppo1.progetto.services.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrello")
public class CarrelloController {

    @Autowired
    CarrelloService carrelloService;

//    @PutMapping("/update")
//    ResponseEntity<String> updateCarrelloById(@RequestBody CarrelloDto carrelloDto, @RequestParam Long id,@RequestParam String author){
//        try{ carrelloService.updateCarrello(carrelloDto, id, author);
//            return ResponseEntity.ok().body("modifica del carrello effettuata con successo");} catch (Exception e){
//            return ResponseEntity.badRequest().body("c'è stato un problema con l'aggiornamento del carrello");
//        }
//
//    }
}

package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.IndirizzoDto;
import com.gruppo1.progetto.dto.OrdineDto;
import com.gruppo1.progetto.services.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/cliente")
public class IndirizzoController {

    @Autowired
    private IndirizzoService indirizzoService;


    @PostMapping("/")
    ResponseEntity<String> createIndirizzo(@RequestBody IndirizzoDto indirizzoDto, @RequestParam String author) {
        try {
            indirizzoService.createIndirizzo(indirizzoDto, author);
            return ResponseEntity.ok().body("indirizzo correttamente creato");
        } catch (Exception e) {
            Logger logger = Logger.getLogger("insertIndirizzoLogger");
            logger.log(new LogRecord(Level.WARNING, " " + e));
            return ResponseEntity.badRequest().body("C'è stato un problema con l'inserimento dell'indirizzo");

        }
    }

    @GetMapping("/")
    ResponseEntity<IndirizzoDto> readIndirizzoById(@RequestParam Long id) {
        return ResponseEntity.ok().body(indirizzoService.readIndirizzo(id));
    }

//    @PutMapping("/update")
//    ResponseEntity<String> updateIndirizzoById(@RequestBody IndirizzoDto indirizzoDto, @RequestParam Long id, @RequestParam String author) throws Exception {
//        try {indirizzoService.updateIndirizzo(indirizzoDto, id, author);
//            return ResponseEntity.ok().body("modifica dell'indirizzo effettuata con successo");} catch (Exception e) {
//            return ResponseEntity.badRequest().body("c'è stato un problema con l'aggiornamento dell'indirizzo");
//        }
//
//    }

    @DeleteMapping("/")
    ResponseEntity<String> deleteIndirizzoById(@RequestParam Long id) {
        try {
            indirizzoService.deleteIndirizzo(id);
            return ResponseEntity.ok().body("Indirizzo correttamente cancellato");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Errore nella cancellazione dell'indirizzo");
        }
    }
}

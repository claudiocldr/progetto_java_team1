package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.IndirizzoDto;
import com.gruppo1.progetto.dto.OrdineDto;
import com.gruppo1.progetto.services.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/indirizzo")
public class IndirizzoController {

    @Autowired
    public IndirizzoService indirizzoService;


    @PostMapping("/create")
    public ResponseEntity<Optional<IndirizzoDto>> createIndirizzo(@RequestBody IndirizzoDto indirizzoDto, @RequestParam String author, @RequestParam Long idCliente) {

            return ResponseEntity.ok().body(Optional.of(indirizzoService.createIndirizzo(indirizzoDto, author)));
    }

    @GetMapping("/get")
    public ResponseEntity<IndirizzoDto> readIndirizzoById(@RequestParam Long id) {
        return ResponseEntity.ok().body(indirizzoService.readIndirizzo(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Optional<IndirizzoDto>> updateIndirizzoById(@RequestBody IndirizzoDto indirizzoDto, @RequestParam String author) throws Exception {


            return ResponseEntity.ok().body(Optional.of(indirizzoService.updateIndirizzo(indirizzoDto, author)));

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteIndirizzoById(@RequestParam Long id) {

            indirizzoService.deleteIndirizzo(id);
            return ResponseEntity.ok().body("Indirizzo correttamente cancellato");
    }
}

package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.IndirizzoDto;
import com.gruppo1.progetto.dto.OrdineDto;
import com.gruppo1.progetto.services.IndirizzoService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Create a new address")
    public ResponseEntity<Optional<IndirizzoDto>> createIndirizzo(@RequestBody IndirizzoDto indirizzoDto, @RequestParam String author, @RequestParam Long idCliente) {

            return ResponseEntity.ok().body(Optional.of(indirizzoService.createIndirizzo(indirizzoDto, author)));
    }

    @GetMapping("/find")
    @Operation(summary = "Find address by ID",
            description= "The address must exist")
    public ResponseEntity<IndirizzoDto> readIndirizzoById(@RequestParam Long id) {
        return ResponseEntity.ok().body(indirizzoService.readIndirizzo(id));
    }

    @PutMapping("/update")
    @Operation(summary = "Update indirizzo by ID",
            description= "The address must exist")
    public ResponseEntity<Optional<IndirizzoDto>> updateIndirizzoById(@RequestBody IndirizzoDto indirizzoDto, @RequestParam String author) throws Exception {


            return ResponseEntity.ok().body(Optional.of(indirizzoService.updateIndirizzo(indirizzoDto, author)));

    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete address by ID",
            description= "Address must exist")
    public ResponseEntity<String> deleteIndirizzoById(@RequestParam Long id) {

            indirizzoService.deleteIndirizzo(id);
            return ResponseEntity.ok().body("Indirizzo correttamente cancellato");
    }
}

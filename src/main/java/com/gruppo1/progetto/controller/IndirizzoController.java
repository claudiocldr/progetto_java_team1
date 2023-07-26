package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.IndirizzoDto;
import com.gruppo1.progetto.services.IndirizzoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/indirizzo")
public class IndirizzoController {

    @Autowired
    public IndirizzoService indirizzoService;


    @PostMapping("/create")
    @Operation(summary = "Create a new address")
    public ResponseEntity<Optional<IndirizzoDto>> createIndirizzo(@RequestBody IndirizzoDto indirizzoDto, @RequestParam String author, @RequestParam Long idCliente) {

            return ResponseEntity.ok().body(Optional.of(indirizzoService.createIndirizzo(indirizzoDto, author, idCliente)));
    }

    @GetMapping("/find")
    @Operation(summary = "Find address by ID",
            description= "The address must exist")
    public ResponseEntity<IndirizzoDto> readIndirizzoById(@RequestParam Long id) {
        return ResponseEntity.ok().body(indirizzoService.findIndirizzo(id));
    }

    @GetMapping("/find-all")
    @Operation(summary = "Find all address by customer ID")
    public ResponseEntity<List<IndirizzoDto>> readIndirizziById(@RequestParam Long clienteId) {
        return ResponseEntity.ok().body(indirizzoService.findAllIndirizziByClienteId(clienteId));
    }


    @DeleteMapping("/delete")
    @Operation(summary = "Delete address by ID",
            description= "Address must exist")
    public ResponseEntity<IndirizzoDto> deleteIndirizzoById(@RequestParam Long id) {

            return ResponseEntity.ok().body(indirizzoService.deleteIndirizzo(id));

    }
}

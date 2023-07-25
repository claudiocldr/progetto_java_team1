package com.gruppo1.progetto.controller;
import com.gruppo1.progetto.dto.OrdineDto;
import com.gruppo1.progetto.models.Ordine;
import com.gruppo1.progetto.services.OrdineService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/ordine")
public class OrdineController {
    @Autowired
    public OrdineService ordineService;


    @GetMapping("/find")
    @Operation(summary = "Gets order by ID",
            description= "Order must exist")
    public ResponseEntity<Optional<OrdineDto>> findOrdineById(@RequestParam Long id) {
        return ResponseEntity.ok().body(Optional.of(ordineService.findOrdineById(id)));
    }

    @PostMapping("/create")
    @Operation(summary = "Insert a new order",
            description= "Order must exist")
    public ResponseEntity<Optional<OrdineDto>> insertOrdine(@RequestParam Long carrelloId, @RequestParam Long idCliente, @RequestParam String author) {
        OrdineDto ordine = ordineService.createOrdine(idCliente, carrelloId, author);
        return ResponseEntity.ok().body(Optional.of(ordine));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete order by ID",
            description= "Order must exist")
    public ResponseEntity<Optional<OrdineDto>> deleteOrdine (@RequestParam Long id)
    {
        return ResponseEntity.ok().body(Optional.of(ordineService.deleteOrdine(id)));
    }
}


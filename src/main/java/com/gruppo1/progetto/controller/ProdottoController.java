package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.ProdottoDto;
import com.gruppo1.progetto.services.ProdottoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/prodotto")
public class ProdottoController {

    @Autowired
    public ProdottoService prodottoService;

    @GetMapping("/find")
    @Operation(summary = "Find a product by ID",
            description= "Product must exist")
    public ResponseEntity<Optional<ProdottoDto>> getProdottoById(@RequestParam Long id) {
        Optional<ProdottoDto> prodottoDto = prodottoService.findProdottoAndReturnDto(id);
        if (prodottoDto.isPresent()) {
            return ResponseEntity.ok().body(prodottoDto);
        } else {
            return ResponseEntity.badRequest().body(prodottoDto);
        }
    }

    @PutMapping("/update")
    @Operation(summary = "Find a product by ID",
            description= "Product must exist")
    public ResponseEntity<Optional<ProdottoDto>> updateProdottoById (@RequestBody ProdottoDto prodottoDto, @RequestParam Long id, @RequestParam String author) {
            Optional<ProdottoDto> prodottoDtoAggiornato = Optional.of(prodottoService.updateProdotto(prodottoDto, id, author));
            return ResponseEntity.ok().body(prodottoDtoAggiornato);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete a product by ID",
            description= "Product must exist")
    public ResponseEntity<Optional<ProdottoDto>> deleteProdottoById(@RequestParam Long id) {
        Optional<ProdottoDto> prodottoDtoCancellato = prodottoService.deleteProdotto(id);
            return ResponseEntity.ok().body(prodottoDtoCancellato);

    }

    @PostMapping("/create")
    @Operation(summary = "Create a product by ID")
    public ResponseEntity<Optional<ProdottoDto>> insertProdotto(@RequestBody ProdottoDto prodottoDto, @RequestParam String author) throws Exception {
        Optional<ProdottoDto> prodottoDtoInserito = Optional.of(prodottoService.createProdotto(prodottoDto, author));
        return ResponseEntity.ok().body(prodottoDtoInserito);
    }

}

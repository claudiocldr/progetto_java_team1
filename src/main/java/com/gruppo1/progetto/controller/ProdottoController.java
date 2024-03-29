package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.ProdottoDto;
import com.gruppo1.progetto.dto.ProdottoDtoSenzaIdentificatoreArticolo;
import com.gruppo1.progetto.services.ProdottoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/prodotto")
public class ProdottoController {


    private final ProdottoService prodottoService;

    @Autowired
    public ProdottoController(ProdottoService prodottoService) {
        this.prodottoService = prodottoService;
    }

    @GetMapping("/find")
    @Operation(summary = "Find a product by its article identifier",
            description = "Product must exist")
    public ResponseEntity<Optional<ProdottoDto>> getProdottoByNumeroArticolo(@RequestParam UUID numeroArticolo) throws Exception {
        Optional<ProdottoDto> prodottoDto = prodottoService.findProdottoAndReturnDto(numeroArticolo);
        if (prodottoDto.get().getIdentificatoreArticolo() != null) {
            return ResponseEntity.ok().body(prodottoDto);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/find-all")
    @Operation(summary = "find all products")
    public ResponseEntity<List<ProdottoDto>> getAllProducts() {
    List<ProdottoDto> prodottoDtoList = prodottoService.findAllProdotto();
    return ResponseEntity.ok().body(prodottoDtoList);
    }

    @PutMapping("/update")
    @Operation(summary = "Update a product by its article identifier",
            description = "Product must exist")
    public ResponseEntity<Optional<ProdottoDto>> updateProdottoByNumeroArticolo(@RequestBody ProdottoDto prodottoDto, @RequestParam String author) {
        Optional<ProdottoDto> prodottoDtoAggiornato = Optional.of(prodottoService.updateProdotto(prodottoDto, author));
        if (prodottoDtoAggiornato.get().getIdentificatoreArticolo() != null) {
            return ResponseEntity.ok().body(prodottoDtoAggiornato);
        } else {
            return ResponseEntity.badRequest().body(prodottoDtoAggiornato);
        }
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete a product by its article identifier",
            description= "Product must exist")
    public ResponseEntity<Optional<ProdottoDto>> deleteProdottoById(@RequestParam UUID identificatoreArticolo) {
        Optional<ProdottoDto> prodottoDtoCancellato = Optional.of(prodottoService.deleteProdotto(identificatoreArticolo));
            if(prodottoDtoCancellato.get().getIdentificatoreArticolo() != null) {
                return ResponseEntity.ok().body(prodottoDtoCancellato);
            }
            else {
                return ResponseEntity.badRequest().body(prodottoDtoCancellato);
            }

    }

    @PostMapping("/create")
    @Operation(summary = "Create a product and save it to the database")
    public ResponseEntity<Optional<ProdottoDto>> insertProdotto(@RequestBody ProdottoDtoSenzaIdentificatoreArticolo prodottoDto, @RequestParam String author) throws Exception {
        Optional<ProdottoDto> prodottoDtoInserito = Optional.of(prodottoService.createProdotto(prodottoDto, author));
        if (prodottoDtoInserito.get().getNome() != null) {
            return ResponseEntity.ok().body(prodottoDtoInserito);
        }
        else {
            return ResponseEntity.badRequest().body(prodottoDtoInserito);
        }
    }

}

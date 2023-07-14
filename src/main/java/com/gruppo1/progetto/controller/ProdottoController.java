package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.ProdottoDto;
import com.gruppo1.progetto.services.ProdottoService;
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

    @GetMapping("/")
    public ResponseEntity<Optional<ProdottoDto>> getProdottoById(@RequestParam Long id) {
        Optional<ProdottoDto> prodottoDto = prodottoService.readProdotto(id);
        if (prodottoDto.isPresent()) {
            return ResponseEntity.ok().body(prodottoDto);
        } else {
            return ResponseEntity.badRequest().body(prodottoDto);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Optional<ProdottoDto>> updateProdottoById (@RequestBody Optional<ProdottoDto> prodottoDto, @RequestParam Long id, @RequestParam String author) {
            Optional<ProdottoDto> prodottoDtoAggiornato = prodottoService.updateProdotto(prodottoDto, id, author);
            return ResponseEntity.ok().body(prodottoDtoAggiornato);
    }

    @DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<ProdottoDto>> deleteProdottoById(@RequestParam Long id) {
        Optional<ProdottoDto> prodottoDtoCancellato = prodottoService.deleteProdotto(id);
            return ResponseEntity.ok().body(prodottoDtoCancellato);

    }

    @PostMapping("/")
    public ResponseEntity<Optional<ProdottoDto>> insertProdotto(@RequestBody Optional<ProdottoDto> prodottoDto, @RequestParam String author) {
        Optional<ProdottoDto> prodottoDtoInserito = prodottoService.createProdotto(prodottoDto, author);
        return ResponseEntity.ok().body(prodottoDtoInserito);
    }

}

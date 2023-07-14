package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.ProdottoDto;
import com.gruppo1.progetto.services.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/prodotto")
public class ProdottoController {

    @Autowired
    public ProdottoService prodottoService;

    @GetMapping("/")
    ResponseEntity<ProdottoDto> readProdottoById(@RequestParam Long id){
        return ResponseEntity.ok().body(prodottoService.readProdotto(id));
    }

    @PostMapping("/")
    ResponseEntity<String> insertProdotto(@RequestBody ProdottoDto prodottoDto, @RequestParam String author){
        try{
            prodottoService.createProdotto(prodottoDto, author);
            return ResponseEntity.ok().body("Prodotto inserito correttamete");
        } catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("Errorre nell'inseriemnto del prodotto");
    }


    @PutMapping("/update")
    ResponseEntity<String> updateProdottoById (@RequestBody ProdottoDto prodottoDto, @RequestParam Long id, @RequestParam String author) throws Exception {
        try {
            prodottoService.updateProdotto(prodottoDto, id, author);
            return ResponseEntity.ok().body("update del prodotto correttamente eseguito");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ResponseEntity.badRequest().body("errore nell'update del prodotto");
    }

    @DeleteMapping("/")
    ResponseEntity<String> deleteProdottoById(@RequestParam Long id) {
        try {
            prodottoService.deleteProdotto(id);
            return ResponseEntity.ok().body("Prodotto con id " + id + " cancellato");
        } catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body(("Errore nella cancellazione del prodotto"));
    }

}

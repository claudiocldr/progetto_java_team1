package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.OrdineDto;
import com.gruppo1.progetto.models.Ordine;
import com.gruppo1.progetto.models.OrdineProdotto;
import com.gruppo1.progetto.models.Prodotto;
import com.gruppo1.progetto.services.OrdineService;
import com.gruppo1.progetto.services.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/ordine")
public class OrdineController {
    @Autowired
    public OrdineService ordineService;

    @GetMapping("/")
    ResponseEntity<Optional<OrdineDto>> findOrdineById(@RequestParam UUID id) {
      return ResponseEntity.ok().body(Optional.of(ordineService.findOrdineById(id)));
    }

    @PostMapping("/")
    ResponseEntity<Optional<OrdineDto>> insertOrdine (@RequestBody ArrayList<Long> idProdottiOrdine,@RequestParam Long idCliente, @RequestParam String author)
    {
       Optional<OrdineDto> ordineDto = Optional.of(ordineService.createOrdine(idCliente, idProdottiOrdine, author));
        return ResponseEntity.ok().body(ordineDto);}
        }

//    @PutMapping("/update")
//    ResponseEntity<String> updateOrdineById(@RequestBody OrdineDto ordineDto, @RequestParam Long id, @RequestParam String author) throws Exception {
//        try {ordineService.updateOrdine(ordineDto, id, author);
//            return ResponseEntity.ok().body("modifica dell'ordine effettuata con successo");} catch (Exception e) {
//            return ResponseEntity.badRequest().body("c'è stato un problema con l'aggiornamento dell'ordine");
//        }


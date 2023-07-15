package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.CarrelloDto;
import com.gruppo1.progetto.dto.OrdineDto;
import com.gruppo1.progetto.dto.ProdottoDto;
import com.gruppo1.progetto.models.Carrello;
import com.gruppo1.progetto.models.Ordine;
import com.gruppo1.progetto.models.Prodotto;
import com.gruppo1.progetto.services.CarrelloService;
import com.gruppo1.progetto.services.OrdineService;
import com.gruppo1.progetto.services.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrello")
public class CarrelloController {
    @Autowired
    CarrelloService carrelloService;

    @Autowired
    OrdineService ordineService;

    @Autowired
    ProdottoService prodottoService;

    @GetMapping("/")
    ResponseEntity<Optional<CarrelloDto>> getCarrelloByOrderId(@RequestParam Long id) {
        return ResponseEntity.ok().body(carrelloService.readCarrelloByOrder(id));
    }

    @PostMapping("/")
    ResponseEntity<Optional<CarrelloDto>> insertNewCarrello(@RequestParam Long ordine_id, @RequestParam Long prodotto_id, @RequestParam String author) {
        Carrello carrello = new Carrello();
        Ordine ordine = ordineService.findOrdineById(ordine_id).get();
        carrello.setOrdine(ordine);
        Prodotto prodotto = prodottoService.findProdottoById(prodotto_id).get();
        carrello.setProdotto(prodotto);
        carrello.setCreatedBy(author);
        carrello.setCreatedOn(LocalDateTime.now());
        carrello.setModifyBy(author);
        carrello.setModifyOn(LocalDateTime.now());

        Optional<CarrelloDto> carrelloDto = Optional.of(new CarrelloDto());

        ProdottoDto prodottoDto = new ProdottoDto();
        prodottoDto.setDescrizione(prodotto.getDescrizione());
        prodottoDto.setId(prodotto.getId());
        prodottoDto.setNome(prodotto.getNome());
        prodottoDto.setPrezzo(prodotto.getPrezzo());
        prodottoDto.setSku(prodotto.getSku());

        OrdineDto ordineDto = new OrdineDto();
        ordineDto.setCliente(ordine.getCliente());
        ordineDto.setData(ordine.getDataOrdine());
        ordineDto.setId(ordine.getId());
        ordineDto.setProdotti(ordine.getProdotti());

        carrelloDto.get().setOrdineDto(ordineDto);
        carrelloDto.get().setProdottoDto(prodottoDto);


        return ResponseEntity.ok().body(carrelloDto);
    }

}



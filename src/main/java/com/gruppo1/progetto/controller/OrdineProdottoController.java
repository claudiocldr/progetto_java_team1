package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.OrdineProdottoDto;
import com.gruppo1.progetto.services.OrdineProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrello")
public class OrdineProdottoController {

    @Autowired
    public OrdineProdottoService ordineProdottoService;

    @PostMapping("/")
    public ResponseEntity<Optional<OrdineProdottoDto>> insertOrdineProdotto(@RequestParam Long ordineId,
                                                                            @RequestParam Long prodottoId,
                                                                            @RequestParam Long quantita)
    {   Optional<OrdineProdottoDto> ordineProdottoDto = ordineProdottoService.createOrdineProdotto(ordineId, prodottoId, quantita);
       return ResponseEntity.ok().body(ordineProdottoDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<Optional<OrdineProdottoDto>>> findOrdineProdottoById(@RequestParam Long id)
        {return ResponseEntity.ok().body(ordineProdottoService.findOrdineProdottoByOrderId(id));
    }

}

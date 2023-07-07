package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.OrdineDto;
import com.gruppo1.progetto.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrdineController {
    @Autowired
    OrdineService ordineService;

    @PostMapping("/update")
    ResponseEntity<String> updateById(@RequestBody OrdineDto ordineDto, @RequestParam Long id) throws Exception {
        ordineService.updateOrdine(ordineDto, id, "ciccio");
        return ResponseEntity.ok().build();
    }



}

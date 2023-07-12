package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    ResponseEntity<?> findClienteById(@RequestParam Long id) {
       try {
           return ResponseEntity.ok().body(clienteService.findClienteById(id));
       } catch (Exception e) {
           return ResponseEntity.badRequest().body("Impossibile trovare il cliente richiesto");
       }
    }

    @PostMapping("/update")
    ResponseEntity<String> updateClienteById(@RequestBody ClienteDto clienteDto, @RequestParam String email, @RequestParam String password, @RequestParam String author) throws Exception {
        try {
            Cliente cliente = clienteService.findClienteByEmailAndPassword(email, password);
            clienteService.updateClienteByEmailAndPassword(cliente, author);
            return ResponseEntity.ok().body("update correttamente eseguito");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("c'è stato un problema con l'update");
        }
    }
}

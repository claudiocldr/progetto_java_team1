package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/")
    ResponseEntity<?> getClienteById(@RequestParam Long id){
    ClienteDto clienteDto = clienteService.readCliente(id);
    if (clienteDto != null) {
        return ResponseEntity.ok().body(clienteDto);
    }
    else {
        return ResponseEntity.badRequest().body("Non è stato possibile trovare un cliente con l'id selezionato");
    }
    }

    @PutMapping("/update")
    ResponseEntity<String> updateClienteById(@RequestBody ClienteDto clienteDto, @RequestParam Long id, @RequestParam String author) {
        try {


           clienteService.updateCliente(id, clienteDto, author);
            return ResponseEntity.ok().body("update correttamente eseguito");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("c'è stato un problema con l'update");
    }

    @PostMapping("/")

    ResponseEntity<String> insertNewCliente(@RequestBody ClienteDto clienteDto, @RequestParam String author) {
        try {
            clienteService.insertCliente(clienteDto, author);
            return ResponseEntity.ok().body("Cliente correttamente inserito");
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body("C'è stato un problema con l'inserimento del cliente");
        }
    }

    @DeleteMapping("/")
    ResponseEntity<String> deleteClienteById (@RequestParam Long id) {
       try {clienteService.deleteCliente(id);
            return ResponseEntity.ok().body("Cliente correttamente cancellato");}
       catch (Exception e) {
           return ResponseEntity.badRequest().body("Errore nella cancellazione del cliente");
       }
    }
}

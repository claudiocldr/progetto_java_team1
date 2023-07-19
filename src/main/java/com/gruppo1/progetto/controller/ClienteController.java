package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    public ClienteService clienteService;

    @GetMapping("/get")
    public ResponseEntity<Optional<ClienteDto>> getClienteById(@RequestParam Long id) {
        ClienteDto cliente = clienteService.findClienteById(id);
        return ResponseEntity.ok().body(Optional.of(cliente));
    }

    @PutMapping("/update")
    public ResponseEntity<Optional<ClienteDto>> updateClienteById(@RequestBody ClienteDto clienteDto, @RequestParam Long id, @RequestParam String author) {

            ClienteDto clienteDtoAggiornato = clienteService.updateCliente(id, clienteDto, author);
            return ResponseEntity.ok().body(Optional.of(clienteDtoAggiornato));
    }
    @PostMapping("/create")

    public ResponseEntity<Optional<ClienteDto>> insertNewCliente(@RequestBody ClienteDto clienteDto, @RequestParam String author) {
            ClienteDto clienteDtoInserito =clienteService.insertCliente(clienteDto, author);
            return ResponseEntity.ok().body(Optional.of(clienteDtoInserito));
    }

    @DeleteMapping("/delete")

    public ResponseEntity<Optional<ClienteDto>> deleteCliente(@RequestParam Long id) {
        return ResponseEntity.ok().body(Optional.of(clienteService.deleteCliente(id)));
    }




}


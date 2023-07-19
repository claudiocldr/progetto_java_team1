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

    @GetMapping("/")
    public ResponseEntity<Optional<ClienteDto>> getClienteById(@RequestParam Long id) {
        ClienteDto cliente = clienteService.findClienteById(id);
        return ResponseEntity.ok().body(Optional.of(cliente));
    }

    @PutMapping("/update")
    public ResponseEntity<Optional<ClienteDto>> updateClienteById(@RequestBody ClienteDto clienteDto, @RequestParam Long id, @RequestParam String author) {

            ClienteDto clienteDtoAggiornato = clienteService.updateCliente(id, clienteDto, author);
            return ResponseEntity.ok().body(Optional.of(clienteDtoAggiornato));
    }
//        @DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//        public ResponseEntity<Optional<ClienteDto>> deleteClienteById (@RequestParam Long id){
//                Optional<ClienteDto> clienteDtoCancellato = clienteService.deleteCliente(id);
//                return ResponseEntity.ok().body(clienteDtoCancellato);
//        }
    @PostMapping("/")

    public ResponseEntity<Optional<ClienteDto>> insertNewCliente(@RequestBody ClienteDto clienteDto, @RequestParam String author) {
            ClienteDto clienteDtoInserito =clienteService.insertCliente(clienteDto, author);
            return ResponseEntity.ok().body(Optional.of(clienteDtoInserito));
    }


}


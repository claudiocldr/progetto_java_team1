package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
        Optional<ClienteDto> cliente = clienteService.findClienteById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok().body(cliente);
        } else {
            return ResponseEntity.badRequest().body(cliente);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Optional<ClienteDto>> updateClienteById(@RequestBody Optional<ClienteDto> clienteDto, @RequestParam Long id, @RequestParam String author) {
        if (clienteDto.isPresent()) {
            Optional<ClienteDto> clienteDto1 = clienteService.updateCliente(id, clienteDto, author);
            return ResponseEntity.ok().body(clienteDto1);
        } else {
            return ResponseEntity.badRequest().body(clienteDto);
        }
    }
        @DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Optional<ClienteDto>> deleteClienteById (@RequestParam Long id){
                Optional<ClienteDto> clienteDtoCancellato = clienteService.deleteCliente(id);
                return ResponseEntity.ok().body(clienteDtoCancellato);
        }
    @PostMapping("/")

    public ResponseEntity<Optional<ClienteDto>> insertNewCliente(@RequestBody Optional<ClienteDto> clienteDto, @RequestParam String author) {
            Optional<ClienteDto> clienteDtoInserito =clienteService.insertCliente(clienteDto, author);
            return ResponseEntity.ok().body(clienteDtoInserito);
    }


}


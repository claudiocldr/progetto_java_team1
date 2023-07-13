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

    @PutMapping("/update")
    ResponseEntity<?> updateClienteById(@RequestBody ClienteDto clienteDto, @RequestParam Long id, @RequestParam String author) throws Exception {
        try {


            clienteService.updateCliente(id, clienteDto, author);
            return ResponseEntity.ok().body("update correttamente eseguito");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("c'è stato un problema con l'update");
    }
}

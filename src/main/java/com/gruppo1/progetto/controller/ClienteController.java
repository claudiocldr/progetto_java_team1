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

    @PostMapping("/update")
    ResponseEntity<?> updateClienteByUsername(@RequestBody ClienteDto clienteDto, @RequestParam String email, @RequestParam String password, @RequestParam String author) throws Exception {
        try {
            Cliente cliente = clienteService.findCliente(email, password);
            cliente.setNome(clienteDto.getNome());
            cliente.setCognome(clienteDto.getCognome());
            cliente.setDataDiNascita(clienteDto.getDataDiNascita());
            cliente.setTelefono(clienteDto.getTelefono());
            cliente.setEmail(clienteDto.getEmail());
            cliente.setCodiceFiscale(clienteDto.getCodiceFiscale());
            cliente.setTelefono(clienteDto.getPassword());
            clienteService.updateCliente(cliente, author);
            return ResponseEntity.ok().body("update correttamente eseguito");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("c'è stato un problema con l'update");
    }
}

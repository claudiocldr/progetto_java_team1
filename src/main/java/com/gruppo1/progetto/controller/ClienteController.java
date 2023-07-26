package com.gruppo1.progetto.controller;

import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.dto.RiepilogoOrdine;
import com.gruppo1.progetto.dto.RigaOrdineDto;
import com.gruppo1.progetto.services.ClienteService;
import com.gruppo1.progetto.services.RigaOrdineService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    public ClienteService clienteService;
    @Autowired
    public RigaOrdineService rigaOrdineService;

    @GetMapping("/find")
    @Operation(summary = "Gets customer by ID",
            description = "Customer must exist")
    public ResponseEntity<Optional<ClienteDto>> getClienteById(@RequestParam Long id) {
        ClienteDto cliente = clienteService.findClienteById(id);
        return ResponseEntity.ok().body(Optional.of(cliente));
    }

    @PutMapping("/update")
    @Operation(summary = "Update customer",
            description = "Customer must exist")
    public ResponseEntity<Optional<ClienteDto>> updateClienteById(@RequestBody ClienteDto clienteDto, @RequestParam Long id, @RequestParam String author) {

        ClienteDto clienteDtoAggiornato = clienteService.updateCliente(id, clienteDto, author);
        return ResponseEntity.ok().body(Optional.of(clienteDtoAggiornato));
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new customer")

    public ResponseEntity<Optional<ClienteDto>> insertNewCliente(@RequestBody ClienteDto clienteDto, @RequestParam String author) {
        ClienteDto clienteDtoInserito = clienteService.insertCliente(clienteDto, author);
        return ResponseEntity.ok().body(Optional.of(clienteDtoInserito));
    }

    @PostMapping("/insert-product")
    @Operation(summary = "insert a new product into the selected shopping cart")
    public ResponseEntity<Optional<RigaOrdineDto>> insertProductIntoCart(@RequestParam Long clienteId, @RequestParam String nomeCarrello,
                                                                         @RequestParam Long prodottoId, @RequestParam Integer quantita) {
        Optional< RigaOrdineDto> rigaOrdineDto = rigaOrdineService.inserisciProdottoNelCarrello(nomeCarrello, clienteId, prodottoId, quantita);
        if (rigaOrdineDto.isPresent()) {
            return ResponseEntity.ok().body(rigaOrdineDto);
        }else {
            return ResponseEntity.badRequest().body(rigaOrdineDto);
        }
    }
    @PostMapping("/buy")
    @Operation(summary = "make your purchase")
    public ResponseEntity<RiepilogoOrdine> buy(@RequestParam Long clienteId, @RequestParam Long metodoDiPagamentoId, @RequestParam String carrelloNome, @RequestParam Long indirizzoDiSpedizioneAlternativoId, @RequestParam String author){
        return ResponseEntity.ok().body(clienteService.buy(clienteId, metodoDiPagamentoId, carrelloNome, indirizzoDiSpedizioneAlternativoId, author));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Update customer",
            description = "Customer must exist")

    public ResponseEntity<Optional<ClienteDto>> deleteCliente(@RequestParam Long id) {
        return ResponseEntity.ok().body(Optional.of(clienteService.deleteCliente(id)));
    }


}


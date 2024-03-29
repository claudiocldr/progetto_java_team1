package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.dto.IndirizzoDto;
import com.gruppo1.progetto.dto.IndirizzoSenzaIdDto;
import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.models.Indirizzo;
import com.gruppo1.progetto.repositories.ClienteRepository;
import com.gruppo1.progetto.repositories.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IndirizzoService {
    @Autowired
    private IndirizzoRepository indirizzoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Create
    public IndirizzoDto createIndirizzo(IndirizzoSenzaIdDto indirizzoDto, String author, Long clienteId) {

        Indirizzo iE = new Indirizzo();
        iE.setVia(indirizzoDto.getVia());
        iE.setCap(indirizzoDto.getCap());
        iE.setNumeroCivico(indirizzoDto.getNumeroCivico());
        iE.setCreatedBy(author);
        iE.setCreatedOn(LocalDateTime.now());
        iE.setModifyBy(author);
        iE.setModifyOn(LocalDateTime.now());
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        ClienteDto clienteDto = new ClienteDto(cliente.get().getId(),
                cliente.get().getNome(),
                cliente.get().getCognome(),
                cliente.get().getDataDiNascita(),
                cliente.get().getTelefono(),
                cliente.get().getEmail(),
                cliente.get().getCodiceFiscale(),
                cliente.get().getPassword());
        iE.setCliente(cliente.get());
        indirizzoDto.setClienteDto(clienteDto);
        Indirizzo indirizzoCreato = indirizzoRepository.save(iE);
        IndirizzoDto indirizzoDtoForResponse = new IndirizzoDto(indirizzoCreato.getId(),
                indirizzoCreato.getVia(),
                indirizzoCreato.getCap(),
                indirizzoCreato.getNumeroCivico(),
                clienteDto);

        return indirizzoDtoForResponse;


    }

    // Read
    public IndirizzoDto findIndirizzo(Long id) {
        Optional<Indirizzo> indirizzo = indirizzoRepository.findById(id);
        if (indirizzo.isPresent()) {
            IndirizzoDto indirizzoDto = new IndirizzoDto();
            Indirizzo i = indirizzo.get();
            indirizzoDto.setId(indirizzo.get().getId());
            indirizzoDto.setVia(i.getVia());
            indirizzoDto.setCap(i.getCap());
            indirizzoDto.setNumeroCivico(i.getNumeroCivico());
            return indirizzoDto;
        }
        return null;
    }

    public List<IndirizzoDto> findAllIndirizziByClienteId(Long clienteId) {
        List<Indirizzo> indirizzi = indirizzoRepository.findByClienteId(clienteId).get();
        Cliente cliente = clienteRepository.findById(clienteId).get();
        ClienteDto clienteDto = new ClienteDto(cliente.getId(),
                cliente.getNome(),
                cliente.getCognome(),
                cliente.getDataDiNascita(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getCodiceFiscale(),
                cliente.getPassword());
        List<IndirizzoDto> indirizziDto = indirizzi.stream().map(x -> new IndirizzoDto(x.getId(), x.getVia(), x.getCap(), x.getNumeroCivico(), clienteDto)).collect(Collectors.toList());
        return indirizziDto;
    }


    // Delete
    public IndirizzoDto deleteIndirizzo(Long id) {
        Indirizzo indirizzo = indirizzoRepository.findById(id).get();
        IndirizzoDto indirizzoCancellato = new IndirizzoDto();
        indirizzoCancellato.setId(indirizzo.getId());
        indirizzoCancellato.setCap(indirizzo.getCap());
        indirizzoCancellato.setVia(indirizzo.getVia());
        indirizzoCancellato.setNumeroCivico(indirizzo.getNumeroCivico());
        indirizzoRepository.deleteIndirizzoById(id);
        return indirizzoCancellato;
    }
}

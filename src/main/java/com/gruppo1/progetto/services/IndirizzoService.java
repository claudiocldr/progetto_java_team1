package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.dto.IndirizzoDto;
import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.models.Indirizzo;
import com.gruppo1.progetto.models.RecordStatusEnum;
import com.gruppo1.progetto.repositories.ClienteRepository;
import com.gruppo1.progetto.repositories.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class IndirizzoService {
    @Autowired
    private IndirizzoRepository indirizzoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Create
    public IndirizzoDto createIndirizzo(IndirizzoDto indirizzoDto, String author) {

        Indirizzo iE = new Indirizzo();
        iE.setVia(indirizzoDto.getVia());
        iE.setCap(indirizzoDto.getCap());
        iE.setNumeroCivico(indirizzoDto.getNumeroCivico());
        iE.setCreatedBy(author);
        iE.setCreatedOn(LocalDateTime.now());
        iE.setModifyBy(author);
        iE.setModifyOn(LocalDateTime.now());
        Optional<Cliente> cliente = clienteRepository.findById(indirizzoDto.getId());
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
        indirizzoRepository.save(iE);
        return indirizzoDto;


    }

    // Read
    public IndirizzoDto readIndirizzo(Long id) {
        Optional<Indirizzo> indirizzo = indirizzoRepository.findById(id);
        if (indirizzo.isPresent()) {
            IndirizzoDto indirizzoDto = new IndirizzoDto();
            Indirizzo i = indirizzo.get();
            indirizzoDto.setId(indirizzoDto.getId());
            indirizzoDto.setVia(i.getVia());
            indirizzoDto.setCap(i.getCap());
            indirizzoDto.setNumeroCivico(i.getNumeroCivico());
            return indirizzoDto;
        }
        return null;
    }

    // Update
    public IndirizzoDto updateIndirizzo(IndirizzoDto indirizzoDto, String author) {
        Indirizzo i = new Indirizzo();
//        Long id, String nome, String cognome, LocalDate dataDiNascita, String telefono, String email, String codiceFiscale, String password, List<Indirizzo> indirizzi, RecordStatusEnum
//        status
//        i.setCliente(new Cliente(
//                indirizzoDto.getClienteDto().getId(),
//                indirizzoDto.getClienteDto().getNome(),
//                indirizzoDto.getClienteDto().getCognome(),
//                indirizzoDto.getClienteDto().getDataDiNascita(),
//                indirizzoDto.getClienteDto().getTelefono(),
//                indirizzoDto.getClienteDto().getEmail(),
//                indirizzoDto.getClienteDto().getCodiceFiscale(),
//                indirizzoDto.getClienteDto().getPassword(),
//                new ArrayList<Indirizzo>(), RecordStatusEnum.A ));
//        i.getCliente().setIndirizzi((indirizzoRepository.findAllByClienteId(i.getCliente().getId()).get()));

        i.setId(indirizzoDto.getId());
        i.setVia(indirizzoDto.getVia());
        i.setCap(indirizzoDto.getCap());
        i.setNumeroCivico(indirizzoDto.getNumeroCivico());
        i.setModifyBy(author);
        i.setModifyOn(LocalDateTime.now());
        indirizzoRepository.updateIndirizzoById(i.getVia(), i.getCap(), i.getNumeroCivico(), i.getModifyBy(), i.getModifyOn(), i.getId());
//        Optional<Indirizzo> indirizzo = indirizzoRepository.findById(i.getId());
//        ClienteDto clienteDto = new ClienteDto(indirizzo.get().getCliente().getId(),
//                indirizzo.get().getCliente().getNome(),
//                indirizzo.get().getCliente().getCognome(),
//                indirizzo.get().getCliente().getDataDiNascita(),
//                indirizzo.get().getCliente().getTelefono(),
//                indirizzo.get().getCliente().getEmail(),
//                indirizzo.get().getCliente().getCodiceFiscale(),
//                indirizzo.get().getCliente().getPassword());
//        indirizzoDto.setClienteDto(clienteDto);

        return indirizzoDto;
    }

    // Delete
    public void deleteIndirizzo(Long id) {
        try {
            indirizzoRepository.deleteById(id.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.gruppo1.progetto.services;

import com.gruppo1.progetto.models.RecordStatusEnum;
import com.gruppo1.progetto.repositories.ClienteRepository;
import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.models.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class ClienteService {
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);


    @Autowired
    private ClienteRepository clienteRepository;


    //Create
    public Optional<ClienteDto> insertCliente(Optional<ClienteDto> clienteDto, String author) {
        if(clienteDto.isPresent()){
        Cliente c = new Cliente();
        c.setNome(clienteDto.get().getNome());
        c.setCodiceFiscale(clienteDto.get().getCodiceFiscale());
        c.setCognome(clienteDto.get().getCognome());
        c.setDataDiNascita(clienteDto.get().getDataDiNascita());
        c.setEmail(clienteDto.get().getEmail());
        c.setId(clienteDto.get().getId());
        c.setIndirizzi(clienteDto.get().getIndirizzi());
        c.setOrdini(clienteDto.get().getOrdini());
        c.setPassword(clienteDto.get().getPassword());
        c.setStatus(RecordStatusEnum.A);
        c.setTelefono(clienteDto.get().getTelefono());
        c.setModifyBy(author);
        c.setModifyOn(LocalDateTime.now());
        c.setCreatedBy(author);
        c.setCreatedOn(LocalDateTime.now());
            clienteRepository.save(c);}
        return clienteDto;
    }

    //Read
    public Optional<ClienteDto> findClienteById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        Optional<ClienteDto> clienteDto = Optional.of(new ClienteDto());
        if (cliente.isPresent()) {
            clienteDto.get().setId(cliente.get().getId());
            clienteDto.get().setCognome(cliente.get().getCognome());
            clienteDto.get().setNome(cliente.get().getNome());
            clienteDto.get().setPassword(cliente.get().getPassword());
            clienteDto.get().setCodiceFiscale(cliente.get().getCodiceFiscale());
            clienteDto.get().setOrdini(cliente.get().getOrdini());
            clienteDto.get().setIndirizzi(cliente.get().getIndirizzi());
            clienteDto.get().setDataDiNascita(cliente.get().getDataDiNascita());
            clienteDto.get().setEmail(cliente.get().getEmail());
            clienteDto.get().setTelefono(cliente.get().getTelefono());
        }
        return clienteDto;
    }

    //Update
    public Optional<ClienteDto> updateCliente(Long id, Optional<ClienteDto> clienteDto, String author) {
        LocalDateTime modifyOn = LocalDateTime.now();
        clienteRepository.updateClienteById(
                clienteDto.get().getDataDiNascita(),
                modifyOn,
                clienteDto.get().getCodiceFiscale(),
                clienteDto.get().getCognome(),
                clienteDto.get().getEmail(),
                author,
                clienteDto.get().getNome(),
                clienteDto.get().getPassword(),
                RecordStatusEnum.A.name(),
                clienteDto.get().getTelefono(),
                id);
        Optional<Cliente> cliente = clienteRepository.findById(id);
        Optional<ClienteDto> clienteDtoAggiornato = Optional.of(new ClienteDto());
        clienteDtoAggiornato.get().setCodiceFiscale(cliente.get().getCodiceFiscale());
        clienteDtoAggiornato.get().setCognome(cliente.get().getCognome());
        clienteDtoAggiornato.get().setDataDiNascita(cliente.get().getDataDiNascita());
        clienteDtoAggiornato.get().setEmail(cliente.get().getEmail());
        clienteDtoAggiornato.get().setId(cliente.get().getId());
        clienteDtoAggiornato.get().setIndirizzi(cliente.get().getIndirizzi());
        clienteDtoAggiornato.get().setNome(cliente.get().getNome());
        clienteDtoAggiornato.get().setOrdini(cliente.get().getOrdini());
        clienteDtoAggiornato.get().setPassword(cliente.get().getPassword());
        clienteDtoAggiornato.get().setTelefono(cliente.get().getTelefono());
    return clienteDtoAggiornato;
    }
//Delete
public Optional<ClienteDto> deleteCliente(Long id){
        Optional<Cliente> clienteDaCancellare = clienteRepository.findById(id);
        clienteRepository.deleteClienteById(id);
    Optional<ClienteDto> clienteDtoCancellato = Optional.of(new ClienteDto());
    if (clienteDaCancellare.isPresent()) {
        clienteDtoCancellato.get().setCodiceFiscale(clienteDaCancellare.get().getCodiceFiscale());
        clienteDtoCancellato.get().setCognome(clienteDaCancellare.get().getCognome());
        clienteDtoCancellato.get().setDataDiNascita(clienteDaCancellare.get().getDataDiNascita());
        clienteDtoCancellato.get().setEmail(clienteDaCancellare.get().getEmail());
        clienteDtoCancellato.get().setId(clienteDaCancellare.get().getId());
        clienteDtoCancellato.get().setIndirizzi(clienteDaCancellare.get().getIndirizzi());
        clienteDtoCancellato.get().setNome(clienteDaCancellare.get().getNome());
        clienteDtoCancellato.get().setOrdini(clienteDaCancellare.get().getOrdini());
        clienteDtoCancellato.get().setPassword(clienteDaCancellare.get().getPassword());
        clienteDtoCancellato.get().setTelefono(clienteDaCancellare.get().getTelefono());}
    return clienteDtoCancellato;
}
}
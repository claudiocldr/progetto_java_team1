package com.gruppo1.progetto.services;
import com.gruppo1.progetto.models.RecordStatusEnum;
import com.gruppo1.progetto.repositories.ClienteRepository;
import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.repositories.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OrdineRepository ordineRepository;


    //Create
    public ClienteDto insertCliente(ClienteDto clienteDto, String author) {
            Cliente c = new Cliente();
            c.setNome(clienteDto.getNome());
            c.setCodiceFiscale(clienteDto.getCodiceFiscale());
            c.setCognome(clienteDto.getCognome());
            c.setDataDiNascita(clienteDto.getDataDiNascita());
            c.setEmail(clienteDto.getEmail());
            c.setPassword(clienteDto.getPassword());
            c.setStatus(RecordStatusEnum.A);
            c.setTelefono(clienteDto.getTelefono());
            c.setModifyBy(author);
            c.setModifyOn(LocalDateTime.now());
            c.setCreatedBy(author);
            c.setCreatedOn(LocalDateTime.now());
            clienteRepository.save(c);
        return clienteDto;
    }

    //Read
    public ClienteDto findClienteById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            ClienteDto clienteDto = new ClienteDto(cliente.get().getId(),
                    cliente.get().getNome(),
                    cliente.get().getCognome(),
                    cliente.get().getDataDiNascita(),
                    cliente.get().getTelefono(),
                    cliente.get().getEmail(),
                    cliente.get().getCodiceFiscale(),
                    cliente.get().getPassword());
            return clienteDto;
        }
        return new ClienteDto();


    }
}

    //Update
//    public Optional<ClienteDto> updateCliente(Long id, Optional<ClienteDto> clienteDto, String author) {
//        LocalDateTime modifyOn = LocalDateTime.now();
//        clienteRepository.updateClienteById(
//                clienteDto.get().getDataDiNascita(),
//                modifyOn,
//                clienteDto.get().getCodiceFiscale(),
//                clienteDto.get().getCognome(),
//                clienteDto.get().getEmail(),
//                author,
//                clienteDto.get().getNome(),
//                clienteDto.get().getPassword(),
//                RecordStatusEnum.A.name(),
//                clienteDto.get().getTelefono(),
//                id);
//        Optional<Cliente> cliente = clienteRepository.findById(id);
//        Optional<ClienteDto> clienteDtoAggiornato = Optional.of(new ClienteDto());
//        clienteDtoAggiornato.get().setCodiceFiscale(cliente.get().getCodiceFiscale());
//        clienteDtoAggiornato.get().setCognome(cliente.get().getCognome());
//        clienteDtoAggiornato.get().setDataDiNascita(cliente.get().getDataDiNascita());
//        clienteDtoAggiornato.get().setEmail(cliente.get().getEmail());
//        clienteDtoAggiornato.get().setId(cliente.get().getId());
//        clienteDtoAggiornato.get().setIndirizzi(cliente.get().getIndirizzi());
//        clienteDtoAggiornato.get().setNome(cliente.get().getNome());
//        clienteDtoAggiornato.get().setOrdini(cliente.get().getOrdini());
//        clienteDtoAggiornato.get().setPassword(cliente.get().getPassword());
//        clienteDtoAggiornato.get().setTelefono(cliente.get().getTelefono());
//    return clienteDtoAggiornato;
//    }
////Delete
//public Optional<ClienteDto> deleteCliente(Long id){
//        Optional<Cliente> clienteDaCancellare = clienteRepository.findById(id);
//        clienteRepository.deleteClienteById(id);
//    Optional<ClienteDto> clienteDtoCancellato = Optional.of(new ClienteDto());
//    if (clienteDaCancellare.isPresent()) {
//        clienteDtoCancellato.get().setCodiceFiscale(clienteDaCancellare.get().getCodiceFiscale());
//        clienteDtoCancellato.get().setCognome(clienteDaCancellare.get().getCognome());
//        clienteDtoCancellato.get().setDataDiNascita(clienteDaCancellare.get().getDataDiNascita());
//        clienteDtoCancellato.get().setEmail(clienteDaCancellare.get().getEmail());
//        clienteDtoCancellato.get().setId(clienteDaCancellare.get().getId());
//        clienteDtoCancellato.get().setIndirizzi(clienteDaCancellare.get().getIndirizzi());
//        clienteDtoCancellato.get().setNome(clienteDaCancellare.get().getNome());
//        clienteDtoCancellato.get().setOrdini(clienteDaCancellare.get().getOrdini());
//        clienteDtoCancellato.get().setPassword(clienteDaCancellare.get().getPassword());
//        clienteDtoCancellato.get().setTelefono(clienteDaCancellare.get().getTelefono());}
//    return clienteDtoCancellato;

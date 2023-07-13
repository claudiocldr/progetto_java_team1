package com.gruppo1.progetto.services;

import com.gruppo1.progetto.models.RecordStatusEnum;
import com.gruppo1.progetto.repositories.ClienteRepository;
import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteDto clienteDto;


    //Create
    public void insertCliente (ClienteDto clienteDto, String author){
        Cliente cE = new Cliente();
        cE.setId(clienteDto.getId());
        cE.setNome(clienteDto.getNome());
        cE.setCognome(clienteDto.getCognome());
        cE.setDataDiNascita(clienteDto.getDataDiNascita());
        cE.setTelefono(clienteDto.getTelefono());
        cE.setEmail(clienteDto.getEmail());
        cE.setCodiceFiscale(clienteDto.getCodiceFiscale());
        cE.setPassword(clienteDto.getPassword());
        cE.setModifyBy(author);
        cE.setModifyOn(LocalDateTime.now());
        cE.setCreatedBy(author);
        cE.setCreatedOn(LocalDateTime.now());

        clienteRepository.save(cE);
    }

    //Read
    public ClienteDto readCliente(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(Math.toIntExact(id));
        if (cliente.isPresent()) {
        clienteDto.setId(cliente.get().getId());
        clienteDto.setCognome(cliente.get().getCognome());
        clienteDto.setNome(cliente.get().getNome());
        clienteDto.setPassword(cliente.get().getPassword());
        clienteDto.setCodiceFiscale(cliente.get().getCodiceFiscale());
        clienteDto.setOrdini(cliente.get().getOrdini());
        clienteDto.setIndirizzi(cliente.get().getIndirizzi());
        clienteDto.setDataDiNascita(cliente.get().getDataDiNascita());
        clienteDto.setEmail(cliente.get().getEmail());
        clienteDto.setTelefono(cliente.get().getTelefono());

        return clienteDto;}
        else {
            return clienteDto;
        }
    }

    //Update
    public void updateCliente(Long id, ClienteDto clienteDto, String author){
        try{
            if(clienteDto == null){
                throw new Exception();
            }else {
                try {
                LocalDateTime modifyOn = LocalDateTime.now();
                clienteRepository.updateClienteById(
                        clienteDto.getDataDiNascita(),
                        modifyOn,
                        clienteDto.getCodiceFiscale(),
                        clienteDto.getCognome(),
                        clienteDto.getEmail(),
                        author,
                        clienteDto.getNome(),
                        clienteDto.getPassword(),
                        RecordStatusEnum.A.name(),
                        clienteDto.getTelefono(),
                        id);}
                catch (Exception e)
                {
                    e.printStackTrace();
                    Logger logger = Logger.getLogger("clienteLogger");
                    logger.log(new LogRecord(Level.WARNING, "C'è stato un errore con l'update"));

                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //Delete
    public void deleteCliente(Long id){
        try {
            clienteRepository.deleteById(id.intValue());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Cliente findCliente(String email, String password) {
        return clienteRepository.findClienteByEmailAndPassword(email, password);

    }
}

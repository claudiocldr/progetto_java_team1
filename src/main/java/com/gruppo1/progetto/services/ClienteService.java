package com.gruppo1.progetto.services;

import com.gruppo1.progetto.models.RecordStatusEnum;
import com.gruppo1.progetto.repositories.ClienteRepository;
import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    //Create
    public void createCliente (ClienteDto clienteDto, String author){
        Cliente cE = new Cliente();
        cE.setNome(clienteDto.getNome());
        cE.setCognome(clienteDto.getCognome());
        cE.setDataDiNascita(clienteDto.getDataDiNascita());
        cE.setTelefono(clienteDto.getTelefono());
        cE.setEmail(clienteDto.getEmail());
        cE.setCodiceFiscale(clienteDto.getCodiceFiscale());
        cE.setPassword(clienteDto.getPassword());
        cE.setCreatedBy(author);
        cE.setCreatedOn(LocalDateTime.now());

        clienteRepository.save(cE);
    }

    //Read
    public ClienteDto readCliente(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id.intValue());

        if(cliente.isPresent()){
            ClienteDto clienteDto = new ClienteDto();
            Cliente c = cliente.get();
            clienteDto.setNome(c.getNome());
            clienteDto.setCognome(c.getCognome());
            clienteDto.setDataDiNascita(c.getDataDiNascita());
            clienteDto.setTelefono(c.getTelefono());
            clienteDto.setEmail(c.getEmail());
            clienteDto.setCodiceFiscale(c.getCodiceFiscale());
            clienteDto.setPassword(c.getPassword());
            return clienteDto;
        }
        return null;
    }

    //Update
    public void updateCliente(Cliente cliente, String author){
        try{
            if(cliente == null){
                throw new Exception("Impossibile aggiornare il cliente, l'oggetto è null");
            } else {
                LocalDateTime modifyOn = LocalDateTime.now();
                clienteRepository.updateClienteById(
                        cliente.getDataDiNascita(),
                        modifyOn,
                        cliente.getCodiceFiscale(),
                        cliente.getCognome(),
                        cliente.getEmail(),
                        author,
                        cliente.getNome(),
                        cliente.getPassword(),
                        RecordStatusEnum.D.name(),
                        cliente.getTelefono(),
                        cliente.getId()
                        );
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

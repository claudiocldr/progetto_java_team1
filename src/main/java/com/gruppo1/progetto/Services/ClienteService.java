package com.gruppo1.progetto.Services;

import com.gruppo1.progetto.Repositories.ClienteRepo;
import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepo<Cliente> clienteRepo;

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

        clienteRepo.save(cE);
    }

    //Read
    public ClienteDto readCliente(Long id){
        Optional<Cliente> cliente = clienteRepo.findById(id.intValue());

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
    public void updateCliente(ClienteDto clienteDto, String author){
        try{
            if(clienteDto.equals(null)){
                throw new Exception("Impossibile aggiornare il cliente, l'oggetto è null");
            } else {
                Cliente c = new Cliente();
                c.setNome(clienteDto.getNome());
                c.setCognome(clienteDto.getCognome());
                c.setDataDiNascita(clienteDto.getDataDiNascita());
                c.setTelefono(clienteDto.getTelefono());
                c.setEmail(clienteDto.getEmail());
                c.setCodiceFiscale(clienteDto.getCodiceFiscale());
                c.setPassword(clienteDto.getPassword());
                c.setModifyBy(author);
                c.setModifyOn(LocalDateTime.now());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //Delete
    public void deleteCliente(Long id){
        try {
            clienteRepo.deleteById(id.intValue());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.*;
import com.gruppo1.progetto.models.*;
import com.gruppo1.progetto.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdineService {

    final private ClienteRepository clienteRepository;
    final private OrdineRepository ordineRepository;
    final private CarrelloRepository carrelloRepository;
    final private RigaOrdineService rigaOrdineService;

    @Autowired
    public OrdineService(ClienteRepository clienteRepository, OrdineRepository ordineRepository, CarrelloRepository carrelloRepository, RigaOrdineService rigaOrdineService) {
        this.clienteRepository = clienteRepository;
        this.ordineRepository = ordineRepository;
        this.carrelloRepository = carrelloRepository;
        this.rigaOrdineService = rigaOrdineService;
    }

    public OrdineDto createOrdine(Long idCliente, String nomeCarrello, String author) {

        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(cliente.get().getId());
        clienteDto.setEmail(cliente.get().getEmail());
        clienteDto.setTelefono(cliente.get().getTelefono());
        clienteDto.setDataDiNascita(cliente.get().getDataDiNascita());
        clienteDto.setNome(cliente.get().getNome());
        clienteDto.setCognome(cliente.get().getCognome());
        clienteDto.setPassword(cliente.get().getPassword());
        clienteDto.setCodiceFiscale(cliente.get().getCodiceFiscale());


        Ordine ordine = new Ordine();
        ordine.setDataOrdine(LocalDate.now());
        ordine.setCliente(cliente.get());
        ordine.setCreatedBy(author);
        ordine.setCreatedOn(LocalDateTime.now());
        ordine.setModifyBy(author);
        ordine.setModifyOn(LocalDateTime.now());
        Carrello carrelloSelezionato = carrelloRepository.findByNomeAndClienteId(nomeCarrello, cliente.get().getId()).get();

        ordine.setCarrello(List.of(carrelloSelezionato));

        List<RigaOrdineDto> rigaOrdineList = rigaOrdineService.getAllByCarrelloId(carrelloSelezionato.getId());


        ordine.setCliente(clienteRepository.findById(idCliente).get());
        Ordine ordineSalvato = ordineRepository.save(ordine);

        OrdineDto ordineDto = new OrdineDto();
        ordineDto.setClienteDto(clienteDto);
        ordineDto.setData(ordine.getDataOrdine());
        ordineDto.setProdotti(rigaOrdineList);

        ordineDto.setId(ordineSalvato.getId());
        return ordineDto;

    }
    public OrdineDto findOrdineById(Long id) {

        Optional<Ordine> ordine = ordineRepository.findById(id);
        OrdineDto ordineDto = new OrdineDto();
        ordineDto.setId(ordine.get().getId());

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setCodiceFiscale(ordine.get().getCliente().getCodiceFiscale());
        clienteDto.setCognome(ordine.get().getCliente().getCognome());
        clienteDto.setDataDiNascita(ordine.get().getCliente().getDataDiNascita());
        clienteDto.setEmail(ordine.get().getCliente().getEmail());
        clienteDto.setId(ordine.get().getCliente().getId());
        clienteDto.setNome(ordine.get().getCliente().getNome());
        clienteDto.setPassword(ordine.get().getCliente().getPassword());
        clienteDto.setTelefono(ordine.get().getCliente().getTelefono());
        ordineDto.setClienteDto(clienteDto);
        ordineDto.setData(ordine.get().getDataOrdine());

        List<RigaOrdineDto> listaProdotti = rigaOrdineService.getAllByCarrelloId(ordine.get().getCarrello().get(0).getId());
        ordineDto.setProdotti(listaProdotti);

        return ordineDto;
    }


    //Delete
    public OrdineDto deleteOrdine(Long id) {

        Optional<Ordine> ordine = ordineRepository.findById(id);
        ordineRepository.deleteById(id);
        OrdineDto ordineDto = new OrdineDto();
        ordineDto.setId(ordine.get().getId());

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setCodiceFiscale(ordine.get().getCliente().getCodiceFiscale());
        clienteDto.setCognome(ordine.get().getCliente().getCognome());
        clienteDto.setDataDiNascita(ordine.get().getCliente().getDataDiNascita());
        clienteDto.setEmail(ordine.get().getCliente().getEmail());
        clienteDto.setId(ordine.get().getCliente().getId());
        clienteDto.setNome(ordine.get().getCliente().getNome());
        clienteDto.setPassword(ordine.get().getCliente().getPassword());
        clienteDto.setTelefono(ordine.get().getCliente().getTelefono());
        ordineDto.setClienteDto(clienteDto);
        ordineDto.setData(ordine.get().getDataOrdine());

        List<RigaOrdineDto> listaProdotti = rigaOrdineService.getAllByCarrelloId(ordine.get().getCarrello().get(0).getId());
        ordineDto.setProdotti(listaProdotti);


        return ordineDto;

    }
}


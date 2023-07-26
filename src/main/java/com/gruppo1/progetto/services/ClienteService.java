package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.*;
import com.gruppo1.progetto.models.*;
import com.gruppo1.progetto.repositories.CarrelloRepository;
import com.gruppo1.progetto.repositories.ClienteRepository;
import com.gruppo1.progetto.repositories.OrdineRepository;
import com.gruppo1.progetto.repositories.RigaOrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;


@Service
public class ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private OrdineService ordineService;
    @Autowired
    private MetodoDiPagamentoService metodoDiPagamentoService;
    @Autowired
    private IndirizzoService indirizzoService;

    @Autowired
    private CarrelloRepository carrelloRepository;

    @Autowired
    private RigaOrdineRepository rigaOrdineRepository;


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
        c.setOrdini(new ArrayList<>());
        c.setIndirizzi(new ArrayList<>());
        Cliente cliente = clienteRepository.save(c);
        for (Carrello carrello : cliente.getCarrelli()) {
            carrello.setCliente(c);
            carrelloRepository.save(carrello);
        }
        ClienteDto clienteDtoAggiornato = new ClienteDto(cliente.getId(),
                cliente.getNome(),
                cliente.getCognome(),
                cliente.getDataDiNascita(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getCodiceFiscale(),
                cliente.getPassword());
        return clienteDtoAggiornato;
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

    //Update
    public ClienteDto updateCliente(Long id, ClienteDto clienteDto, String author) {
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
                id);
        Optional<Cliente> cliente = clienteRepository.findById(id);
        ClienteDto clienteDtoAggiornato = new ClienteDto();
        clienteDtoAggiornato.setCodiceFiscale(cliente.get().getCodiceFiscale());
        clienteDtoAggiornato.setCognome(cliente.get().getCognome());
        clienteDtoAggiornato.setDataDiNascita(cliente.get().getDataDiNascita());
        clienteDtoAggiornato.setEmail(cliente.get().getEmail());
        clienteDtoAggiornato.setId(cliente.get().getId());
        clienteDtoAggiornato.setNome(cliente.get().getNome());
        clienteDtoAggiornato.setPassword(cliente.get().getPassword());
        clienteDtoAggiornato.setTelefono(cliente.get().getTelefono());
        return clienteDtoAggiornato;
    }

    public ClienteDto deleteCliente(Long id) {
        Optional<Cliente> clienteDaCancellare = clienteRepository.findById(id);

        for (Carrello carrello : clienteDaCancellare.get().getCarrelli()) {
            rigaOrdineRepository.deleteAllByCarrelloId(carrello.getId());
        }

        carrelloRepository.deleteAllByClienteId(clienteDaCancellare.get().getId());

        ordineRepository.deleteAllByClienteId(clienteDaCancellare.get().getId());

        clienteRepository.deleteClienteById(id);

        ClienteDto clienteDtoCancellato = new ClienteDto();
        if (clienteDaCancellare.isPresent()) {
            clienteDtoCancellato.setCodiceFiscale(clienteDaCancellare.get().getCodiceFiscale());
            clienteDtoCancellato.setCognome(clienteDaCancellare.get().getCognome());
            clienteDtoCancellato.setDataDiNascita(clienteDaCancellare.get().getDataDiNascita());
            clienteDtoCancellato.setEmail(clienteDaCancellare.get().getEmail());
            clienteDtoCancellato.setId(clienteDaCancellare.get().getId());
            clienteDtoCancellato.setNome(clienteDaCancellare.get().getNome());
            clienteDtoCancellato.setPassword(clienteDaCancellare.get().getPassword());
            clienteDtoCancellato.setTelefono(clienteDaCancellare.get().getTelefono());
        }
        return clienteDtoCancellato;
    }

    public RiepilogoOrdine buy(Long clienteId, Long metodoDiPagamentoId, String carrelloNome, Long indirizzoDiSpedizioneAlternativoId, String author) {
        OrdineDto nuovoOrdine = ordineService.createOrdine(clienteId, carrelloNome, author);
        MetodoDiPagamentoDto metodoDiPagamentoDtoSelezionato = metodoDiPagamentoService.readMetodoDiPagamento(metodoDiPagamentoId);
        RiepilogoOrdine riepilogoOrdine = new RiepilogoOrdine();
        if (indirizzoDiSpedizioneAlternativoId == 0) {
            riepilogoOrdine = new RiepilogoOrdine(metodoDiPagamentoDtoSelezionato, nuovoOrdine, metodoDiPagamentoDtoSelezionato.getIndirizzo());
            return riepilogoOrdine;
        } else {
            IndirizzoDto indirizzoAlternativo = indirizzoService.readIndirizzo(indirizzoDiSpedizioneAlternativoId);
            riepilogoOrdine = new RiepilogoOrdine(metodoDiPagamentoDtoSelezionato, nuovoOrdine, indirizzoAlternativo);
            return riepilogoOrdine;
        }
    }
}

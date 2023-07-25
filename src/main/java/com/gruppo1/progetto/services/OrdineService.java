package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.dto.OrdineProdottoDto;
import com.gruppo1.progetto.dto.ProdottoDto;
import com.gruppo1.progetto.models.*;
import com.gruppo1.progetto.repositories.ClienteRepository;
import com.gruppo1.progetto.repositories.OrdineRepository;
import com.gruppo1.progetto.dto.OrdineDto;
import com.gruppo1.progetto.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrdineService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private ProdottoRepository prodottoRepository;

//    @Autowired
//    private OrdineProdottoRepository ordineProdottoRepository;

//    public OrdineDto createOrdine(Long idCliente, ArrayList<Long> idprodottiOrdine, String author) {
//
//        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
//        Ordine ordine = new Ordine();
//        ordine.setId(UUID.randomUUID());
//        ordine.setDataOrdine(LocalDate.now());
//        ordine.setCliente(cliente.get());
//        ordine.setCreatedBy(author);
//        ordine.setCreatedOn(LocalDateTime.now());
//        ordine.setModifyBy(author);
//        ordine.setModifyOn(LocalDateTime.now());
//
//        ArrayList<Prodotto> prodottiOrdine = new ArrayList<>();
//        for (Long idProdotto : idprodottiOrdine) {
//            Optional<Prodotto> prodotto = prodottoRepository.findById(idProdotto);
//            prodottiOrdine.add(prodotto.get());
//        }
//
//        ArrayList<OrdineProdotto> ordineProdottoList = new ArrayList<>();
//        for (Prodotto prodotto : prodottiOrdine) {
//            if (ordineProdottoList.stream().filter(x -> x.getId().getProdottoId() == prodotto.getId()).toArray().length > 0) {
//                ordineProdottoList.stream().filter(x -> x.getId().getProdottoId() == prodotto.getId()).forEach(x -> x.addQuantita());
//            } else {
//                OrdineProdotto ordineProdotto = new OrdineProdotto();
//                OrdineProdottoKey ordineProdottoKey = new OrdineProdottoKey();
//                ordineProdottoKey.setOrdineId(ordine.getId());
//                ordineProdottoKey.setProdottoId(prodotto.getId());
//                ordineProdotto.setOrdine(ordine);
//                ordineProdotto.setProdotto(prodotto);
//                ordineProdotto.addQuantita();
//                ordineProdotto.setId(ordineProdottoKey);
//                ordineProdottoList.add(ordineProdotto);
//            }
//        }
//        Ordine ordineSalvato = ordineRepository.save(ordine);
//        ClienteDto clienteDto = new ClienteDto();
//        clienteDto.setId(cliente.get().getId());
//        clienteDto.setNome(cliente.get().getNome());
//        clienteDto.setCognome(cliente.get().getCognome());
//        clienteDto.setDataDiNascita(cliente.get().getDataDiNascita());
//        clienteDto.setTelefono(cliente.get().getTelefono());
//        clienteDto.setEmail(cliente.get().getEmail());
//        clienteDto.setCodiceFiscale(cliente.get().getCodiceFiscale());
//        clienteDto.setPassword(cliente.get().getPassword());
//
//        OrdineDto ordineDto = new OrdineDto();
//        ordineDto.setId(ordineSalvato.getId());
//        ordineDto.setClienteDto(clienteDto);
//        ordineDto.setData(ordine.getDataOrdine());
//
//        ArrayList<ProdottoDto> prodottoDtoList = new ArrayList<>();
//        prodottiOrdine.stream().map(m -> new ProdottoDto(m.getId(), m.getNome(), m.getDescrizione(), m.getPrezzo(), m.getSku())).forEach(prodottoDtoList::add);
//        ordineDto.setProdotti(prodottoDtoList);
////
//        for (OrdineProdotto ordineProdotto : ordineProdottoList) {
//            ordineProdottoRepository.save(ordineProdotto);
//        }
//
//
//        return ordineDto;
//    }
//
//
//    public OrdineDto findOrdineById(UUID id) {
//
//        Optional<Ordine> ordine = ordineRepository.findOrdineById(id);
//        OrdineDto ordineDto = new OrdineDto();
//        ordineDto.setId(ordine.get().getId());
//
//        ClienteDto clienteDto = new ClienteDto();
//        clienteDto.setCodiceFiscale(ordine.get().getCliente().getCodiceFiscale());
//        clienteDto.setCognome(ordine.get().getCliente().getCognome());
//        clienteDto.setDataDiNascita(ordine.get().getCliente().getDataDiNascita());
//        clienteDto.setEmail(ordine.get().getCliente().getEmail());
//        clienteDto.setId(ordine.get().getCliente().getId());
//        clienteDto.setNome(ordine.get().getCliente().getNome());
//        clienteDto.setPassword(ordine.get().getCliente().getPassword());
//        clienteDto.setTelefono(ordine.get().getCliente().getTelefono());
//        ordineDto.setClienteDto(clienteDto);
//        ordineDto.setData(ordine.get().getDataOrdine());
//
//        ArrayList<ProdottoDto> prodottoDtoArrayList = new ArrayList<>();
//        for (OrdineProdotto ordineProdotto : ordine.get().getOrdineProdottoList()) {
//            Prodotto prodotto = prodottoRepository.findById(ordineProdotto.getProdotto().getId()).get();
//            ProdottoDto prodottoDto = new ProdottoDto(prodotto.getId(), prodotto.getNome(), prodotto.getDescrizione(), prodotto.getPrezzo(), prodotto.getSku());
//            for (Integer i = 0; i < ordineProdotto.getQuantita(); i++) {
//                prodottoDtoArrayList.add(prodottoDto);
//            }
//        }
//        ordineDto.setProdotti(prodottoDtoArrayList);
//
//        return ordineDto;
//    }
//
//    //
//    //Delete
//    public OrdineDto deleteOrdine(UUID id) {
//
//        OrdineDto ordine = findOrdineById(id);
//        ordineProdottoRepository.deleteOrdineProdottoByOrdineId(id);
//        ordineRepository.deleteOrdineById(id);
//
//
//        return ordine;
//
//    }

}

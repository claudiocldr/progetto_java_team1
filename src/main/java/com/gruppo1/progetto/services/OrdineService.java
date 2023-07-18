package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.ProdottoDto;
import com.gruppo1.progetto.models.*;
import com.gruppo1.progetto.repositories.ClienteRepository;
import com.gruppo1.progetto.repositories.OrdineRepository;
import com.gruppo1.progetto.dto.OrdineDto;
import com.gruppo1.progetto.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrdineService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired
    private OrdineProdottoService ordineProdottoService;

    public OrdineDto createOrdine(Long idCliente, ArrayList<Long> idprodottiOrdine, String author) {

        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        Ordine ordine = new Ordine();
        ordine.setId(UUID.randomUUID());
        ordine.setCliente(cliente.get());
        ordine.setCreatedBy(author);
        ordine.setCreatedOn(LocalDateTime.now());
        ordine.setModifyBy(author);
        ordine.setModifyOn(LocalDateTime.now());

        ArrayList<Prodotto> prodottiOrdine = new ArrayList<>();
        for (Long idProdotto : idprodottiOrdine) {
            Optional<Prodotto> prodotto = prodottoRepository.findById(idProdotto);
            prodottiOrdine.add(prodotto.get());
        }

        ArrayList<OrdineProdotto> ordineProdottoList = new ArrayList<>();
        for (Prodotto prodotto : prodottiOrdine) {
            if (ordineProdottoList.stream().filter(x -> x.getId().getProdottoId() == prodotto.getId()).toArray().length > 0) {
                ordineProdottoList.stream().filter(x -> x.getId().getProdottoId() == prodotto.getId()).forEach(x -> x.addQuantita());
            } else {
                OrdineProdotto ordineProdotto = new OrdineProdotto();
                OrdineProdottoKey ordineProdottoKey = new OrdineProdottoKey();
                ordineProdottoKey.setOrdineId(ordine.getId());
                ordineProdottoKey.setProdottoId(prodotto.getId());
                ordineProdotto.setOrdine(ordine);
                ordineProdotto.setProdotto(prodotto);
                ordineProdotto.addQuantita();
                ordineProdotto.setId(ordineProdottoKey);
                ordineProdottoList.add(ordineProdotto);
            }
        }
        ordineRepository.save(ordine);
        OrdineDto ordineDto = new OrdineDto();
//        ordineDto.setCliente(cliente.get());
//        ordineDto.setData(LocalDate.now());
//        ordineDto.setId(ordine.getId());
//        ordineDto.setProdotti(prodottiOrdine);
        for (OrdineProdotto ordineProdotto : ordineProdottoList) {
            ordineProdottoService.ordineProdottoRepository.save(ordineProdotto);
        }


        return ordineDto;
    }


    public Optional<Ordine> findOrdineById(UUID id) {
        return ordineRepository.findOrdineById(id);
    }
    //Readpublic Optional<OrdineDto> findOrdineAndReturnDto(Long id)  {
    ////       Optional<Ordine> ordine = ordineRepository.findById(id);
    ////       Optional<OrdineDto> ordineDto = Optional.of(new OrdineDto());
    ////       if (ordine.isPresent()){
    ////               ordineDto.get().setId(ordine.get().getId());
    ////               ordineDto.get().setCliente(ordine.get().getCliente());
    ////               ordineDto.get().setData(ordine.get().getDataOrdine());
    ////               List<Prodotto> prodottoDtoList = new ArrayList<>();
    ////               for(Prodotto prodotto : ordine.get().getProdotti())
    ////               {
    ////                   ProdottoDto prodottoDto = new ProdottoDto();
    ////                   prodottoDto.setDescrizione(prodotto.getDescrizione());
    ////                   prodottoDto.setId(prodotto.getId());
    ////                   prodottoDto.setNome(prodotto.getNome());
    ////                   prodottoDto.setPrezzo(prodotto.getPrezzo());
    ////                   prodottoDto.setSku(prodotto.getSku());
    ////               }
    ////
    ////               ordineDto.get().setProdotti(prodottoDtoList);
    ////               }
    ////       return ordineDto;
    ////    }
//

    //Update
//    public void updateOrdine(OrdineDto ordineDto, Long id, String author){
//        try{
//            if(ordineDto == null){
//                throw new Exception("Impossibile aggiornare l'ordine, l'oggetto è null");
//            } else {
//                Ordine o = new Ordine();
//                o.setCliente(ordineDto.getCliente());
//                o.setDataOrdine(ordineDto.getData());
//
//                o.setProdotti();
//                o.setModifyOn(LocalDateTime.now());
//                o.setModifyBy(author);
//                ordineRepository.updateOrdineById(o.getDataOrdine(), o.getCliente().getId(), o.getModifyOn(), o.getModifyBy(), id);
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    //Delete
    public void deleteCarrello(Long id) {
        try {
            ordineRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

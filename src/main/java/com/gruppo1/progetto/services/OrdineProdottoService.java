package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.OrdineProdottoDto;
import com.gruppo1.progetto.models.Ordine;
import com.gruppo1.progetto.models.OrdineProdotto;
import com.gruppo1.progetto.models.OrdineProdottoKey;
import com.gruppo1.progetto.models.Prodotto;
import com.gruppo1.progetto.repositories.OrdineProdottoRepository;
import com.gruppo1.progetto.repositories.OrdineRepository;
import com.gruppo1.progetto.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdineProdottoService {
    @Autowired
    public OrdineProdottoRepository ordineProdottoRepository;
    @Autowired
    public OrdineRepository ordineRepository;
    @Autowired
    public ProdottoRepository prodottoRepository;

    public Optional<OrdineProdottoDto> createOrdineProdotto (Long ordine_id, Long prodotto_id, Long quantita) {

    OrdineProdotto ordineProdotto = new OrdineProdotto();
    Optional<Ordine> ordine = ordineRepository.findById(ordine_id);
    Optional<Prodotto> prodotto = prodottoRepository.findById(prodotto_id);
    Optional<OrdineProdottoKey>  ordineProdottoKey = Optional.of(new OrdineProdottoKey());
    ordineProdottoKey.get().setOrdineId(ordine_id);
    ordineProdottoKey.get().setProdottoId(prodotto_id);
    ordineProdotto.setId(ordineProdottoKey.get());
    ordineProdotto.setProdotto(prodotto.get());
    ordineProdotto.setOrdine(ordine.get());
    ordineProdotto.setQuantita(quantita);
    ordineProdottoRepository.save(ordineProdotto);

    Optional<OrdineProdottoDto> ordineProdottoDto = Optional.of(new OrdineProdottoDto());
    ordineProdottoDto.get().setOrdine(ordine.get());
    ordineProdottoDto.get().setProdotto(prodotto.get());
    ordineProdottoDto.get().setQuantita(quantita);

    return ordineProdottoDto;
    }

    public List<Optional<OrdineProdottoDto>> findOrdineProdottoByOrderId (Long id){
        List<Optional<OrdineProdotto>> listaOrdineProdotto = ordineProdottoRepository.findOrdineProdottoByOrdineId(id);
        List<Optional<OrdineProdottoDto>> listaOrdineProdottoDto = new ArrayList<>();
        for (Optional<OrdineProdotto> ordineProdotto : listaOrdineProdotto){
            Optional<OrdineProdottoDto> ordineProdottoDto = Optional.of(new OrdineProdottoDto());
            ordineProdottoDto.get().setOrdine(ordineProdotto.get().getOrdine());
            ordineProdottoDto.get().setProdotto(ordineProdotto.get().getProdotto());
            ordineProdottoDto.get().setQuantita(ordineProdotto.get().getQuantita());
            listaOrdineProdottoDto.add(ordineProdottoDto);
        }

        return listaOrdineProdottoDto;
    }

}

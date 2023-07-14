package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.dto.ProdottoDto;
import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.models.Prodotto;
import com.gruppo1.progetto.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Executable;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProdottoService {

    @Autowired
    private ProdottoRepository prodottoRepository;

    //Create
    public Optional<ProdottoDto> createProdotto (Optional<ProdottoDto> prodottoDto, String author){
        if(prodottoDto.isPresent()) {
            Prodotto prodotto = new Prodotto();
            prodotto.setNome(prodottoDto.get().getNome());
            prodotto.setDescrizione(prodottoDto.get().getDescrizione());
            prodotto.setPrezzo(prodottoDto.get().getPrezzo());
            prodotto.setSku(prodottoDto.get().getSku());
            prodotto.setQuantita(prodottoDto.get().getQuantita());
            prodotto.setModifyBy(author);
            prodotto.setModifyOn(LocalDateTime.now());
            prodotto.setCreatedBy(author);
            prodotto.setCreatedOn(LocalDateTime.now());
            prodottoRepository.save(prodotto);
        }
            return prodottoDto;
    }

    //Read
    public Optional<ProdottoDto> readProdotto (Long id){
        Optional<Prodotto> prodotto = prodottoRepository.findById(id);
        Optional<ProdottoDto> prodottoDto = Optional.of(new ProdottoDto());
           if(prodotto.isPresent()) {
               prodottoDto.get().setId(prodotto.get().getId());
               prodottoDto.get().setNome(prodotto.get().getNome());
               prodottoDto.get().setDescrizione(prodotto.get().getDescrizione());
               prodottoDto.get().setPrezzo(prodotto.get().getPrezzo());
               prodottoDto.get().setSku(prodotto.get().getSku());
               prodottoDto.get().setQuantita(prodotto.get().getQuantita());
           }
            return prodottoDto;

    }

    //Update
    public Optional<ProdottoDto> updateProdotto(Optional<ProdottoDto> prodottoDto, Long id, String author){
        LocalDateTime modifyOn = LocalDateTime.now();
        prodottoRepository.updateProdottoById(
                prodottoDto.get().getNome(),
                prodottoDto.get().getDescrizione(),
                prodottoDto.get().getPrezzo(),
                prodottoDto.get().getSku(),
                prodottoDto.get().getQuantita(),
                modifyOn,
                author,
                id
        );
        Optional<Prodotto> prodotto = prodottoRepository.findById(id);
        Optional<ProdottoDto> prodottoDtoAggiornato = Optional.of(new ProdottoDto());
        prodottoDtoAggiornato.get().setNome(prodotto.get().getNome());
        prodottoDtoAggiornato.get().setId(prodotto.get().getId());
        prodottoDtoAggiornato.get().setDescrizione(prodotto.get().getDescrizione());
        prodottoDtoAggiornato.get().setPrezzo(prodotto.get().getPrezzo());
        prodottoDtoAggiornato.get().setQuantita(prodotto.get().getQuantita());
        prodottoDtoAggiornato.get().setSku(prodotto.get().getSku());
        return prodottoDtoAggiornato;
    }

    //Delete
    public Optional<ProdottoDto> deleteProdotto(Long id){
        Optional<Prodotto> prodottoDaCancellare = prodottoRepository.findById(id);
            prodottoRepository.deleteById(id);
        Optional<ProdottoDto> prodottoDtoCancellato = Optional.of(new ProdottoDto());
        if(prodottoDaCancellare.isPresent()){
            prodottoDtoCancellato.get().setId(prodottoDaCancellare.get().getId());
            prodottoDtoCancellato.get().setDescrizione(prodottoDaCancellare.get().getDescrizione());
            prodottoDtoCancellato.get().setNome(prodottoDaCancellare.get().getNome());
            prodottoDtoCancellato.get().setPrezzo(prodottoDaCancellare.get().getPrezzo());
            prodottoDtoCancellato.get().setQuantita(prodottoDaCancellare.get().getQuantita());
            prodottoDtoCancellato.get().setSku(prodottoDaCancellare.get().getSku());
        }
            return prodottoDtoCancellato;
    }

}

package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.ProdottoDto;
import com.gruppo1.progetto.models.Prodotto;
import com.gruppo1.progetto.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProdottoService {

    @Autowired
    public ProdottoRepository prodottoRepository;

    //Create
    public ProdottoDto createProdotto(ProdottoDto prodottoDto, String author) throws Exception {
            Prodotto prodotto = new Prodotto();
            prodotto.setNome(prodottoDto.getNome());
            prodotto.setDescrizione(prodottoDto.getDescrizione());
            prodotto.setPrezzo(prodottoDto.getPrezzo());
            prodotto.setSku(prodottoDto.getSku());
            prodotto.setModifyBy(author);
            prodotto.setModifyOn(LocalDateTime.now());
            prodotto.setCreatedBy(author);
            prodotto.setCreatedOn(LocalDateTime.now());
            Prodotto prodottoSaved = prodottoRepository.save(prodotto);
            return new ProdottoDto(prodottoSaved.getId(), prodottoSaved.getNome(), prodottoSaved.getDescrizione(), prodottoSaved.getPrezzo(), prodottoSaved.getSku());
    }

    //Read
    public Optional<Prodotto> findProdottoById (Long id) {
        return prodottoRepository.findById(id);
    }
    public Optional<ProdottoDto> findProdottoAndReturnDto(Long id) {
        Optional<Prodotto> prodotto = prodottoRepository.findById(id);
        Optional<ProdottoDto> prodottoDto = Optional.of(new ProdottoDto());
        if (prodotto.isPresent()) {
            prodottoDto.get().setId(prodotto.get().getId());
            prodottoDto.get().setNome(prodotto.get().getNome());
            prodottoDto.get().setDescrizione(prodotto.get().getDescrizione());
            prodottoDto.get().setPrezzo(prodotto.get().getPrezzo());
            prodottoDto.get().setSku(prodotto.get().getSku());
        }
        return prodottoDto;

    }

    //Update
    public ProdottoDto updateProdotto(ProdottoDto prodottoDto, Long id, String author) {
        LocalDateTime modifyOn = LocalDateTime.now();
        prodottoRepository.updateProdottoById(
                prodottoDto.getNome(),
                prodottoDto.getDescrizione(),
                prodottoDto.getPrezzo(),
                prodottoDto.getSku(),
                modifyOn,
                author,
                id);
        Optional<Prodotto> prodotto = prodottoRepository.findById(id);
        ProdottoDto prodottoDtoAggiornato = new ProdottoDto();
        prodottoDtoAggiornato.setNome(prodotto.get().getNome());
        prodottoDtoAggiornato.setId(prodotto.get().getId());
        prodottoDtoAggiornato.setDescrizione(prodotto.get().getDescrizione());
        prodottoDtoAggiornato.setPrezzo(prodotto.get().getPrezzo());
        prodottoDtoAggiornato.setSku(prodotto.get().getSku());
        return prodottoDtoAggiornato;
    }

    //Delete
    public Optional<ProdottoDto> deleteProdotto(Long id) {
        Optional<Prodotto> prodottoDaCancellare = prodottoRepository.findById(id);
        Optional<ProdottoDto> prodottoDtoCancellato = Optional.of(new ProdottoDto());
        if (prodottoDaCancellare.isPresent()) {
            prodottoDtoCancellato.get().setId(prodottoDaCancellare.get().getId());
            prodottoDtoCancellato.get().setDescrizione(prodottoDaCancellare.get().getDescrizione());
            prodottoDtoCancellato.get().setNome(prodottoDaCancellare.get().getNome());
            prodottoDtoCancellato.get().setPrezzo(prodottoDaCancellare.get().getPrezzo());
            prodottoDtoCancellato.get().setSku(prodottoDaCancellare.get().getSku());
        }
        prodottoRepository.deleteById(id);


        return prodottoDtoCancellato;
    }

}

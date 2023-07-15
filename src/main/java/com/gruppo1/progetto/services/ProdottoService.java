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
    private ProdottoRepository prodottoRepository;

    //Create
    public Optional<ProdottoDto> createProdotto(Optional<ProdottoDto> prodottoDto, String author) {
        if (prodottoDto.isPresent()) {
            Prodotto prodotto = new Prodotto();
            prodotto.setNome(prodottoDto.get().getNome());
            prodotto.setDescrizione(prodottoDto.get().getDescrizione());
            prodotto.setPrezzo(prodottoDto.get().getPrezzo());
            prodotto.setSku(prodottoDto.get().getSku());
            prodotto.setModifyBy(author);
            prodotto.setModifyOn(LocalDateTime.now());
            prodotto.setCreatedBy(author);
            prodotto.setCreatedOn(LocalDateTime.now());
            prodottoRepository.save(prodotto);
        }
        return prodottoDto;
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
    public Optional<ProdottoDto> updateProdotto(Optional<ProdottoDto> prodottoDto, Long id, String author) {
        LocalDateTime modifyOn = LocalDateTime.now();
        if (prodottoDto.isPresent()) {
            prodottoRepository.updateProdottoById(
                    prodottoDto.get().getNome(),
                    prodottoDto.get().getDescrizione(),
                    prodottoDto.get().getPrezzo(),
                    prodottoDto.get().getSku(),
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
            prodottoDtoAggiornato.get().setSku(prodotto.get().getSku());
            return prodottoDtoAggiornato;
        } else {
            return Optional.of(new ProdottoDto());
        }
    }

    //Delete
    public Optional<ProdottoDto> deleteProdotto(Long id) {
        Optional<Prodotto> prodottoDaCancellare = prodottoRepository.findById(id);
        prodottoRepository.deleteById(id);
        Optional<ProdottoDto> prodottoDtoCancellato = Optional.of(new ProdottoDto());
        if (prodottoDaCancellare.isPresent()) {
            prodottoDtoCancellato.get().setId(prodottoDaCancellare.get().getId());
            prodottoDtoCancellato.get().setDescrizione(prodottoDaCancellare.get().getDescrizione());
            prodottoDtoCancellato.get().setNome(prodottoDaCancellare.get().getNome());
            prodottoDtoCancellato.get().setPrezzo(prodottoDaCancellare.get().getPrezzo());
            prodottoDtoCancellato.get().setSku(prodottoDaCancellare.get().getSku());
        }
        return prodottoDtoCancellato;
    }

}

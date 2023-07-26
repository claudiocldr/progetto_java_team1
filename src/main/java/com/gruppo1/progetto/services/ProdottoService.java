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
    private final ProdottoRepository prodottoRepository;

    @Autowired
    public ProdottoService(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }

    //Create
    public ProdottoDto createProdotto(ProdottoDto prodottoDto, String author) throws Exception {
            Prodotto prodotto = new Prodotto();
            prodotto.setNome(prodottoDto.getNome());
            prodotto.setDescrizione(prodottoDto.getDescrizione());
            prodotto.setPrezzo(prodottoDto.getPrezzo());
            prodotto.setNumeroArticolo(prodottoDto.getNumeroArticolo());
            prodotto.setModifyBy(author);
            prodotto.setModifyOn(LocalDateTime.now());
            prodotto.setCreatedBy(author);
            prodotto.setCreatedOn(LocalDateTime.now());
            try {
            Prodotto prodottoSaved = prodottoRepository.save(prodotto);
            return new ProdottoDto(prodottoSaved.getNome(), prodottoSaved.getDescrizione(), prodottoSaved.getPrezzo(), prodottoDto.getNumeroArticolo());}
            catch (Exception e) {
                return new ProdottoDto();
            }

    }

    //Read
    public Optional<Prodotto> findProdottoByNumeroArticolo(Long numeroArticolo) {
        return prodottoRepository.findByNumeroArticolo(numeroArticolo);
    }
    public Optional<ProdottoDto> findProdottoAndReturnDto(Long numeroArticolo) {
        Optional<Prodotto> prodotto = prodottoRepository.findByNumeroArticolo(numeroArticolo);
        ProdottoDto prodottoDto = new ProdottoDto();
        try {
            prodottoDto.setNome(prodotto.get().getNome());
            prodottoDto.setDescrizione(prodotto.get().getDescrizione());
            prodottoDto.setPrezzo(prodotto.get().getPrezzo());
            prodottoDto.setNumeroArticolo(prodotto.get().getNumeroArticolo());
            return Optional.of(prodottoDto);}

        catch (Exception e){
            return Optional.of(prodottoDto);
        }

    }

    //Update
    public ProdottoDto updateProdotto(ProdottoDto prodottoDto, String author) {
        LocalDateTime modifyOn = LocalDateTime.now();
        prodottoRepository.updateProdottoByNumeroArticolo(
                prodottoDto.getNome(),
                prodottoDto.getDescrizione(),
                prodottoDto.getPrezzo(),
                modifyOn,
                author,
                prodottoDto.getNumeroArticolo());
        Optional<Prodotto> prodotto = prodottoRepository.findByNumeroArticolo(prodottoDto.getNumeroArticolo());
        ProdottoDto prodottoDtoAggiornato = new ProdottoDto();
        if(prodotto.isPresent()){
        prodottoDtoAggiornato.setNome(prodotto.get().getNome());
        prodottoDtoAggiornato.setDescrizione(prodotto.get().getDescrizione());
        prodottoDtoAggiornato.setPrezzo(prodotto.get().getPrezzo());
        prodottoDtoAggiornato.setNumeroArticolo(prodotto.get().getNumeroArticolo());
        return prodottoDtoAggiornato;} else {
            return prodottoDtoAggiornato;
        }
    }

    //Delete
    public ProdottoDto deleteProdotto(Long numeroArticolo) {
        Optional<Prodotto> prodottoDaCancellare = prodottoRepository.findByNumeroArticolo(numeroArticolo);
        ProdottoDto prodottoDtoCancellato = new ProdottoDto();
        if (prodottoDaCancellare.isPresent()) {
            prodottoDtoCancellato.setDescrizione(prodottoDaCancellare.get().getDescrizione());
            prodottoDtoCancellato.setNome(prodottoDaCancellare.get().getNome());
            prodottoDtoCancellato.setPrezzo(prodottoDaCancellare.get().getPrezzo());
            prodottoDtoCancellato.setNumeroArticolo(prodottoDaCancellare.get().getNumeroArticolo());
            prodottoRepository.deleteByNumeroArticolo(prodottoDaCancellare.get().getNumeroArticolo());
            return prodottoDtoCancellato;
        } else {
            return prodottoDtoCancellato;
        }
    }

}

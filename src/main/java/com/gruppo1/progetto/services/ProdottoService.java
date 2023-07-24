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
            prodotto.setSku(prodottoDto.getSku());
            prodotto.setModifyBy(author);
            prodotto.setModifyOn(LocalDateTime.now());
            prodotto.setCreatedBy(author);
            prodotto.setCreatedOn(LocalDateTime.now());
            try {
            Prodotto prodottoSaved = prodottoRepository.save(prodotto);
            return new ProdottoDto(prodottoSaved.getId(), prodottoSaved.getNome(), prodottoSaved.getDescrizione(), prodottoSaved.getPrezzo(), prodottoSaved.getSku());}
            catch (Exception e) {
                return new ProdottoDto();
            }

    }

    //Read
    public Optional<Prodotto> findProdottoById (Long id) {
        return prodottoRepository.findById(id);
    }
    public Optional<ProdottoDto> findProdottoAndReturnDto(Long id) {
        Optional<Prodotto> prodotto = prodottoRepository.findById(id);
        ProdottoDto prodottoDto = new ProdottoDto();
        try {
            prodottoDto.setId(prodotto.get().getId());
            prodottoDto.setNome(prodotto.get().getNome());
            prodottoDto.setDescrizione(prodotto.get().getDescrizione());
            prodottoDto.setPrezzo(prodotto.get().getPrezzo());
            prodottoDto.setSku(prodotto.get().getSku());
            return Optional.of(prodottoDto);}

        catch (Exception e){
            return Optional.of(prodottoDto);
        }

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
        if(prodotto.isPresent()){
        prodottoDtoAggiornato.setNome(prodotto.get().getNome());
        prodottoDtoAggiornato.setId(prodotto.get().getId());
        prodottoDtoAggiornato.setDescrizione(prodotto.get().getDescrizione());
        prodottoDtoAggiornato.setPrezzo(prodotto.get().getPrezzo());
        prodottoDtoAggiornato.setSku(prodotto.get().getSku());
        return prodottoDtoAggiornato;} else {
            return prodottoDtoAggiornato;
        }
    }

    //Delete
    public ProdottoDto deleteProdotto(Long id) {
        Optional<Prodotto> prodottoDaCancellare = prodottoRepository.findById(id);
        ProdottoDto prodottoDtoCancellato = new ProdottoDto();
        if (prodottoDaCancellare.isPresent()) {
            prodottoDtoCancellato.setId(prodottoDaCancellare.get().getId());
            prodottoDtoCancellato.setDescrizione(prodottoDaCancellare.get().getDescrizione());
            prodottoDtoCancellato.setNome(prodottoDaCancellare.get().getNome());
            prodottoDtoCancellato.setPrezzo(prodottoDaCancellare.get().getPrezzo());
            prodottoDtoCancellato.setSku(prodottoDaCancellare.get().getSku());
            prodottoRepository.deleteById(id);
            return prodottoDtoCancellato;
        } else {
            return prodottoDtoCancellato;
        }
    }

}

package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.ProdottoDto;
import com.gruppo1.progetto.dto.ProdottoDtoSenzaIdentificatoreArticolo;
import com.gruppo1.progetto.models.Prodotto;
import com.gruppo1.progetto.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdottoService {
    private final ProdottoRepository prodottoRepository;

    @Autowired
    public ProdottoService(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }

    //Create
    public ProdottoDto createProdotto(ProdottoDtoSenzaIdentificatoreArticolo prodottoDto, String author) throws Exception {
            Prodotto prodotto = new Prodotto();
            prodotto.setNome(prodottoDto.getNome());
            prodotto.setDescrizione(prodottoDto.getDescrizione());
            prodotto.setPrezzo(prodottoDto.getPrezzo());
            prodotto.setIdentificatoreArticolo(UUID.randomUUID());
            prodotto.setModifyBy(author);
            prodotto.setModifyOn(LocalDateTime.now());
            prodotto.setCreatedBy(author);
            prodotto.setCreatedOn(LocalDateTime.now());
            try {
            Prodotto prodottoSaved = prodottoRepository.save(prodotto);
            return new ProdottoDto (prodottoSaved.getNome(), prodottoSaved.getDescrizione(), prodottoSaved.getPrezzo(), prodottoSaved.getIdentificatoreArticolo());}
            catch (Exception e) {
                return new ProdottoDto();
            }

    }

    //Read
    public Optional<Prodotto> findProdottoByIdentificatoreArticolo(UUID identificatoreArticolo) {
        return prodottoRepository.findByIdentificatoreArticolo(identificatoreArticolo);
    }
    public Optional<ProdottoDto> findProdottoAndReturnDto(UUID identificatoreArticolo) {
        Optional<Prodotto> prodotto = prodottoRepository.findByIdentificatoreArticolo(identificatoreArticolo);
        ProdottoDto prodottoDto = new ProdottoDto();
        try {
            prodottoDto.setNome(prodotto.get().getNome());
            prodottoDto.setDescrizione(prodotto.get().getDescrizione());
            prodottoDto.setPrezzo(prodotto.get().getPrezzo());
            prodottoDto.setIdentificatoreArticolo(prodotto.get().getIdentificatoreArticolo());
            return Optional.of(prodottoDto);}

        catch (Exception e){
            return Optional.of(prodottoDto);
        }

    }

    //Update
    public ProdottoDto updateProdotto(ProdottoDto prodottoDto, String author) {
        LocalDateTime modifyOn = LocalDateTime.now();
        prodottoRepository.updateProdottoByIdentificatoreArticolo(
                prodottoDto.getNome(),
                prodottoDto.getDescrizione(),
                prodottoDto.getPrezzo(),
                modifyOn,
                author,
                prodottoDto.getIdentificatoreArticolo());
        Optional<Prodotto> prodotto = prodottoRepository.findByIdentificatoreArticolo(prodottoDto.getIdentificatoreArticolo());
        ProdottoDto prodottoDtoAggiornato = new ProdottoDto();
        if(prodotto.isPresent()){
        prodottoDtoAggiornato.setNome(prodotto.get().getNome());
        prodottoDtoAggiornato.setDescrizione(prodotto.get().getDescrizione());
        prodottoDtoAggiornato.setPrezzo(prodotto.get().getPrezzo());
        prodottoDtoAggiornato.setIdentificatoreArticolo(prodotto.get().getIdentificatoreArticolo());
        return prodottoDtoAggiornato;} else {
            return prodottoDtoAggiornato;
        }
    }

    //Delete
    public ProdottoDto deleteProdotto(UUID identificatoreArticolo) {
        Optional<Prodotto> prodottoDaCancellare = prodottoRepository.findByIdentificatoreArticolo(identificatoreArticolo);
        ProdottoDto prodottoDtoCancellato = new ProdottoDto();
        if (prodottoDaCancellare.isPresent()) {
            prodottoDtoCancellato.setDescrizione(prodottoDaCancellare.get().getDescrizione());
            prodottoDtoCancellato.setNome(prodottoDaCancellare.get().getNome());
            prodottoDtoCancellato.setPrezzo(prodottoDaCancellare.get().getPrezzo());
            prodottoDtoCancellato.setIdentificatoreArticolo(prodottoDaCancellare.get().getIdentificatoreArticolo());
            prodottoRepository.deleteByIdentificatoreArticolo(prodottoDaCancellare.get().getIdentificatoreArticolo());
            return prodottoDtoCancellato;
        } else {
            return prodottoDtoCancellato;
        }
    }

}

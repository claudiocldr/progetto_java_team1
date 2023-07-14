package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.ProdottoDto;
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
    public void createProdotto (ProdottoDto prodottoDto, String author){
        try{
            Prodotto prodotto = new Prodotto();
            prodotto.setNome(prodottoDto.getNome());
            prodotto.setDescrizione(prodottoDto.getDescrizione());
            prodotto.setPrezzo(prodottoDto.getPrezzo());
            prodotto.setSku(prodottoDto.getSku());
            prodotto.setQuantita(prodottoDto.getQuantita());
            prodottoRepository.save(prodotto);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //Read
    public ProdottoDto readProdotto (Long id){
        try{ Optional<Prodotto> prodotto = prodottoRepository.findById(id);
            ProdottoDto prodottoDto = new ProdottoDto();
            prodottoDto.setId(prodotto.get().getId());
            prodottoDto.setNome(prodotto.get().getNome());
            prodottoDto.setDescrizione(prodotto.get().getDescrizione());
            prodottoDto.setPrezzo(prodotto.get().getPrezzo());
            prodottoDto.setSku(prodotto.get().getSku());
            prodottoDto.setQuantita(prodotto.get().getQuantita());
            return prodottoDto;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Update
    public void updateProdotto(ProdottoDto prodottoDto, Long id, String author){
        try{
            Prodotto p = new Prodotto();
            p.setNome(prodottoDto.getNome());
            p.setDescrizione(prodottoDto.getDescrizione());
            p.setPrezzo(prodottoDto.getPrezzo());
            p.setSku(prodottoDto.getSku());
            p.setQuantita(prodottoDto.getQuantita());
            p.setModifyOn(LocalDateTime.now());
            p.setModifyBy(author);
            prodottoRepository.updateProdottoById(p.getNome(),p.getDescrizione(),p.getPrezzo(),p.getSku(),p.getQuantita(),p.getModifyOn(),p.getModifyBy(),id);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //delete
    public void deleteProdotto(Long id){
        try {
            prodottoRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

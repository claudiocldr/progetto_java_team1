package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.ProdottoDto;
import com.gruppo1.progetto.dto.RigaOrdineDto;
import com.gruppo1.progetto.models.RigaOrdine;
import com.gruppo1.progetto.repositories.RigaOrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RigaOrdineService {
    @Autowired
    public RigaOrdineRepository rigaOrdineRepo;

    public List<RigaOrdineDto> getAllByCarrelloId(Long carrelloId) {
        List<RigaOrdine> righe = rigaOrdineRepo.findByCarrelloId(carrelloId);
        List<RigaOrdineDto> righeDto = righe.stream().map(m -> {
            RigaOrdineDto r = new RigaOrdineDto();
            ProdottoDto prodottoDto = new ProdottoDto();
            prodottoDto.setId(m.getProdotto().getId());
            prodottoDto.setPrezzo(m.getProdotto().getPrezzo());
            prodottoDto.setNome(m.getProdotto().getNome());
            prodottoDto.setDescrizione(m.getProdotto().getDescrizione());
            prodottoDto.setSku(m.getProdotto().getSku());

            r.setProdotto(prodottoDto);
            r.setQuantita(m.getQuantita());
            return r;
        }).toList();
        return righeDto;
    }
}

package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.ProdottoDto;
import com.gruppo1.progetto.dto.RigaOrdineDto;
import com.gruppo1.progetto.models.Carrello;
import com.gruppo1.progetto.models.Prodotto;
import com.gruppo1.progetto.models.RigaOrdine;
import com.gruppo1.progetto.repositories.CarrelloRepository;
import com.gruppo1.progetto.repositories.ProdottoRepository;
import com.gruppo1.progetto.repositories.RigaOrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RigaOrdineService {
    @Autowired
    public RigaOrdineRepository rigaOrdineRepo;
    @Autowired
    public ProdottoRepository prodottoRepo;
    @Autowired
    public CarrelloRepository carrelloRepo;

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

    public Optional<RigaOrdineDto> inserisciProdottoNelCarrello(String nomeCarrello, Long clienteId, Long prodottoId, Integer quantita) {
        Optional<Prodotto> prodottoOptional = prodottoRepo.findById(prodottoId);
        RigaOrdine rigaOrdine = new RigaOrdine();
        rigaOrdine.setProdotto(prodottoOptional.get());
        rigaOrdine.setQuantita(quantita);
        Carrello carrello = carrelloRepo.findByNomeAndClienteId(nomeCarrello, clienteId).get();
        rigaOrdine.setCarrello(carrello);
        RigaOrdine rigaOrdineSalvata = rigaOrdineRepo.save(rigaOrdine);
        ProdottoDto prodottoDto = new ProdottoDto(rigaOrdineSalvata.getProdotto().getId(),
                rigaOrdineSalvata.getProdotto().getNome(),
                rigaOrdineSalvata.getProdotto().getDescrizione(),
                rigaOrdineSalvata.getProdotto().getPrezzo(),
                rigaOrdineSalvata.getProdotto().getSku());
        RigaOrdineDto rigaOrdineDto = new RigaOrdineDto(prodottoDto, quantita);
        return  Optional.of(rigaOrdineDto);
    }
}

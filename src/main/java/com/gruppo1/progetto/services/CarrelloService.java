package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.OrdineCarrelloDto;
import com.gruppo1.progetto.dto.ProdottoDto;
import com.gruppo1.progetto.models.Carrello;
import com.gruppo1.progetto.models.Ordine;
import com.gruppo1.progetto.models.Prodotto;
import com.gruppo1.progetto.repositories.CarrelloRepository;
import com.gruppo1.progetto.dto.CarrelloDto;
import com.gruppo1.progetto.repositories.OrdineRepository;
import com.gruppo1.progetto.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//
@Service
public class CarrelloService {
    @Autowired
    private CarrelloRepository carrelloRepository;

    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private ProdottoRepository prodottoRepository;

//    //Create
    public void createCarrello (CarrelloDto carrelloDto, String author){
        Carrello cE = new Carrello();
        Optional<Ordine> ordine = ordineRepository.findById(carrelloDto.getOrdineDto().getId());
        Optional<Prodotto> prodotto = prodottoRepository.findById(carrelloDto.getProdottoDto().getId());
        cE.setOrdine(ordine.get());
        cE.setProdotto(prodotto.get());

        carrelloRepository.save(cE);
    }

    //Read
    public  Optional<CarrelloDto> readCarrelloByOrder (Long id) {

        List<Optional<Carrello>> listaCarrello = carrelloRepository.findCarrelloByOrdineId(id);
        Optional<Ordine> ordineDontShow = ordineRepository.findById(id);
        Optional<CarrelloDto> carrelloDto = Optional.of(new CarrelloDto());
        if (ordineDontShow.isPresent()) {
            OrdineCarrelloDto ordine = new OrdineCarrelloDto();
            ordine.setData(ordineDontShow.get().getDataOrdine());
            ordine.setId(ordineDontShow.get().getId());

            carrelloDto.get().setListaProdotti(new ArrayList<>());
            carrelloDto.get().setDettagliOrdine(ordine);
            Double totaleProdotti = 0.00;
            for (Optional<Carrello> carrello : listaCarrello) {
                ProdottoDto prodottoDto = new ProdottoDto();
                prodottoDto.setDescrizione(carrello.get().getProdotto().getDescrizione());
                prodottoDto.setId(carrello.get().getProdotto().getId());
                prodottoDto.setNome(carrello.get().getProdotto().getNome());
                prodottoDto.setPrezzo(carrello.get().getProdotto().getPrezzo());
                prodottoDto.setSku(carrello.get().getProdotto().getSku());
                carrelloDto.get().getListaProdotti().add(prodottoDto);
                totaleProdotti = totaleProdotti + carrello.get().getProdotto().getPrezzo();
            }
            carrelloDto.get().setTotaleProdotti(totaleProdotti);
        }
    return carrelloDto;

    }

//
//    //Update
//    public void updateCarrello(CarrelloDto carrelloDto, Long id, String author){
//        try{
//            if(carrelloDto == null){
//                throw new Exception("Impossibile aggiornare il carrello, l'oggetto è null");
//            } else {
//                Carrello c = new Carrello();
//                c.setListaProdotti(carrelloDto.getProdotti());
//                c.setQuantita(carrelloDto.getQuantita());
//                c.setModifyBy(author);
//                c.setModifyOn(LocalDateTime.now());
//                carrelloRepository.updateCarrelloById(c.getQuantita(),c.getListaProdotti(),c.getModifyBy(),c.getModifyOn(), id);
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
    //Delete
    public void deleteCarrello(Long id){
        try {
            carrelloRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}



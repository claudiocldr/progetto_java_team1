package com.gruppo1.progetto.services;

import com.gruppo1.progetto.repositories.CarrelloRepository;
import com.gruppo1.progetto.dto.CarrelloDto;
import com.gruppo1.progetto.models.Carrello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CarrelloService {
@Autowired
    private CarrelloRepository carrelloRepository;

    //Create
    public void createCarrello (CarrelloDto carrelloDto, String author){
        Carrello cE = new Carrello();
        cE.setListaProdotti(carrelloDto.getProdotti());
        cE.setOrdine(carrelloDto.getOrdine());
        cE.setCreatedBy(author);
        cE.setCreatedOn(LocalDateTime.now());
        cE.setQuantita(carrelloDto.getQuantita());

        carrelloRepository.save(cE);
    }

    //Read
    public CarrelloDto readCarrello(Long id){
        Optional<Carrello> carrello = carrelloRepository.findById(id.intValue());

        if(carrello.isPresent()){
        CarrelloDto carrelloDto = new CarrelloDto();
        Carrello c = carrello.get();
        carrelloDto.setProdotti(c.getListaProdotti());
        carrelloDto.setOrdine(c.getOrdine());
        carrelloDto.setQuantita(c.getQuantita());
        return carrelloDto;
        }
        return null;
    }

    //Update
    public void updateCarrello(CarrelloDto carrelloDto, String author){
        try{
            if(carrelloDto == null){
                throw new Exception("Impossibile aggiornare il carrello, l'oggetto è null");
            } else {
                Carrello c = new Carrello();
                c.setListaProdotti(carrelloDto.getProdotti());
                c.setOrdine(carrelloDto.getOrdine());
                c.setQuantita(carrelloDto.getQuantita());
                c.setModifyBy(author);
                c.setModifyOn(LocalDateTime.now());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //Delete
    public void deleteCarrello(Long id){
        try {
            carrelloRepository.deleteById(id.intValue());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

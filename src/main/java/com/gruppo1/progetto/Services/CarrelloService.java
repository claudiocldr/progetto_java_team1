package com.gruppo1.progetto.Services;

import com.gruppo1.progetto.Repositories.CarrelloRepo;
import com.gruppo1.progetto.dto.CarrelloDto;
import com.gruppo1.progetto.models.Carrello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CarrelloService {
@Autowired
    private CarrelloRepo<Carrello> carrelloRepo;

    //Create
    public void createCarrello (CarrelloDto carrelloDto, String author){
        Carrello cE = new Carrello();
        cE.setProdotti(carrelloDto.getProdotti());
        cE.setOrdine(carrelloDto.getOrdine());
        cE.setCreatedBy(author);
        cE.setCreatedOn(LocalDateTime.now());
        cE.setQuantita(carrelloDto.getQuantita());

        carrelloRepo.save(cE);
    }

    //Read
    public CarrelloDto readCarrello(Long id){
        Optional<Carrello> carrello = carrelloRepo.findById(id.intValue());

        if(carrello.isPresent()){
        CarrelloDto carrelloDto = new CarrelloDto();
        Carrello c = carrello.get();
        carrelloDto.setProdotti(c.getProdotti());
        carrelloDto.setOrdine(c.getOrdine());
        carrelloDto.setQuantita(c.getQuantita());
        return carrelloDto;
        }
        return null;
    }

    //Update
    public void updateCarrello(CarrelloDto carrelloDto, String author){
        try{
            if(carrelloDto.equals(null)){
                throw new Exception("Impossibile aggiornare il carrello, l'oggetto è null");
            } else {
                Carrello c = new Carrello();
                c.setProdotti(carrelloDto.getProdotti());
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
            carrelloRepo.deleteById(id.intValue());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

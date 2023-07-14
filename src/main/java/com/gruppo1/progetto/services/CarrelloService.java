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
//    public void createCarrello (CarrelloDto carrelloDto, String author){
//        Carrello cE = new Carrello();
//        cE.setIdCarrello(carrelloDto.getId());
//        cE.setCreatedBy(author);
//        cE.setCreatedOn(LocalDateTime.now());
//        cE.setModifyBy(author);
//        cE.setModifyOn(LocalDateTime.now());
//        cE.setQuantita(carrelloDto.getQuantita());
//
//        carrelloRepository.save(cE);
//    }
//
//    //Read
//    public  CarrelloDto readCarrello (Long id){
//        try{ Optional<Carrello> carrello = carrelloRepository.findById(id.intValue());
//            CarrelloDto carrelloDto = new CarrelloDto();
//            carrelloDto.setQuantita(carrello.get().getQuantita());
//            carrelloDto.setProdotti(carrello.get().getListaProdotti());
//            return carrelloDto;
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }

    //Update
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

    //Delete
    public void deleteCarrello(Long id){
        try {
            carrelloRepository.deleteById(id.intValue());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

package com.gruppo1.progetto.services;

import com.gruppo1.progetto.repositories.OrdineRepository;
import com.gruppo1.progetto.dto.OrdineDto;
import com.gruppo1.progetto.models.Ordine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrdineService {
    @Autowired
    private OrdineRepository ordineRepository;

    //Create
    public void createOrdine (OrdineDto ordineDto, String author) {
        try {
            Ordine ordine = new Ordine();
            ordine.setDataOrdine(ordineDto.getData());
            ordine.setProdotti(ordineDto.getProdotti());
            ordine.setCliente(ordineDto.getCliente());
            ordine.setCreatedBy(author);
            ordine.setCreatedOn(LocalDateTime.now());
            ordine.setModifyBy(author);
            ordine.setModifyOn(LocalDateTime.now());
            ordineRepository.save(ordine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Read
    public OrdineDto readOrdine (Long id)  {
       try{ Optional<Ordine> ordine = ordineRepository.findById(id);
               OrdineDto ordineDto = new OrdineDto();
               ordineDto.setId(ordine.get().getId());
               ordineDto.setCliente(ordine.get().getCliente());
               ordineDto.setData(ordine.get().getDataOrdine());
               ordineDto.setProdotti(ordine.get().getProdotti());
               return ordineDto;
           }
       catch (Exception e) {
           e.printStackTrace();
       }
       return  null;


    }

    //Update
    public void updateOrdine(OrdineDto ordineDto, Long id, String author){
        try{
            if(ordineDto == null){
                throw new Exception("Impossibile aggiornare l'ordine, l'oggetto è null");
            } else {
                Ordine o = new Ordine();
                o.setCliente(ordineDto.getCliente());
                o.setDataOrdine(ordineDto.getData());
                o.setProdotti(ordineDto.getProdotti());
                o.setModifyOn(LocalDateTime.now());
                o.setModifyBy(author);
                ordineRepository.updateOrdineById(o.getDataOrdine(), o.getCliente().getId(), o.getModifyOn(), o.getModifyBy(), id);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //Delete
    public void deleteCarrello(Long id){
        try {
            ordineRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

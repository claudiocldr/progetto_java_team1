package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.IndirizzoDto;
import com.gruppo1.progetto.models.Indirizzo;
import com.gruppo1.progetto.repositories.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class IndirizzoService {
    @Autowired
    private IndirizzoRepository<Indirizzo> indirizzoRepository;

    // Create
    public void createIndirizzo(IndirizzoDto indirizzoDto, String author) {
        Indirizzo iE = new Indirizzo();
        iE.setVia(indirizzoDto.getVia());
        iE.setCap(indirizzoDto.getCap());
        iE.setNumeroCivico(indirizzoDto.getNumeroCivico());
        iE.setCreatedBy(author);
        iE.setCreatedOn(LocalDateTime.now());

        indirizzoRepository.save(iE);
    }

    // Read
    public IndirizzoDto readIndirizzo(Long id) {
        Optional<Indirizzo> indirizzo = indirizzoRepository.findById(id.intValue());
        if (indirizzo.isPresent()) {
            IndirizzoDto indirizzoDto = new IndirizzoDto();
            Indirizzo i = indirizzo.get();
            indirizzoDto.setVia(i.getVia());
            indirizzoDto.setCap(i.getCap());
            indirizzoDto.setNumeroCivico(i.getNumeroCivico());
            return indirizzoDto;
        }
        return null;
    }

    // Update
    public void updateIndirizzo(IndirizzoDto indirizzoDto, Long id, String author) {
        try {
            if (indirizzoDto == null) {
                throw new Exception("Impossibile aggiornare l'indirizzo, l'oggetto è null");
            } else {
                Indirizzo i = new Indirizzo();
                i.setVia(indirizzoDto.getVia());
                i.setCap(indirizzoDto.getCap());
                i.setNumeroCivico(indirizzoDto.getNumeroCivico());
                i.setModifyBy(author);
                i.setModifyOn(LocalDateTime.now());
                indirizzoRepository.updateIndirizzoById(i.getVia(), i.getCap(), i.getNumeroCivico(), i.getCliente().getId(), i.getModifyBy(), i.getModifyOn(), id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteIndirizzo(Long id) {
        try {
            indirizzoRepository.deleteById(id.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

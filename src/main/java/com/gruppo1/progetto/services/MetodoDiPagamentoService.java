package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.MetodoDiPagamentoDto;
import com.gruppo1.progetto.models.MetodoDiPagamento;
import com.gruppo1.progetto.repositories.MetodoDiPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class MetodoDiPagamentoService {
    @Autowired
    private MetodoDiPagamentoRepository<MetodoDiPagamento> metodoDiPagamentoRepository;

    // Create
    public void createMetodoDiPagamento(MetodoDiPagamentoDto metodoDiPagamentoDto, String author) {
        MetodoDiPagamento mE = new MetodoDiPagamento();
        mE.setNumeroCarta(metodoDiPagamentoDto.getNumeroCarta());
        mE.setNomeCognome(metodoDiPagamentoDto.getNomeCognome());
        mE.setIndirizzo(metodoDiPagamentoDto.getIndirizzo());
        mE.setCvv(metodoDiPagamentoDto.getCvv());
        mE.setCreatedBy(author);
        mE.setCreatedOn(LocalDateTime.now());

        metodoDiPagamentoRepository.save(mE);
    }

    // Read
    public MetodoDiPagamentoDto readMetodoDiPagamento(Long id) {
        Optional<MetodoDiPagamento> metodoDiPagamento = metodoDiPagamentoRepository.findById(id.intValue());
        if (metodoDiPagamento.isPresent()) {
            MetodoDiPagamentoDto metodoDiPagamentoDto = new MetodoDiPagamentoDto();
            MetodoDiPagamento m = metodoDiPagamento.get();
            metodoDiPagamentoDto.setNumeroCarta(m.getNumeroCarta());
            metodoDiPagamentoDto.setNomeCognome(m.getNomeCognome());
            metodoDiPagamentoDto.setIndirizzo(m.getIndirizzo());
            metodoDiPagamentoDto.setCvv(m.getCvv());

            return metodoDiPagamentoDto;
        }
        return null;
    }

    // Update
    public void updateMetodoDiPagamento(MetodoDiPagamentoDto metodoDiPagamentoDto, Long id, String author) {
        try {
            if (metodoDiPagamentoDto == null) {
                throw new Exception("Impossibile aggiornare il Metodo Di Pagamento, l'oggetto è null");
            } else {
                MetodoDiPagamento m = new MetodoDiPagamento();
                m.setNumeroCarta(metodoDiPagamentoDto.getNumeroCarta());
                m.setNomeCognome(metodoDiPagamentoDto.getNomeCognome());
                m.setIndirizzo(metodoDiPagamentoDto.getIndirizzo());
                m.setCvv(metodoDiPagamentoDto.getCvv());
                m.setModifyBy(author);
                m.setModifyOn(LocalDateTime.now());
                metodoDiPagamentoRepository.updateIndirizzoById(m.getNumeroCarta(), m.getNomeCognome(), m.getIndirizzo().getId(), m.getCvv(), m.getCliente().getId(), m.getModifyBy(), m.getModifyOn(), id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteMetodoDiPagamento(Long id) {
        try {
            metodoDiPagamentoRepository.deleteById(id.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

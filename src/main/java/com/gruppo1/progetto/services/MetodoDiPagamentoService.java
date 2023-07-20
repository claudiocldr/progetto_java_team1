package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.dto.IndirizzoDto;
import com.gruppo1.progetto.dto.MetodoDiPagamentoDto;
import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.models.Indirizzo;
import com.gruppo1.progetto.models.MetodoDiPagamento;
import com.gruppo1.progetto.repositories.ClienteRepository;
import com.gruppo1.progetto.repositories.IndirizzoRepository;
import com.gruppo1.progetto.repositories.MetodoDiPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MetodoDiPagamentoService {
    @Autowired
    private MetodoDiPagamentoRepository metodoDiPagamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private IndirizzoRepository indirizzoRepository;

    // Create
    public MetodoDiPagamentoDto createMetodoDiPagamento(MetodoDiPagamentoDto metodoDiPagamentoDto, Long clienteId, Long indirizzoId, String author) {
        MetodoDiPagamento mE = new MetodoDiPagamento();
        mE.setNumeroCarta(metodoDiPagamentoDto.getNumeroCarta());
        mE.setNomeCognome(metodoDiPagamentoDto.getNomeCognome());
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        mE.setIndirizzo(cliente.get().getIndirizzi().stream().filter(indirizzo -> indirizzo.getId() == indirizzoId).findFirst().get());
        mE.setCvv(metodoDiPagamentoDto.getCvv());
        mE.setCreatedBy(author);
        mE.setCreatedOn(LocalDateTime.now());

        MetodoDiPagamento metodoDiPagamento = metodoDiPagamentoRepository.save(mE);
        metodoDiPagamentoDto.setId(metodoDiPagamento.getId());
        IndirizzoDto indirizzoDto = new IndirizzoDto();
        indirizzoDto.setId(metodoDiPagamento.getIndirizzo().getId());
        indirizzoDto.setCap(metodoDiPagamento.getIndirizzo().getCap());
        indirizzoDto.setNumeroCivico(metodoDiPagamento.getIndirizzo().getNumeroCivico());
        indirizzoDto.setVia(metodoDiPagamento.getIndirizzo().getVia());
        metodoDiPagamentoDto.setIndirizzo(indirizzoDto);
        return metodoDiPagamentoDto;
    }


    // Read
    public MetodoDiPagamentoDto readMetodoDiPagamento(Long id) {
        Optional<MetodoDiPagamento> metodoDiPagamento = metodoDiPagamentoRepository.findById(id);
        MetodoDiPagamentoDto metodoDiPagamentoDto = new MetodoDiPagamentoDto();
        if (metodoDiPagamento.isPresent()) {

            MetodoDiPagamento m = metodoDiPagamento.get();
            metodoDiPagamentoDto.setId(m.getId());
            metodoDiPagamentoDto.setNumeroCarta(m.getNumeroCarta());
            metodoDiPagamentoDto.setNomeCognome(m.getNomeCognome());

            IndirizzoDto indirizzoDto = new IndirizzoDto();
            indirizzoDto.setCap(m.getIndirizzo().getCap());
            indirizzoDto.setId(m.getIndirizzo().getId());
            indirizzoDto.setNumeroCivico(m.getIndirizzo().getNumeroCivico());
            indirizzoDto.setVia(m.getIndirizzo().getVia());
            metodoDiPagamentoDto.setIndirizzo(indirizzoDto);

            metodoDiPagamentoDto.setCvv(m.getCvv());

            return metodoDiPagamentoDto;
        }
        return metodoDiPagamentoDto;
    }


    // Update
    public MetodoDiPagamentoDto updateMetodoDiPagamento(MetodoDiPagamentoDto metodoDiPagamentoDto, String author) {
                MetodoDiPagamento m = metodoDiPagamentoRepository.findById(metodoDiPagamentoDto.getId()).get();
                m.setNumeroCarta(metodoDiPagamentoDto.getNumeroCarta());
                m.setNomeCognome(metodoDiPagamentoDto.getNomeCognome());
               Indirizzo indirizzoAggiornato = indirizzoRepository.findById(metodoDiPagamentoDto.getIndirizzo().getId()).get();
                m.setIndirizzo(indirizzoAggiornato);
                m.setCvv(metodoDiPagamentoDto.getCvv());
                m.setModifyBy(author);
                m.setModifyOn(LocalDateTime.now());
                metodoDiPagamentoRepository.updateIndirizzoById(m.getNumeroCarta(), m.getNomeCognome(), m.getIndirizzo().getId(), m.getCvv(), m.getModifyBy(), m.getModifyOn(), m.getId());

                IndirizzoDto indirizzoDto = new IndirizzoDto();
                indirizzoDto.setCap(indirizzoAggiornato.getCap());
                indirizzoDto.setNumeroCivico(indirizzoAggiornato.getNumeroCivico());
                indirizzoDto.setVia(indirizzoAggiornato.getVia());
                indirizzoDto.setId(indirizzoAggiornato.getId());

                MetodoDiPagamentoDto metodoDiPagamentoDtoAggiornato = new MetodoDiPagamentoDto();
                metodoDiPagamentoDtoAggiornato.setNomeCognome(m.getNomeCognome());
                metodoDiPagamentoDtoAggiornato.setNumeroCarta(m.getNumeroCarta());
                metodoDiPagamentoDtoAggiornato.setCvv(m.getCvv());
                metodoDiPagamentoDtoAggiornato.setId(m.getId());
                metodoDiPagamentoDtoAggiornato.setIndirizzo(indirizzoDto);

                return metodoDiPagamentoDtoAggiornato;
    }

    // Delete
    public MetodoDiPagamentoDto deleteMetodoDiPagamento(Long id) {
        Optional<MetodoDiPagamento> metodoDiPagamento = metodoDiPagamentoRepository.findById(id);
        MetodoDiPagamentoDto metodoDiPagamentoDto = new MetodoDiPagamentoDto();
        metodoDiPagamentoDto.setId(metodoDiPagamento.get().getId());
        metodoDiPagamentoDto.setNomeCognome(metodoDiPagamento.get().getNomeCognome());
        metodoDiPagamentoDto.setNumeroCarta(metodoDiPagamento.get().getNumeroCarta());
        IndirizzoDto indirizzoDto = new IndirizzoDto();
        indirizzoDto.setCap(metodoDiPagamento.get().getIndirizzo().getCap());
        indirizzoDto.setNumeroCivico(metodoDiPagamento.get().getIndirizzo().getNumeroCivico());
        indirizzoDto.setVia(metodoDiPagamento.get().getIndirizzo().getVia());
        indirizzoDto.setId(metodoDiPagamento.get().getIndirizzo().getId());
        metodoDiPagamentoDto.setIndirizzo(indirizzoDto);
        metodoDiPagamentoRepository.deleteById(id);
        return metodoDiPagamentoDto;
    }
}

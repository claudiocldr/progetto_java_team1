package com.gruppo1.progetto.services;

import com.gruppo1.progetto.dto.ClienteDto;
import com.gruppo1.progetto.dto.IndirizzoDto;
import com.gruppo1.progetto.dto.MetodoDiPagamentoDto;
import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.models.Indirizzo;
import com.gruppo1.progetto.models.MetodoDiPagamento;
import com.gruppo1.progetto.repositories.ClienteRepository;
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

    // Create
    public MetodoDiPagamentoDto createMetodoDiPagamento(MetodoDiPagamentoDto metodoDiPagamentoDto, ClienteDto clienteDto, Long indirizzoId, String author) {
        MetodoDiPagamento mE = new MetodoDiPagamento();
        mE.setNumeroCarta(metodoDiPagamentoDto.getNumeroCarta());
        mE.setNomeCognome(metodoDiPagamentoDto.getNomeCognome());
        Optional<Cliente> cliente = clienteRepository.findById(clienteDto.getId());
        mE.setIndirizzo(cliente.get().getIndirizzi().stream().filter(indirizzo -> indirizzo.getId() == indirizzoId).findFirst().get());
        mE.setCvv(metodoDiPagamentoDto.getCvv());
        mE.setCreatedBy(author);
        mE.setCreatedOn(LocalDateTime.now());

        metodoDiPagamentoRepository.save(mE);
        return metodoDiPagamentoDto;
    }
}

//    // Read
//    public MetodoDiPagamentoDto readMetodoDiPagamento(Long id) {
//        Optional<MetodoDiPagamento> metodoDiPagamento = metodoDiPagamentoRepository.findById(id);
//        MetodoDiPagamentoDto metodoDiPagamentoDto = new MetodoDiPagamentoDto();
//        if (metodoDiPagamento.isPresent()) {
//
//            MetodoDiPagamento m = metodoDiPagamento.get();
//            metodoDiPagamentoDto.setNumeroCarta(m.getNumeroCarta());
//            metodoDiPagamentoDto.setNomeCognome(m.getNomeCognome());
//            metodoDiPagamentoDto.setIndirizzo(m.getIndirizzo());
//            metodoDiPagamentoDto.setCvv(m.getCvv());
//
//            return metodoDiPagamentoDto;
//        }
//        return metodoDiPagamentoDto;
//    }
//
//    // Update
//    public MetodoDiPagamentoDto updateMetodoDiPagamento(MetodoDiPagamentoDto metodoDiPagamentoDto, Long id, String author) {
//                MetodoDiPagamento m = new MetodoDiPagamento();
//                m.setNumeroCarta(metodoDiPagamentoDto.getNumeroCarta());
//                m.setNomeCognome(metodoDiPagamentoDto.getNomeCognome());
//                m.setIndirizzo(metodoDiPagamentoDto.getIndirizzo());
//                m.setCvv(metodoDiPagamentoDto.getCvv());
//                m.setModifyBy(author);
//                m.setModifyOn(LocalDateTime.now());
//                metodoDiPagamentoRepository.updateIndirizzoById(m.getNumeroCarta(), m.getNomeCognome(), m.getIndirizzo().getId(), m.getCvv(), m.getCliente().getId(), m.getModifyBy(), m.getModifyOn(), id);
//
//                ClienteDto clienteDto = new ClienteDto(
//                        m.getCliente().getId(),
//                        m.getCliente().getNome(),
//                        m.getCliente().getCognome(),
//                        m.getCliente().getDataDiNascita(),
//                        m.getCliente().getTelefono(),
//                        m.getCliente().getEmail(),
//                        m.getCliente().getCodiceFiscale(),
//                        m.getCliente().getPassword());
//                return new MetodoDiPagamentoDto(m.getId(), m.getNumeroCarta(), m.getNomeCognome(), m.getIndirizzo(), m.getCvv(), clienteDto);
//    }
//
//    // Delete
//    public void deleteMetodoDiPagamento(Long id) {
//            metodoDiPagamentoRepository.deleteById(id);
//    }
//}

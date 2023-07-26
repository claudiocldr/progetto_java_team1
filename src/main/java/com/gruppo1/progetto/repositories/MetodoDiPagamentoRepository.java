package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.MetodoDiPagamento;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@Transactional
public interface MetodoDiPagamentoRepository extends JpaRepository<MetodoDiPagamento, Long> {

    void deleteByClienteId (Long clienteId);
    @Modifying
    @Query(value = "UPDATE metodo_di_pagamento SET numero_carta = ?, nome_cognome = ?, indirizzo_id = ?, cvv = ?, modify_by = ?, modify_on = ? WHERE id = ?", nativeQuery = true)
    void updateIndirizzoById(String numeroCarta, String nomeCognome, Long indirizzoId, String cvv, String modifyBy, LocalDateTime modifyOn, Long id);
}

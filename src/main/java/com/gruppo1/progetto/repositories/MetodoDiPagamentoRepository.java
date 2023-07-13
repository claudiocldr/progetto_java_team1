package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.MetodoDiPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MetodoDiPagamentoRepository<P> extends JpaRepository<MetodoDiPagamento, Integer> {

    @Modifying
    @Query(value = "UPDATE metodo_di_pagamento SET numero_carta = ?, nome_cognome = ?, indirizzo_id = ?, cvv = ?, id_cliente = ?, modify_by = ?, modify_on = ? WHERE id = ?", nativeQuery = true)
    void updateIndirizzoById(String numeroCarta, String nomeCognome, Long indirizzoId, String cvv, Long clienteId, String modifyBy, LocalDateTime modifyOn, Long id);
}

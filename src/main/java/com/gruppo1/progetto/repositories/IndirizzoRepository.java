package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface IndirizzoRepository<P> extends JpaRepository<Indirizzo, Integer> {
    @Modifying
    @Query(value = "UPDATE indirizzo SET via = ?, cap = ?, numero_civico = ?, id_cliente = ?, modify_by = ?, modify_on = ? WHERE id = ?", nativeQuery = true)
    void updateIndirizzoById(String via, String cap, Integer numeroCivico, Long idCliente, String modifyBy, LocalDateTime modifyOn, Long id);
}

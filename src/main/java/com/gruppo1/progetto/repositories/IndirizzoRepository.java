package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.Indirizzo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IndirizzoRepository extends JpaRepository<Indirizzo, Integer> {

    Optional<Indirizzo> findById(Long id);

    Optional<List<Indirizzo>> findByClienteId(Long clienteId);

    void deleteIndirizzoById(Long id);

    void deleteByClienteId(Long id);
    @Modifying
    @Query(value = "UPDATE indirizzo SET via = ?, cap = ?, numero_civico = ?,  modify_by = ?, modify_on = ? WHERE id = ?", nativeQuery = true)
    void updateIndirizzoById(String via, String cap, Integer numeroCivico, String modifyBy, LocalDateTime modifyOn, Long id);
}

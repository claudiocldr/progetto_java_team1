package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.models.Ordine;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface OrdineRepository extends JpaRepository<Ordine, Long> {

    @Query(nativeQuery = true)
    Optional<Ordine> findOrdineById(UUID uuid);

    @Query(value= "DELETE FROM ordine WHERE id = ?",nativeQuery = true)
    @Modifying
    void deleteOrdineById(UUID uuid);

    @Modifying
    @Query(value= "DELETE FROM ordine WHERE cliente_id = ?",nativeQuery = true)
    void deleteOrdineByClienteId(Long clienteId);
    @Modifying
    @Query(value = "UPDATE ordine SET data = ?, cliente_id = ?, modify_on = ?, modify_by = ? WHERE id = ?", nativeQuery = true)
   void updateOrdineById(LocalDate data, Long clienteId, LocalDateTime modifyOn, String modifyBy, Long id);




}

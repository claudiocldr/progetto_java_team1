package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.Ordine;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
@Transactional
public interface OrdineRepo extends JpaRepository<Ordine, Long> {
    @Modifying
    @Query(value = "UPDATE ordine SET data = ?, cliente_id = ?, modify_on = ?, modify_by = ? WHERE id = ?", nativeQuery = true)
   void updateOrdineById(LocalDate data, Long clienteId, LocalDateTime modifyOn, String modifyBy, Long id);
}

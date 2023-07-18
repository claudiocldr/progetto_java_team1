package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.OrdineProdotto;
import com.gruppo1.progetto.models.Prodotto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface OrdineProdottoRepository extends JpaRepository<OrdineProdotto, Long> {
    @Modifying
    @Query(value = "UPDATE ordine_prodotto SET quantita = ?, modify_by = ?, modify_on = ? WHERE ordine_id = ?", nativeQuery = true)
    void updateOrdineProdottoByOrdineId(Integer quantita, List<Prodotto> listaProdotti, String modifyBy, LocalDateTime modifyOn, Long id);

    List<Optional<OrdineProdotto>> findOrdineProdottoByOrdineId(UUID id);
}

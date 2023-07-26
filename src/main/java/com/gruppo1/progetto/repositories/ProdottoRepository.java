package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.Prodotto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

    @Modifying
    @Query(value = "UPDATE prodotto SET nome = ?, descrizione = ?, prezzo = ?, modify_on = ?, modify_by = ? WHERE identificatore_articolo = ?", nativeQuery = true)
    void updateProdottoByIdentificatoreArticolo(String nome, String descrizione, Double prezzo, LocalDateTime modifyOn, String modifyBy, UUID identificatoreArticolo);

    Optional<Prodotto> findByIdentificatoreArticolo (UUID identificatoreArticolo);

    @Modifying
    void deleteByIdentificatoreArticolo (UUID identificatoreArticolo);


}

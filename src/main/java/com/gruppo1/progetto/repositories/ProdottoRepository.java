package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.Prodotto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

    @Modifying
    @Query(value = "UPDATE prodotto SET nome = ?, descrizione = ?, prezzo = ?, sku = ?, modify_on = ?, modify_by = ? WHERE ID = ?", nativeQuery = true)
    void updateProdottoById(String nome, String descrizione, Double prezzo, String sku, LocalDateTime modifyOn, String modifyBy, Long id);
}

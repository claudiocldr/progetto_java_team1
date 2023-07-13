package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.Carrello;
import com.gruppo1.progetto.models.Prodotto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface CarrelloRepository extends JpaRepository<Carrello, Integer> {
    @Modifying
    @Query(value = "UPDATE carrello SET quantita = ?, lista_prodotti = ?, modify_by = ?, modify_on = ? WHERE id = ?", nativeQuery = true)
    void updateCarrelloById(Integer quantita, List<Prodotto> listaProdotti, String modifyBy, LocalDateTime modifyOn, Long id);
}

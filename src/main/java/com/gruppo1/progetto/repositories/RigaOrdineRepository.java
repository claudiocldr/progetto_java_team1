package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.RigaOrdine;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface RigaOrdineRepository extends JpaRepository<RigaOrdine, Long> {
    List<RigaOrdine> findByCarrelloId(Long carrelloId);

    void deleteAllByCarrelloId(Long carrelloId);
}

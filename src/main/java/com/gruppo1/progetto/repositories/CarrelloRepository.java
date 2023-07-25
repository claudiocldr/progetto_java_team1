package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.Carrello;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {
}

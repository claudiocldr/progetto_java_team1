package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Integer> {

}

package com.gruppo1.progetto.Repositories;

import com.gruppo1.progetto.models.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrelloRepo<P> extends JpaRepository<Carrello, Integer> {

}

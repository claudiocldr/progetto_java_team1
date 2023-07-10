package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndirizzoRepository<P> extends JpaRepository<Indirizzo, Integer> {
}

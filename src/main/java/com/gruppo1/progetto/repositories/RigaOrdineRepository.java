package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.RigaOrdine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RigaOrdineRepository extends JpaRepository<RigaOrdine, Long> {
}

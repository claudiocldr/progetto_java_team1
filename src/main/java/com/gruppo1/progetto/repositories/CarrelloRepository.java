package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.Carrello;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {

    Optional<Carrello> findByNomeAndClienteId(String nome, Long clienteId);

    void deleteAllByClienteId(Long clienteId);

}

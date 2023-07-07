package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo<P> extends JpaRepository<Cliente, Integer> {

}

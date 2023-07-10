package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.MetodoDiPagamento;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoDiPagamentoRepository<P> extends JpaRepository<MetodoDiPagamento, Integer> {
}

package com.gruppo1.progetto.dto;

import com.gruppo1.progetto.models.Ordine;
import com.gruppo1.progetto.models.Prodotto;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class CarrelloDto {
        private Long id;
        private List<Prodotto> prodotti;
        private Integer quantita;

        private LocalDateTime created_on;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }


    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public LocalDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDateTime created_on) {
        this.created_on = created_on;
    }
}

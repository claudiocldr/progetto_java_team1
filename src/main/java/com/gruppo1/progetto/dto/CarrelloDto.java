package com.gruppo1.progetto.dto;

import com.gruppo1.progetto.models.Ordine;
import com.gruppo1.progetto.models.Prodotto;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class CarrelloDto {
        private List<Prodotto> prodotti;
        private Ordine ordine;
        private Integer quantita;

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }
}

package com.gruppo1.progetto.dto;

import com.gruppo1.progetto.models.Ordine;
import com.gruppo1.progetto.models.Prodotto;

public class OrdineProdottoDto {

    private Ordine ordine;
    private Prodotto prodotto;

    private Long quantita;

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Long getQuantita() {
        return quantita;
    }

    public void setQuantita(Long quantita) {
        this.quantita = quantita;
    }
}

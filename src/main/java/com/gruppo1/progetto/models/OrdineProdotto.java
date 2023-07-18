package com.gruppo1.progetto.models;

import jakarta.persistence.*;

@Table
@Entity
public class OrdineProdotto {

    @EmbeddedId
    OrdineProdottoKey id;

    @ManyToOne
    @MapsId("ordineId")
    @JoinColumn(name = "ordine_id")
    Ordine ordine;

    @ManyToOne
    @MapsId("prodottoId")
    @JoinColumn(name = "prodotto_id")
    Prodotto prodotto;

    private Long quantita = 0L;

    public OrdineProdottoKey getId() {
        return id;
    }

    public void setId(OrdineProdottoKey id) {
        this.id = id;
    }

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

    public void addQuantita(){
        quantita++;
    }
}
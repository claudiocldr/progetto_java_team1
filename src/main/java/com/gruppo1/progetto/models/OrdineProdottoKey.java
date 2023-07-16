package com.gruppo1.progetto.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
    public class OrdineProdottoKey implements Serializable {


        @Column(name = "ordine_id")
        Long ordineId;

        @Column(name = "prodotto_id")
        Long prodottoId;

    public Long getOrdineId() {
        return ordineId;
    }

    public void setOrdineId(Long ordineId) {
        this.ordineId = ordineId;
    }

    public Long getProdottoId() {
        return prodottoId;
    }

    public void setProdottoId(Long prodottoId) {
        this.prodottoId = prodottoId;
    }
}

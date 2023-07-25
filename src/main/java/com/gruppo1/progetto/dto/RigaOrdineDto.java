package com.gruppo1.progetto.dto;

import com.gruppo1.progetto.models.Prodotto;
import jakarta.persistence.Column;

public class RigaOrdineDto {

    private ProdottoDto prodotto;
    private Integer quantita;

    public ProdottoDto getProdotto() {
        return prodotto;
    }

    public void setProdotto(ProdottoDto prodotto) {
        this.prodotto = prodotto;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }
}

package com.gruppo1.progetto.dto;

import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.models.Prodotto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.List;

public class OrdineDto {
    private Date data;
    private List<Prodotto> prodotti;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }
}

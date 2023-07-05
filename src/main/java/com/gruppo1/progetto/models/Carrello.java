package com.gruppo1.progetto.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carrello")
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrello;

    @OneToMany
    @JoinColumn(name = "id_prodotto")
    private List<Prodotto> prodotti;

    @OneToOne
    @JoinColumn(name = "id_ordine")
    private Ordine ordine;

    private Integer quantita;

    public Long getIdCarrello() {
        return idCarrello;
    }

    public void setIdCarrello(Long idCarrello) {
        this.idCarrello = idCarrello;
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
}
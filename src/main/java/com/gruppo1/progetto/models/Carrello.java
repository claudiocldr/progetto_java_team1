package com.gruppo1.progetto.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carrello")
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrello;

    @OneToMany
    @JoinColumn(name = "id_prodotto")
    private Prodotto prodotto;

    private List<Prodotto> quantita;

    public Long getId_carrello() {
        return id_carrello;
    }

    public void setId_carrello(Long id_carrello) {
        this.id_carrello = id_carrello;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public List<Prodotto> getQuantita() {
        return quantita;
    }

    public void setQuantita(List<Prodotto> quantita) {
        this.quantita = quantita;
    }
}
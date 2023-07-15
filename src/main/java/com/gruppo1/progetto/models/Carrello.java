package com.gruppo1.progetto.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Carrello {

    @EmbeddedId
    private CarrelloKey id;

    @ManyToOne
    @MapsId("ordineId")
    @JoinColumn(name = "ordine_id")
    private Ordine ordine;

    @ManyToOne
    @MapsId("ProdottoId")
    @JoinColumn(name = "prodotto_id")
    private Prodotto prodotto;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modify_by")
    private String modifyBy;

    @Column(name = "modify_on")
    private LocalDateTime modifyOn;

    public CarrelloKey getId() {
        return id;
    }

    public void setId(CarrelloKey id) {
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public LocalDateTime getModifyOn() {
        return modifyOn;
    }

    public void setModifyOn(LocalDateTime modifyOn) {
        this.modifyOn = modifyOn;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }
}


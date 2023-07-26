package com.gruppo1.progetto.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "prodotto")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String descrizione;
    @Column
    private Double prezzo;

    @Column
    private Long numeroArticolo;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modify_by")
    private String modifyBy;

    @Column(name = "modify_on")
    private LocalDateTime modifyOn;

    public Prodotto() {
    }

    public Prodotto(Long id, String nome, String descrizione, Double prezzo, Long numeroArticolo, String createdBy, LocalDateTime createdOn, String modifyBy, LocalDateTime modifyOn) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.numeroArticolo = numeroArticolo;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.modifyBy = modifyBy;
        this.modifyOn = modifyOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Long getNumeroArticolo() {
        return numeroArticolo;
    }

    public void setNumeroArticolo(Long numeroArticolo) {
        this.numeroArticolo = numeroArticolo;
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
}

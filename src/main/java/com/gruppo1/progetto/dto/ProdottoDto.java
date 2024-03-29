package com.gruppo1.progetto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class ProdottoDto {
    private String nome;
    private String descrizione;
    private Double prezzo;
    private UUID identificatoreArticolo;

    public ProdottoDto() {
    }

    public ProdottoDto(String nome, String descrizione, Double prezzo, UUID identificatoreArticolo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.identificatoreArticolo = identificatoreArticolo;
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


    public UUID getIdentificatoreArticolo() {
        return identificatoreArticolo;
    }

    public void setIdentificatoreArticolo(UUID identificatoreArticolo) {
        this.identificatoreArticolo = identificatoreArticolo;
    }
}

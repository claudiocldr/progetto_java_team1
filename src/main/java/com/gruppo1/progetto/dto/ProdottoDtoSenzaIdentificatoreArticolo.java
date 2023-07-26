package com.gruppo1.progetto.dto;

public class ProdottoDtoSenzaIdentificatoreArticolo {
    private String nome;
    private String descrizione;
    private Double prezzo;

    public ProdottoDtoSenzaIdentificatoreArticolo(String nome, String descrizione, Double prezzo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public ProdottoDtoSenzaIdentificatoreArticolo() {
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
}

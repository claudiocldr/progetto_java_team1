package com.gruppo1.progetto.dto;

public class ProdottoDto {
    private String nome;
    private String descrizione;
    private Double prezzo;

    private Long numeroArticolo;

    public ProdottoDto() {
    }

    public ProdottoDto(String nome, String descrizione, Double prezzo, Long numeroArticolo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.numeroArticolo = numeroArticolo;
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
}

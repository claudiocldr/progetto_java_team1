package com.gruppo1.progetto.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.models.Indirizzo;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class MetodoDiPagamentoDto {
    private Long id;
    private String numeroCarta;
    private String nomeCognome;
    @JsonIgnore
    private IndirizzoDto indirizzo;
    private String cvv;

    public MetodoDiPagamentoDto() {

    }

    public MetodoDiPagamentoDto(Long id, String numeroCarta, String nomeCognome, IndirizzoDto indirizzo, String cvv) {
        this.id = id;
        this.numeroCarta = numeroCarta;
        this.nomeCognome = nomeCognome;
        this.indirizzo = indirizzo;
        this.cvv = cvv;
    }

    public void setIndirizzo(IndirizzoDto indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(String numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    public String getNomeCognome() {
        return nomeCognome;
    }

    public void setNomeCognome(String nomeCognome) {
        this.nomeCognome = nomeCognome;
    }

    public IndirizzoDto getIndirizzo() {
        return indirizzo;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}

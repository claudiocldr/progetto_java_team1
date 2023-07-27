package com.gruppo1.progetto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MetodoDiPagamentoSenzaIdDto {

    private String numeroCarta;
    private String nomeCognome;
    @JsonIgnore
    private IndirizzoDto indirizzo;
    private String cvv;

    public MetodoDiPagamentoSenzaIdDto() {

    }


    public void setIndirizzo(IndirizzoDto indirizzo) {
        this.indirizzo = indirizzo;
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

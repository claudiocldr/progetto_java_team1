package com.gruppo1.progetto.dto;

import com.gruppo1.progetto.models.Cliente;

public class IndirizzoDto {
    private String via;
    private String cap;
    private Integer numeroCivico;

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public Integer getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(Integer numeroCivico) {
        this.numeroCivico = numeroCivico;
    }
}

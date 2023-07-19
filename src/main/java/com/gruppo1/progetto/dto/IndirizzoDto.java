package com.gruppo1.progetto.dto;

import com.gruppo1.progetto.models.Cliente;

public class IndirizzoDto {
    private Long id;
    private String via;
    private String cap;
    private Integer numeroCivico;

    public IndirizzoDto(Long id, String via, String cap, Integer numeroCivico) {
        this.id = id;
        this.via = via;
        this.cap = cap;
        this.numeroCivico = numeroCivico;
    }

    public IndirizzoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

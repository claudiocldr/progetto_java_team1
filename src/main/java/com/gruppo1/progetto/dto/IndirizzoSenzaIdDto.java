package com.gruppo1.progetto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class IndirizzoSenzaIdDto {

    private String via;
    private String cap;
    private Integer numeroCivico;
    @JsonIgnore
    private ClienteDto clienteDto;

    public IndirizzoSenzaIdDto(String via, String cap, Integer numeroCivico, ClienteDto clienteDto) {
        this.via = via;
        this.cap = cap;
        this.numeroCivico = numeroCivico;
        this.clienteDto = clienteDto;
    }

    public IndirizzoSenzaIdDto() {
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

    public ClienteDto getClienteDto() {
        return clienteDto;
    }

    public void setClienteDto(ClienteDto clienteDto) {
        this.clienteDto = clienteDto;
    }
}


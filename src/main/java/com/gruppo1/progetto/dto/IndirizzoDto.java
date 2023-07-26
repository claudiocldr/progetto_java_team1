package com.gruppo1.progetto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gruppo1.progetto.models.Cliente;

public class IndirizzoDto {
    @JsonIgnore
    private Long id;
    private String via;
    private String cap;
    private Integer numeroCivico;

    @JsonIgnore
    private ClienteDto clienteDto;

    public IndirizzoDto(Long id, String via, String cap, Integer numeroCivico, ClienteDto clienteDto) {
        this.id = id;
        this.via = via;
        this.cap = cap;
        this.numeroCivico = numeroCivico;
        this.clienteDto = clienteDto;
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

    public ClienteDto getClienteDto() {
        return clienteDto;
    }

    public void setClienteDto(ClienteDto clienteDto) {
        this.clienteDto = clienteDto;
    }
}


package com.gruppo1.progetto.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.models.Prodotto;
import org.hibernate.type.descriptor.jdbc.ArrayJdbcType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrdineDto {
    @JsonIgnore

    private Long id;
    private LocalDate data;


    private List<RigaOrdineDto> prodotti;

    private ClienteDto clienteDto;

    public OrdineDto() {
    }



    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<RigaOrdineDto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<RigaOrdineDto> prodotti) {
        this.prodotti = prodotti;
    }

    public ClienteDto getClienteDto() {
        return clienteDto;
    }

    public void setClienteDto(ClienteDto clienteDto) {
        this.clienteDto = clienteDto;
    }
}

package com.gruppo1.progetto.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.models.Prodotto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrdineDto {
    private UUID id;
    private LocalDate data;


    private ArrayList<ProdottoDto> prodotti;

    private ClienteDto clienteDto;

    public OrdineDto() {
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ArrayList<ProdottoDto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(ArrayList<ProdottoDto> prodotti) {
        this.prodotti = prodotti;
    }

    public ClienteDto getClienteDto() {
        return clienteDto;
    }

    public void setClienteDto(ClienteDto clienteDto) {
        this.clienteDto = clienteDto;
    }
}

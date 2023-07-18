package com.gruppo1.progetto.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.models.Prodotto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrdineDto {
    private UUID id;
    private LocalDate data;


    private List<Prodotto> prodotti;

    @JsonIgnore
    private Cliente cliente;

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

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

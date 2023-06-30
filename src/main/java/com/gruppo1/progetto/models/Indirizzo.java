package com.gruppo1.progetto.models;

import jakarta.persistence.*;

@Entity
@Table(name = "indirizzo")
public class Indirizzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String via;
    private String cap;
    private Integer numero_civico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Indirizzo(Long id, String via, String cap, Integer numero_civico, Cliente cliente) {
        this.id = id;
        this.via = via;
        this.cap = cap;
        this.numero_civico = numero_civico;
        this.cliente = cliente;
    }

    public Indirizzo() {
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

    public Integer getNumero_civico() {
        return numero_civico;
    }

    public void setNumero_civico(Integer numero_civico) {
        this.numero_civico = numero_civico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

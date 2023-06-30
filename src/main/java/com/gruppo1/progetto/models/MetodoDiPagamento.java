package com.gruppo1.progetto.models;

import jakarta.persistence.*;

@Entity
@Table(name = "metodo_di_pagamento")
public class MetodoDiPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero_carta;
    private String nome_cognome;

    @OneToOne
    @JoinColumn(name = "indirizzo_id")
    private Indirizzo indirizzo;

    private String cvv;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_carta() {
        return numero_carta;
    }

    public void setNumero_carta(String numero_carta) {
        this.numero_carta = numero_carta;
    }

    public String getNome_cognome() {
        return nome_cognome;
    }

    public void setNome_cognome(String nome_cognome) {
        this.nome_cognome = nome_cognome;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

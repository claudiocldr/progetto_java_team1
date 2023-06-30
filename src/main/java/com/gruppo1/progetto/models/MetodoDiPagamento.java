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
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}

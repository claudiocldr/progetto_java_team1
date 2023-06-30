package com.gruppo1.progetto.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ordine")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ordine;
    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_carrello")
    private Carrello carrello;

    public Ordine(Long id_ordine, Date data, Cliente cliente) {
        this.id_ordine = id_ordine;
        this.data = data;
        this.cliente = cliente;
    }

    public Ordine() {
    }

    public Long getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(Long id_ordine) {
        this.id_ordine = id_ordine;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

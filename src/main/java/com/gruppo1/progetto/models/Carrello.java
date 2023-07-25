package com.gruppo1.progetto.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Carrello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "carrello")
    List<Ordine> ordini;
    @OneToMany(mappedBy = "carrello")
    private List<RigaOrdine> rigaOrdineList;

    @ManyToOne
    private Cliente cliente;

    public Carrello() {
    }

    public Carrello(String nome) {
        this.nome = nome;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }

    public List<RigaOrdine> getRigaOrdineList() {
        return rigaOrdineList;
    }

    public void setRigaOrdineList(List<RigaOrdine> rigaOrdineList) {
        this.rigaOrdineList = rigaOrdineList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

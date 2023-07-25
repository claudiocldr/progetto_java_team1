package com.gruppo1.progetto.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Carrello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Ordine ordine;

    @OneToMany
    private List<RigaOrdine> rigaOrdineList;

    public Carrello(Long id, Ordine ordine) {
        this.id = id;
        this.ordine = ordine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public List<RigaOrdine> getRigaOrdineList() {
        return rigaOrdineList;
    }

    public void setRigaOrdineList(List<RigaOrdine> rigaOrdineList) {
        this.rigaOrdineList = rigaOrdineList;
    }
}

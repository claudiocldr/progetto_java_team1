package com.gruppo1.progetto.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ordine")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_ordine")
    private LocalDate dataOrdine;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Cliente cliente;


    @ManyToMany(mappedBy = "listaOrdini")
    private List<Prodotto> prodotti;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modify_by")
    private String modifyBy;

    @Column(name = "modify_on")
    private LocalDateTime modifyOn;

    public Ordine(Long id, LocalDate dataOrdine, Cliente cliente) {
        this.id = id;
        this.dataOrdine = dataOrdine;
        this.cliente = cliente;
    }

    public Ordine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public LocalDateTime getModifyOn() {
        return modifyOn;
    }

    public void setModifyOn(LocalDateTime modifyOn) {
        this.modifyOn = modifyOn;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", dataOrdine=" + dataOrdine +
                ", cliente=" + cliente +
                ", prodotti=" + prodotti +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyOn=" + modifyOn +
                '}';
    }
}

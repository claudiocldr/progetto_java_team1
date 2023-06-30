package com.gruppo1.progetto.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    private String nome;
    private String cognome;

    private Date dataDiNascita;

    private String telefono;

    @Column(unique=true)
    private String email;
    private String codiceFiscale;

    private String password;

    @ManyToMany
    @JoinTable(name= "indirizzo_cliente", joinColumns = @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "indirizzo_id"))
    private List<Indirizzo> indirizzi;

    public Cliente(Long id_cliente, String nome, String cognome, Date dataDiNascita, String telefono, String email, String codiceFiscale, String password, List<Indirizzo> indirizzi) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.telefono = telefono;
        this.email = email;
        this.codiceFiscale = codiceFiscale;
        this.password = password;
        this.indirizzi = indirizzi;
    }

    public Cliente() {
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public List<Indirizzo> getIndirizzi() {
        return indirizzi;
    }

    public void setIndirizzi(List<Indirizzo> indirizzi) {
        this.indirizzi = indirizzi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.gruppo1.progetto.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table (name = "cliente")
public class Cliente {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;
    @Column
    private String telefono;

    @Column(unique = true)
    private String email;

    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    private String password;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Ordine> ordini;

    @OneToMany(mappedBy = "cliente")
    private List<Indirizzo> indirizzi;

    @OneToMany(mappedBy = "cliente")
    private final List<Carrello> carrelli = new ArrayList<>(List.of(new Carrello("carrello"), new Carrello("lista desideri")));


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RecordStatusEnum status;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modify_by")
    private String modifyBy;

    @Column(name = "modify_on")
    private LocalDateTime modifyOn;

    public Cliente(Long id, String nome, String cognome, LocalDate dataDiNascita, String telefono, String email, String codiceFiscale, String password, List<Indirizzo> indirizzi, RecordStatusEnum status) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.telefono = telefono;
        this.email = email;
        this.codiceFiscale = codiceFiscale;
        this.password = password;
        this.indirizzi = indirizzi;
        this.status = status;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
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

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }

    public RecordStatusEnum getStatus() {
        return status;
    }

    public void setStatus(RecordStatusEnum status) {
        this.status = status;
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

    public List<Carrello> getCarrelli() {
        return carrelli;
    }
}

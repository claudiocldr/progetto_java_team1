package com.gruppo1.progetto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gruppo1.progetto.models.Indirizzo;
import com.gruppo1.progetto.models.Ordine;
import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class ClienteDto {

    private Long id;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String telefono;
    private String email;
    private String codiceFiscale;
    private String password;

    public ClienteDto() {
    }

    public ClienteDto(Long id, String nome, String cognome, LocalDate dataDiNascita, String telefono, String email, String codiceFiscale, String password) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.telefono = telefono;
        this.email = email;
        this.codiceFiscale = codiceFiscale;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

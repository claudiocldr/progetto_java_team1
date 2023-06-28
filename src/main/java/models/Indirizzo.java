package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Indirizzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String via;
    private String cap;
    private Integer numero_civico;

    public Indirizzo(Long id, String via, String cap, Integer numero_civico) {
        this.id = id;
        this.via = via;
        this.cap = cap;
        this.numero_civico = numero_civico;
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
}

package com.gruppo1.progetto.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Embeddable
public class CarrelloKey implements Serializable {


    @Column(name = "ordine_id")
    Long ordineId;

    @Column(name = "prodotto_id")
    Long prodottoId;
}




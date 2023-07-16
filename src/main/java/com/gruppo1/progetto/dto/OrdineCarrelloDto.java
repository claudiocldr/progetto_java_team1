package com.gruppo1.progetto.dto;

import java.time.LocalDate;

public class OrdineCarrelloDto {

    private Long id;
    private LocalDate data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}

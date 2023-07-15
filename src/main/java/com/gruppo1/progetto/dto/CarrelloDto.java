package com.gruppo1.progetto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gruppo1.progetto.models.Prodotto;

import java.util.List;

public class CarrelloDto {
        private List<ProdottoDto> listaProdotti;
        private Double totaleProdotti;

        @JsonIgnore
        private OrdineDto ordineDto;
        private OrdineCarrelloDto dettagliOrdine;
        @JsonIgnore
        private ProdottoDto prodottoDto;


    public List<ProdottoDto> getListaProdotti() {
        return listaProdotti;
    }

    public ProdottoDto getProdottoDto() {
        return prodottoDto;
    }

    public void setProdottoDto(ProdottoDto prodottoDto) {
        this.prodottoDto = prodottoDto;
    }

    public void setListaProdotti(List<ProdottoDto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public Double getTotaleProdotti() {
        return totaleProdotti;
    }

    public void setTotaleProdotti(Double totaleProdotti) {
        this.totaleProdotti = totaleProdotti;
    }

    public OrdineCarrelloDto getDettagliOrdine() {
        return dettagliOrdine;
    }

    public void setDettagliOrdine(OrdineCarrelloDto dettagliOrdine) {
        this.dettagliOrdine = dettagliOrdine;
    }

    public OrdineDto getOrdineDto() {
        return ordineDto;
    }

    public void setOrdineDto(OrdineDto ordineDto) {
        this.ordineDto = ordineDto;
    }
}

package com.gruppo1.progetto.dto;

public class RiepilogoOrdine {

    private MetodoDiPagamentoDto metodoDiPagamentoSelezionato;
    private OrdineDto ordineEffettuato;
    private IndirizzoDto indirizzoDiSpedizione;

    public RiepilogoOrdine(){

    }
    public RiepilogoOrdine(MetodoDiPagamentoDto metodoDiPagamentoSelezionato, OrdineDto ordineEffettuato, IndirizzoDto indirizzoDiSpedizione) {

        this.metodoDiPagamentoSelezionato = metodoDiPagamentoSelezionato;
        this.ordineEffettuato = ordineEffettuato;
        this.indirizzoDiSpedizione = indirizzoDiSpedizione;
    }


    public MetodoDiPagamentoDto getMetodoDiPagamentoSelezionato() {
        return metodoDiPagamentoSelezionato;
    }

    public void setMetodoDiPagamentoSelezionato(MetodoDiPagamentoDto metodoDiPagamentoSelezionato) {
        this.metodoDiPagamentoSelezionato = metodoDiPagamentoSelezionato;
    }

    public OrdineDto getOrdineEffettuato() {
        return ordineEffettuato;
    }

    public void setOrdineEffettuato(OrdineDto ordineEffettuato) {
        this.ordineEffettuato = ordineEffettuato;
    }

    public IndirizzoDto getIndirizzoDiSpedizione() {
        return indirizzoDiSpedizione;
    }

    public void setIndirizzoDiSpedizione(IndirizzoDto indirizzoDiSpedizione) {
        this.indirizzoDiSpedizione = indirizzoDiSpedizione;
    }

}

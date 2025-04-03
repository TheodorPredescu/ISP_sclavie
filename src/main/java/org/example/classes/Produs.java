package org.example.classes;

import java.time.LocalDate;

public class Produs {

    private String numeProdus;
    private Boolean pret;
    private LocalDate dataExpirare;
    private String codIdentificator;
    private Integer stocCurent;
    protected Integer stocMaxim;
    protected Integer reducereApropiereExpirare;

    public Produs(String numeProdus, Boolean pret, LocalDate dataExpirare, String codIdentificator, Integer stocMaxim, Integer reducereApropiereExpirare) {
        this.numeProdus = numeProdus;
        this.pret = pret;
        this.dataExpirare = dataExpirare;
        this.codIdentificator = codIdentificator;
        this.stocMaxim = stocMaxim;
        this.reducereApropiereExpirare = reducereApropiereExpirare;
    }

    public Boolean cumparaProduse(Integer numarDeProduse) {

        if (this.stocCurent - numarDeProduse < 0) return false;

        this.stocCurent -= numarDeProduse;
        return true;
    }

    public Integer verificareNumarProduse () {
        return this.stocCurent;
    }

    public LocalDate verificareDataExpirare() {
        return this.dataExpirare;
    }

    public void actualizareStocMaxim() {
        this.stocCurent = this.stocMaxim;
    }
}

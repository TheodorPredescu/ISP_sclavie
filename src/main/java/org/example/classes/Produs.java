package org.example.classes;

import org.example.enumerations.ProduseNume;

import java.time.LocalDate;

public class Produs {

    private ProduseNume numeProdus;
    private Double pret;
    private LocalDate dataExpirare;
    private String codIdentificator;
    private Integer stocCurent;
    protected Integer stocMaxim;
    protected Integer reducereApropiereExpirare;

    public Produs(ProduseNume numeProdus, Double pret, LocalDate dataExpirare, String codIdentificator, Integer stocMaxim, Integer reducereApropiereExpirare) {
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
    public void afisare(){
        System.out.println("Nume produs: " + numeProdus);
        System.out.println("Pret: " + pret);
    }
}

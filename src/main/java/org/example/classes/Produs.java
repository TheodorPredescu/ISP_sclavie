package org.example.classes;

import org.example.enumerations.ProduseNume;

import java.time.LocalDate;

public class Produs {

    private ProduseNume numeProdus;
    private Double pret;
    private LocalDate dataExpirare;
    private String codIdentificator;
    private Integer stocCurent = 0;
    protected Integer stocMaxim;
    protected Float reducereApropiereExpirare;

    public Produs(ProduseNume numeProdus, Double pret, LocalDate dataExpirare, String codIdentificator, Integer stocMaxim, Float reducereApropiereExpirare) {
        this.numeProdus = numeProdus;
        this.pret = pret;
        this.dataExpirare = dataExpirare;
        this.codIdentificator = codIdentificator;
        this.stocMaxim = stocMaxim;
        this.reducereApropiereExpirare = reducereApropiereExpirare;
    }
    public ProduseNume nume(){
        return this.numeProdus;
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
        System.out.println("Data expirare: " + dataExpirare);
        System.out.println("Stoc Curent: " + stocCurent);
        System.out.println("Stoc Maxim: " + stocMaxim);
        System.out.println("Reducere: " + reducereApropiereExpirare);
    }
    public void actualizareStocCurent(Integer stocNou){
        this.stocCurent = stocNou;
    }
    public Integer getStocCurent(){
        return this.stocCurent;
    }
    public void aplicaReducereDacaExpira() {
        LocalDate azi = LocalDate.now();
        if (dataExpirare != null && dataExpirare.minusDays(5).isBefore(azi)) {
            double discount = pret * (reducereApropiereExpirare / 100);
            pret = pret - discount;
            System.out.println("Reducere aplicata produsului " + numeProdus + ". Pret nou: " + pret);
        }
    }
    public Boolean verifcareStoc(){
        return stocCurent <= 0;
    }
}

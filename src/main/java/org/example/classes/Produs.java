package org.example.classes;

import org.example.enumerations.ProduseNume;

import java.time.LocalDate;

public class Produs {

    private ProduseNume numeProdus;
    private Double pret;
    private LocalDate dataExpirare;
    private Integer stocCurent = 1;
    protected Integer stocMaxim;
    protected Float reducereApropiereExpirare;
    private Integer zileDeReducere;
    private Furnizor furnizor;

    public Produs(ProduseNume numeProdus, Double pret, LocalDate dataExpirare, Integer stocMaxim, Float reducereApropiereExpirare,Integer zileDeReducere, Furnizor furnizor) {
        this.numeProdus = numeProdus;
        this.pret = pret;
        this.dataExpirare = dataExpirare;
        this.stocMaxim = stocMaxim;
        this.reducereApropiereExpirare = reducereApropiereExpirare;
        this.zileDeReducere = zileDeReducere;
        this.furnizor = furnizor;
    }
    public ProduseNume nume(){
        return this.numeProdus;
    }
    public void afisare(){
        System.out.println("Nume produs: " + numeProdus);
        System.out.println("Pret: " + pret);
        System.out.println("Data expirare: " + dataExpirare);
        System.out.println("Stoc Curent: " + stocCurent);
        System.out.println("Stoc Maxim: " + stocMaxim);
        System.out.println("Reducere: " + reducereApropiereExpirare);
        System.out.println();
    }
    public void actualizareStocCurent(Integer stocNou){
        this.stocCurent = stocNou;
    }
    public Integer getStocCurent(){
        return this.stocCurent;
    }
    public Double getPret(){
        return this.pret;
    }
    public void aplicaReducereDacaExpira() {
        LocalDate azi = LocalDate.now();
        if (dataExpirare != null && dataExpirare.minusDays(this.zileDeReducere).isBefore(azi)) {
            double discount = pret * (reducereApropiereExpirare / 100);
            pret = pret - discount;
            System.out.println("Reducere aplicata produsului " + numeProdus + ". Pret nou: " + pret);
        }
    }
    public Boolean verifcareStoc(){
        return stocCurent <= 0;
    }
    public void setFurnizor(Furnizor furnizor){
        this.furnizor = furnizor;
    }
    public Furnizor getFurnizor(){
        return this.furnizor;
    }
    public ProduseNume getNumeProdus(){
        return this.numeProdus;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Produs produs = (Produs) obj;

        // Comparăm toate câmpurile relevante, fără stocCurent
        return numeProdus == produs.numeProdus &&
                pret.equals(produs.pret) &&
                dataExpirare.equals(produs.dataExpirare) &&
                stocMaxim.equals(produs.stocMaxim) &&
                reducereApropiereExpirare.equals(produs.reducereApropiereExpirare) &&
                zileDeReducere.equals(produs.zileDeReducere);
    }
}

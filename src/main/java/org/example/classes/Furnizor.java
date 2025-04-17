package org.example.classes;

import org.example.enumerations.FurnizoriNume;

import java.util.ArrayList;

public class Furnizor {

    private FurnizoriNume numeFirma;
    private ArrayList<Produs> listaProduse = new ArrayList<>();

    public Furnizor(FurnizoriNume numeFirma) {
        this.numeFirma = numeFirma;
    }
    public void adaugaProduse(Produs produs){
        this.listaProduse.add(produs);
    }
    public void afisare(){
        System.out.println("Nume Firma: " + numeFirma);
        System.out.println("Produse: ");
        for(Produs produs:listaProduse){
            produs.afisare();
        }
    }
    public void adaugaStocProdus(Produs produs, Integer numarProduse) {
        if (listaProduse.contains(produs)) {
            if (numarProduse < produs.stocMaxim) {
                produs.actualizareStocCurent(numarProduse);
            } else {
                System.err.println("Stocul curent este mai mare decat stocul maxim!");
            }
        }
        else {
            System.err.println("Acest furnizor nu detine acest produs!");
        }
    }
    // Functie acceptare si contra oferta
}

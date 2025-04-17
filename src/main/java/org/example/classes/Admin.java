package org.example.classes;

import org.example.enumerations.FurnizoriNume;

public class Admin extends User {
    public static void modificareReducereProdus(Produs produs, Integer stocMaxim, Integer reducereApropiereExpirare) {
        if (reducereApropiereExpirare >= 0 && reducereApropiereExpirare <= 100) {
            produs.reducereApropiereExpirare = reducereApropiereExpirare;
        }else {
            System.err.println("Setare incorecta a reducerei pentru apropierea datei de expirare");
        }

        if (stocMaxim != null && stocMaxim > 0){
            produs.stocMaxim = stocMaxim;
        }else {
            System.err.println("Setare stocMaxim cu o valoare invalida!");
        }
    }
    // Functie acceptare si contra oferta
    public void confirmareComanda(){}
    public void modificareComanda(){}
}

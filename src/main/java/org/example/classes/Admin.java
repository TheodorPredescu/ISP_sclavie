package org.example.classes;

import org.example.User;
import org.example.enumerations.FurnizoriNume;
import org.example.enumerations.ProduseNume;

public class Admin extends User {
    void modificareReducereProdus(Produs produs, Integer stocMaxim, Integer reducereApropiereExpirare) {
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

    //Aici nush sigur daca e chiar ok, am adaugat enumeratii pentru nume furnizor si nume produse dar nu sunt sigur ca e cea mai ok varianta;
    //va mai ganditi si voi
    ComandaProdus solicitareComanda(Produs produs, FurnizoriNume furnizor, Double pret) {
        // ComandaProdus comanda_noua = new ComandaProdus(produs, furnizor, );
        return null;
    }
}

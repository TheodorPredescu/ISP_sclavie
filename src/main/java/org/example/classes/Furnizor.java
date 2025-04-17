package org.example.classes;

import org.example.enumerations.FurnizoriNume;

import java.util.ArrayList;

public class Furnizor {

    private FurnizoriNume numeFirma;
    private ArrayList<Produs> listaProduse;

    public Furnizor(FurnizoriNume numeFirma) {
        this.numeFirma = numeFirma;
    }



}

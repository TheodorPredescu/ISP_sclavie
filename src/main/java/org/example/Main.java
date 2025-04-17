package org.example;

import org.example.classes.Furnizor;
import org.example.classes.Produs;
import org.example.enumerations.FurnizoriNume;
import org.example.enumerations.ProduseNume;
import org.example.classes.Admin;

import java.awt.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Furnizor primuFurnizor = new Furnizor(FurnizoriNume.NESTLE);
        Produs produs1 = new Produs(ProduseNume.BRANZA,25.5, LocalDate.parse("2025-03-01") ,"696969",69,10);
        Produs produs2 = new Produs(ProduseNume.LAPTE,13.69, LocalDate.parse("2025-03-05") ,"696669",55,15);
        primuFurnizor.adaugaProduse(produs1);
        primuFurnizor.adaugaProduse(produs2);
        primuFurnizor.adaugaStocProdus(produs1,68);
        primuFurnizor.adaugaStocProdus(produs2,54);
        primuFurnizor.afisare();
        Admin.modificareReducereProdus(produs1,70,15);
        System.out.println("-----------------------------");
        primuFurnizor.afisare();
    }
}
package org.example;

import org.example.classes.*;
import org.example.enumerations.FurnizoriNume;
import org.example.enumerations.ProduseNume;

import java.awt.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Furnizor primuFurnizor = new Furnizor(FurnizoriNume.NESTLE);
        Produs produs1 = new Produs(ProduseNume.BRANZA,25.5, LocalDate.parse("2025-03-01") ,"696969",69,10F);
        Produs produs2 = new Produs(ProduseNume.LAPTE,13.69, LocalDate.parse("2025-03-05") ,"696669",55,15F);
        primuFurnizor.adaugaProduse(produs1);
        primuFurnizor.adaugaProduse(produs2);
        Magazin magazinulMeu = new Magazin();
        magazinulMeu.adaugaProduse(produs1);
        magazinulMeu.adaugaProduse(produs2);
        primuFurnizor.adaugaStocProdus(magazinulMeu.getProdus(0),50);
        magazinulMeu.aplicareReduceriProduseAproapeExpirare();
        magazinulMeu.afisare();
        System.out.println("------------------------------");
        Admin administrator = new Admin("Theo","Zeciu","test123@gmail.com","parola",69.420);
        Client client = new Client("Maria","Ioana","mariaioanabun@gmail.com","parolaa",77.25);
        while (true) {
            client.achizitieProdus(magazinulMeu.getProdus(0), 25);
            System.out.println("------------------------------");
            magazinulMeu.afisare();
            try {
                administrator.verificareStoc(magazinulMeu.getProdus(0));
                Thread.sleep(10000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
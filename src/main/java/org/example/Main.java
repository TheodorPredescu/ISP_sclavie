package org.example;

import org.example.classes.*;
import org.example.enumerations.FurnizoriNume;
import org.example.enumerations.ProduseNume;

import java.awt.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Furnizor primuFurnizor = new Furnizor(FurnizoriNume.NESTLE);
        Produs produs1 = new Produs(ProduseNume.BRANZA,1.0, LocalDate.parse("2025-07-10") ,69,10F,3, primuFurnizor);
        Produs produs2 = new Produs(ProduseNume.LAPTE,13.69, LocalDate.parse("2025-03-05") ,55,15F,5, primuFurnizor);
        primuFurnizor.adaugaProduse(produs1);
        primuFurnizor.adaugaProduse(produs2);
        Magazin magazinulMeu = new Magazin();
        magazinulMeu.adaugaProduse(produs1);
        magazinulMeu.adaugaProduse(produs2);
        primuFurnizor.adaugaStocProdus(magazinulMeu.getProdus(0),5);
        magazinulMeu.aplicareReduceriProduseAproapeExpirare();
        magazinulMeu.afisare();
        Admin administrator = new Admin("Theo","Zeciu","test123@gmail.com","parola",69.420);
        magazinulMeu.setAdministrator(administrator);
        Client client = new Client("Maria","Ioana","mariaioanabun@gmail.com","parolaa",125.5);
//        while (administrator.verificareStoc(magazinulMeu.getProdus(0))) {
//            if(client.adaugaInCos(magazinulMeu.getProdus(0), 1,magazinulMeu)) {
//                System.out.println("------------------------------");
//                magazinulMeu.afisare();
//            }
//            else{
//                System.out.println("Fonduri insuficiente!");
//                break;
//            }
//        }
        client.adaugaInCos(magazinulMeu.getProdus(0), 25,magazinulMeu);
        System.out.println("------------------------------");
        magazinulMeu.afisare();
    }
}
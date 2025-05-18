package org.example.classes;

import org.example.enumerations.FurnizoriNume;
import org.example.enumerations.ProduseNume;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    Furnizor furnizor;
    Magazin magazin;
    int numarDeProduse = 10;

    Produs produs1;
    Produs produs2;
    Produs produs3;
    Produs produs4;

    private void setup() {
        furnizor = new Furnizor(FurnizoriNume.AMAZON_SUPPLY);
        this.magazin = new Magazin();

        //for (int i = 0; i < numarDeProduse; ++i) {
            furnizor.adaugaProduse(new Produs(ProduseNume.BRANZA, 1.1, LocalDate.parse("2025-07-10"), 69, 10f, 3, furnizor));
            furnizor.adaugaProduse(new Produs(ProduseNume.LAPTE, 13.69, LocalDate.parse("2025-03-05"), 55, 15f, 5, furnizor));
        //}

        produs1 = new Produs(ProduseNume.BRANZA,1.0, LocalDate.parse("2025-07-10") ,69,10F,3, furnizor);
        produs2 = new Produs(ProduseNume.LAPTE,13.69, LocalDate.parse("2025-03-05") ,55,15F,5, furnizor);
        produs3 = new Produs(ProduseNume.BRANZA,1.0, LocalDate.parse("2025-07-10") ,69,10F,3, furnizor);
        produs4 = new Produs(ProduseNume.LAPTE,13.69, LocalDate.parse("2025-03-05") ,55,15F,5, furnizor);

        magazin.adaugaProduse(produs1);
        magazin.adaugaProduse(produs2);
        magazin.adaugaProduse(produs3);
        magazin.adaugaProduse(produs4);

        Admin administrator = new Admin("Theo","Zeciu","test123@gmail.com","parola",69.420);
        magazin.setAdministrator(administrator);

        magazin.aplicareReduceriProduseAproapeExpirare();
    }

    @Test
    void achizitieSimplaProdus() {

       setup();

        Client client = new Client("Theodor", "Predescu", "testare@gmail.com", "parola", 20d);
        assertNull(client.adaugaInCos(null, 2, magazin));
        assertNull(client.adaugaInCos(produs1, null, magazin));
        assertNull(client.adaugaInCos(produs1, 2, null));

        Boolean sol2 = client.adaugaInCos(produs1, 1, magazin);
        assertTrue(sol2);

         //Ramane fara bani
        Boolean sol3 = client.adaugaInCos(produs2, 2, magazin);
        assertFalse(sol3);

    }

    @Test
    void achizitieCuRealimentareMagazin(){

        System.out.println("------------------------------");
        System.out.println("------------------------------");
        setup();

        //Se da comanda de mai multe produse decat sunt
        Client client2 = new Client("Theodor", "Predescu", "testare@gmail.com", "parola", 4000d);
        System.out.println("S-a dat comanda de " + produs3.getNumeProdus());
        assertFalse(client2.adaugaInCos(magazin.getProdus(0), 5, magazin));

        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("Nume produs: " + magazin.getProdus(0).getNumeProdus() + "\nScoc curent: " + magazin.getProdus(0).getStocCurent());
        System.out.println("Scoc maxim: " + magazin.getProdus(0).getStocMaxim());
        System.out.println("S-a dat comanda de " + produs3.getNumeProdus());
        assertTrue(client2.adaugaInCos(magazin.getProdus(0), 5, magazin));
    }
}
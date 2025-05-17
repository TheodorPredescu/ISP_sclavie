package org.example.classes;

import org.example.enumerations.FurnizoriNume;
import org.example.enumerations.ProduseNume;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void achizitieProdus() {

        Furnizor furnizor = new Furnizor(FurnizoriNume.AMAZON_SUPPLY);
        int numarDeProduse = 10;

        for (int i = 0; i < numarDeProduse; ++i) {
            furnizor.adaugaProduse(new Produs(ProduseNume.BRANZA, 1.1, LocalDate.parse("2025-07-10"), 69, 10f, 3, furnizor));
            furnizor.adaugaProduse(new Produs(ProduseNume.LAPTE, 13.69, LocalDate.parse("2025-03-05"), 55, 15f, 5, furnizor));
        }

        Produs produs1 = new Produs(ProduseNume.BRANZA,1.0, LocalDate.parse("2025-07-10") ,69,10F,3, furnizor);
        Produs produs2 = new Produs(ProduseNume.LAPTE,13.69, LocalDate.parse("2025-03-05") ,55,15F,5, furnizor);
        Produs produs3 = new Produs(ProduseNume.BRANZA,1.0, LocalDate.parse("2025-07-10") ,69,10F,3, furnizor);
        Produs produs4 = new Produs(ProduseNume.LAPTE,13.69, LocalDate.parse("2025-03-05") ,55,15F,5, furnizor);

        Magazin magazin = new Magazin();
        magazin.adaugaProduse(produs1);
        magazin.adaugaProduse(produs2);
        magazin.adaugaProduse(produs3);
        magazin.adaugaProduse(produs4);

        Admin administrator = new Admin("Theo","Zeciu","test123@gmail.com","parola",69.420);
        magazin.setAdministrator(administrator);

        Client client = new Client("Theodor", "Predescu", "testare@gmail.com", "parola", 20d);
        assertNull(client.adaugaInCos(null, 2, magazin));

        Boolean sol2 = client.adaugaInCos(produs1, 1, magazin);
        assertTrue(sol2);

         //Ramane fara bani
        Boolean sol3 = client.adaugaInCos(produs2, 2, magazin);
        assertFalse(sol3);

        Client client2 = new Client("Theodor", "Predescu", "testare@gmail.com", "parola", 40d);
        assertTrue(client2.adaugaInCos(produs4, 5, magazin));

    }
}
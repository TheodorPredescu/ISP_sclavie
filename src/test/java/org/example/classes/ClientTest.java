package org.example.classes;

import org.example.enumerations.ProduseNume;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void achizitieProdus() {
        Produs produs1 = new Produs(ProduseNume.BRANZA,1.0, LocalDate.parse("2025-07-10") ,69,10F,3);
        Produs produs2 = new Produs(ProduseNume.LAPTE,13.69, LocalDate.parse("2025-03-05") ,55,15F,5);
        Produs produs3 = new Produs(ProduseNume.BRANZA,1.0, LocalDate.parse("2025-07-10") ,69,10F,3);
        Produs produs4 = new Produs(ProduseNume.LAPTE,13.69, LocalDate.parse("2025-03-05") ,55,15F,5);

        Magazin magazin = new Magazin();
        magazin.adaugaProduse(produs1);
        magazin.adaugaProduse(produs2);

        Admin administrator = new Admin("Theo","Zeciu","test123@gmail.com","parola",69.420);
        magazin.setAdministrator(administrator);

        Client client = new Client("Theodor", "Predescu", "testare@gmail.com", "parola", 20d);
        assertNull(client.adaugaInCos(null, 2, magazin));

        Boolean sol2 = client.adaugaInCos(produs1, 1, magazin);
        assertTrue(sol2);
//
        Boolean sol3 = client.adaugaInCos(produs1, 2, magazin);
//        assertTrue(sol3);
    }
}
package org.example.classes;

import org.example.enumerations.FurnizoriNume;
import org.example.enumerations.ProduseNume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FurnizorTest {

    private Furnizor furnizor;
    private Produs produs;
    private ComandaProdus comanda;

    @BeforeEach
    void setUp() {
        furnizor = new Furnizor(FurnizoriNume.NESTLE);
        Produs produs = new Produs(ProduseNume.BRANZA,1.0, LocalDate.parse("2025-07-10") ,69,10F,3, furnizor); // presupunem un constructor (nume, pret, stocMaxim)
        produs.setFurnizor(furnizor);

        furnizor.adaugaProduse(produs);

        Admin admin = new Admin("Theo","Zeciu","test123@gmail.com","parola",69.420);
        comanda = new ComandaProdus(produs,furnizor,produs.stocMaxim,produs.getPret(),false,false,admin);
    }

    @Test
    void testAdaugaProduse() {
        ArrayList<Produs> produse = produs.getFurnizor().listaProduse;
        assertTrue(produse.contains(produs), "Produsul ar trebui sa fie adaugat la furnizor");
        assertEquals(furnizor, produs.getFurnizor());
    }

    @Test
    void testAdaugaStocProdus_Corect() {
        furnizor.adaugaStocProdus(produs, 50);
        assertEquals(50, produs.getStocCurent());
    }

    @Test
    void testAdaugaStocProdus_StocDepasit() {
        furnizor.adaugaStocProdus(produs, 150); // stocMaxim este 100
        assertNotEquals(150, produs.getStocCurent());
    }

    @Test
    void testAdaugaStocProdus_ProdusInexistent() {
        Produs altProdus = new Produs(ProduseNume.LAPTE,13.69, LocalDate.parse("2025-03-05") ,55,15F,5, furnizor);
        furnizor.adaugaStocProdus(altProdus, 10);
        assertEquals(0, altProdus.getStocCurent());
    }

    @Test
    void testConfirmareComanda_Acceptata() {
        comanda.setPretCumparare(3.0); // mai mic decat 80% din pretul produsului (5.0)
        furnizor.confirmareComanda(comanda);
        assertTrue(comanda.isCerereProdusFurnizor());
        assertEquals(10, produs.getStocCurent());
    }

    @Test
    void testConfirmareComanda_Refuzata() {
        comanda.setPretCumparare(4.8); // aproape de pretul de baza
        furnizor.confirmareComanda(comanda);
        assertFalse(comanda.isCerereProdusFurnizor());
    }

    @Test
    void testModificareComanda() {
        furnizor.modificareComanda(comanda, 4.2);
        assertEquals(4.2, comanda.getPretCumparare());
    }
}

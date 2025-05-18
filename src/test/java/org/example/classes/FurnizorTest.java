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

    // Initializeaza un furnizor, un produs asociat si o comanda cu admin inainte de fiecare test
    @BeforeEach
    void setUp() {
        furnizor = new Furnizor(FurnizoriNume.NESTLE);
        produs = new Produs(ProduseNume.BRANZA,5.0, LocalDate.parse("2025-07-10") ,69,10F,3, furnizor);

        furnizor.adaugaProduse(produs);

        Admin admin = new Admin("Theo", "Zeciu", "test123@gmail.com", "parola", 69.420);
        comanda = new ComandaProdus(produs,furnizor,produs.stocMaxim,produs.getPret(),false,false,admin);
    }

    @Test
    void testAdaugaProduse() {
        // Verifica daca produsul a fost adaugat corect in lista de produse a furnizorului
        ArrayList<Produs> produse = produs.getFurnizor().listaProduse;
        assertTrue(produse.contains(produs), "Produsul ar trebui sa fie adaugat la furnizor");
        assertEquals(furnizor, produs.getFurnizor());
    }

    @Test
    void testAdaugaStocProdus_Corect() {
        // Adauga un stoc valid produsului si verifica daca stocul curent s-a actualizat corect
        furnizor.adaugaStocProdus(produs, 5);
        assertEquals(5, produs.getStocCurent());
    }

    @Test
    void testAdaugaStocProdus_StocDepasit() {
        // Incearca sa adauge un stoc mai mare decat stocul maxim permis
        furnizor.adaugaStocProdus(produs, 150);
        assertNotEquals(150, produs.getStocCurent());
    }

    @Test
    void testAdaugaStocProdus_ProdusInexistent() {
        // Creeaza un produs care nu apartine furnizorului si incearca sa adauge stoc
        // Verifica ca metoda returneaza false pentru ca produsul nu este in lista furnizorului
        Produs altProdus = new Produs(ProduseNume.LAPTE, 13.69, LocalDate.parse("2025-03-05"), 55, 15F, 5, furnizor);
        Boolean rezultat = furnizor.adaugaStocProdus(altProdus, 10);
        assertFalse(rezultat, "Adaugarea stocului ar trebui sa esueze pentru un produs care nu apartine furnizorului.");
    }


    @Test
    void testConfirmareComanda_Acceptata() {
        // Seteaza pretul comenzii peste pragul de 80% din pretul produsului
        // Apeleaza confirmarea comenzii la furnizor si verifica ca cererea a fost acceptata
        comanda.setPretCumparare(4.1); // >= 80% din pret (5.0)
        furnizor.confirmareComanda(comanda);
        assertTrue(comanda.isCerereProdusFurnizor(), "Comanda ar trebui acceptată");
    }

    @Test
    void testConfirmareComanda_Refuzata() {
        // Seteaza pretul comenzii sub pragul de 80% din pretul produsului
        // Dupa contraoferta si verificari, cererea trebuie sa fie refuzata
        comanda.setPretCumparare(3.0); // < 80% din pret (5.0)
        furnizor.confirmareComanda(comanda);
        assertFalse(comanda.isCerereProdusFurnizor(), "Comanda ar trebui refuzată deoarece contraoferta e tot sub 80%");
    }

    @Test
    void testConfirmareComanda_CuContraofertaAcceptata() {
        // Seteaza pretul comenzii putin sub pragul de 80% dar dupa negocieri pretul final
        // este modificat de Admin si furnizor pana se ajunge la o contraoferta acceptata
        comanda.setPretCumparare(3.9);
        furnizor.confirmareComanda(comanda);
        double pretFinalAsteptat = 3.6855;
        assertEquals(pretFinalAsteptat, comanda.getPretCumparare(), 0.01);
    }



    @Test
    void testModificareComanda() {
        // Verifica daca metoda modificareComanda modifica corect pretul de cumparare al comenzii
        furnizor.modificareComanda(comanda, 4.2);
        assertEquals(4.2, comanda.getPretCumparare());
    }
}

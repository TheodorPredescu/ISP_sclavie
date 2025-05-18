package org.example.classes;
import org.example.enumerations.FurnizoriNume;
import org.example.enumerations.ProduseNume;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {

    @Test
    public void testConfirmareComandaAcceptata() {
        // Setup
        Admin admin = new Admin("Ana", "Ionescu", "ana@mail.com", "parola123", 1000.0);
        Furnizor furnizor = new Furnizor(FurnizoriNume.NESTLE);
        Produs produs = new Produs(
                ProduseNume.LAPTE, 10.0,
                LocalDate.now().plusDays(10),
                100, 10.0f, 3, furnizor
        );
        furnizor.adaugaProduse(produs);

        // Pretul este 7.5 -> sub 8.0 => comanda acceptata
        ComandaProdus comanda = new ComandaProdus(produs, furnizor, 10, 7.5, false, false, admin);

        // Act
        admin.confirmareComanda(comanda);

        // Assert
        assertTrue(comanda.isCerereProdusFurnizor());
        assertEquals(7.5, comanda.getPretCumparare());
        assertEquals(produs, comanda.getProdus());
    }

    @Test
    public void testConfirmareComandaRefuzataSiContraOferta() {
        // Setup
        Admin admin = new Admin("Ion", "Popescu", "ion@mail.com", "parola123", 2000.0);
        Furnizor furnizor = new Furnizor(FurnizoriNume.COCA_COLA);
        Produs produs = new Produs(
                ProduseNume.PAINE, 10.0,
                LocalDate.now().plusDays(10),
                100, 5.0f, 3, furnizor
        );
        furnizor.adaugaProduse(produs);

        // Pretul este 9.5 -> peste 8.0 => contraoferta
        ComandaProdus comanda = new ComandaProdus(produs, furnizor, 10, 9.5, false, false, admin);

        // Act
        admin.confirmareComanda(comanda);

        // Assert
        // Pretul se va modifica in 9.5 -10% = 8.55
        assertEquals(8.55, comanda.getPretCumparare());
        assertTrue(comanda.isCerereProdusFurnizor());
    }

    @Test
    public void testConfirmareComandaRespinsaTotal() {
        // Setup
        Admin admin = new Admin("Maria", "Georgescu", "maria@mail.com", "parola123", 5000.0);
        Furnizor furnizor = new Furnizor(FurnizoriNume.PEPSICO);
        Produs produs = new Produs(
                ProduseNume.CASCAVAL, 10.0,
                LocalDate.now().plusDays(10),
                100, 5.0f, 3, furnizor
        );
        furnizor.adaugaProduse(produs);

        // Pret initial mare -> contraoferta insuficienta
        ComandaProdus comanda = new ComandaProdus(produs, furnizor, 10, 7.4, false, false, admin);

        // Act
        admin.confirmareComanda(comanda);

        // Assert
        assertTrue(comanda.isCerereProdusFurnizor());
        assertEquals(7.4, comanda.getPretCumparare(), 0.001);
    }
    @Test
    public void testConfirmareComandaPretLimitaAcceptare() {
        Admin admin = new Admin("Andrei", "Pop", "andrei@mail.com", "parola123", 3000.0);
        Furnizor furnizor = new Furnizor(FurnizoriNume.NESTLE);
        Produs produs = new Produs(
                ProduseNume.FAINA, 10.0,
                LocalDate.now().plusDays(10),
                100, 5.0f, 3, furnizor
        );
        furnizor.adaugaProduse(produs);

        ComandaProdus comanda = new ComandaProdus(produs, furnizor, 10, 8.0, false, false, admin);

        admin.confirmareComanda(comanda);

        assertTrue(comanda.isCerereProdusFurnizor(), "Comanda ar trebui acceptata direct");
        assertEquals(8.0, comanda.getPretCumparare(), 0.001);
    }
    @Test
    public void testAdaugareProdusInMagazinDupaComandaAcceptata() {
        Magazin magazin = new Magazin();
        Admin admin = new Admin("Alina", "Dobre", "alina@mail.com", "parola123", 5000.0);
        magazin.setAdministrator(admin);

        Furnizor furnizor = new Furnizor(FurnizoriNume.COCA_COLA);
        Produs produs = new Produs(
                ProduseNume.PAINE, 10.0,
                LocalDate.now().plusDays(10),
                0, 5.0f, 3, furnizor
        );
        furnizor.adaugaProduse(produs);

        ComandaProdus comanda = new ComandaProdus(produs, furnizor, 10, 7.0, false, false, admin);

        admin.confirmareComanda(comanda);
        magazin.adaugaProduse(produs);

        assertEquals(1, magazin.getNumarProduse(ProduseNume.PAINE));
    }


}
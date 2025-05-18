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
        // Pretul se va modifica in 9.5 + 5% = 9.975 -> peste 8.0 => acceptat de admin
        assertEquals(9.975, comanda.getPretCumparare());
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
        // ex: 7.4 + 5% = 7.77 < 8.0 => respins complet
        ComandaProdus comanda = new ComandaProdus(produs, furnizor, 10, 7.4, false, false, admin);

        // Act
        admin.confirmareComanda(comanda);

        // Assert
        assertFalse(comanda.isCerereProdusFurnizor());
        assertEquals(7.77, comanda.getPretCumparare(), 0.001);
    }
}
package org.example.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandaProdus {
    private Produs produs;
    private Furnizor furnizor;
    private Integer numarBucatiComanda;
    private Double pretCumparare;
    private LocalDateTime dataCerere;
    private LocalDate dataLivrare;
    private Boolean cerereProdusa;

    public ComandaProdus(Produs produs, Furnizor furnizor, Integer numarBucatiComanda, Double pretCumparare, LocalDateTime dataCerere, LocalDate dataLivrare, Boolean cerereProdusa) {
        this.produs = produs;
        this.furnizor = furnizor;
        this.numarBucatiComanda = numarBucatiComanda;
        this.pretCumparare = pretCumparare;
        this.dataCerere = dataCerere;
        this.dataLivrare = dataLivrare;
        this.cerereProdusa = cerereProdusa;
    }
}

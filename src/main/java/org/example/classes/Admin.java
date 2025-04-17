package org.example.classes;

import org.example.enumerations.FurnizoriNume;

import java.util.Scanner;

public class Admin extends User {
    public static void modificareReducereProdus(Produs produs, Integer stocMaxim, Float reducereApropiereExpirare) {
        if (reducereApropiereExpirare >= 0 && reducereApropiereExpirare <= 100) {
            produs.reducereApropiereExpirare = reducereApropiereExpirare;
        }else {
            System.err.println("Setare incorecta a reducerei pentru apropierea datei de expirare");
        }

        if (stocMaxim != null && stocMaxim > 0){
            produs.stocMaxim = stocMaxim;
        }else {
            System.err.println("Setare stocMaxim cu o valoare invalida!");
        }
    }
    // Functie acceptare si contra oferta
    public void confirmareComanda(ComandaProdus comanda){
        Boolean worked = false;

        while (!worked){

            System.out.println();
            System.out.println("Cerere noua!");
            System.out.println();
            comanda.afisare();
            System.out.print("Se necesita confirmarea unei comenzi(y/n): ");
            Scanner scanner = new Scanner(System.in);
            String instr = scanner.nextLine();
            switch (instr) {
                case "y":
                    comanda.setCerereProdusAdmin(true);
                    worked = true;
                    System.out.println("Comanda trimisa.");
                    break;
                case "n":
                    comanda.setCerereProdusAdmin(false);
                    Double pret = null;
                    boolean redo_command = true;

                    while (redo_command) {
                        redo_command = false;
                        try{
                            System.out.print("Pret propus: ");
                            String x = scanner.nextLine();
                            pret = Double.valueOf(x);
                        }catch (Exception e) {
                            System.out.println("Eroare de citire! Reincearca;");
                            redo_command = true;
                        }
                    }
                    modificareComanda(comanda, pret);
                    break;
                default:
                    System.out.println("Comanda invalida, reincearca!");
                    System.out.println();
                    break;
            }
        }
    }
    public void modificareComanda(ComandaProdus comanda, Double pret){
        comanda.setPretCumparare(pret);
    }
}

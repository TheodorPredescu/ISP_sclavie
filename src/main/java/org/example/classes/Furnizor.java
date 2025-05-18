package org.example.classes;

import org.example.enumerations.FurnizoriNume;

import java.util.ArrayList;
import java.util.Scanner;

public class Furnizor {

    private FurnizoriNume numeFirma;
    public ArrayList<Produs> listaProduse = new ArrayList<Produs>();

    public Furnizor(FurnizoriNume numeFirma) {
        this.numeFirma = numeFirma;
    }
    public void adaugaProduse(Produs produs){
        this.listaProduse.add(produs);
        produs.setFurnizor(this);
    }
    public FurnizoriNume getNumeFirma(){
        return numeFirma;
    }
    public void afisare(){
        System.out.println("Nume Firma: " + numeFirma);
        System.out.println("Produse: ");
        for(Produs produs:listaProduse){
            produs.afisare();
        }
    }
    public Boolean adaugaStocProdus(Produs produs, Integer numarProduse) {

        System.out.println("In stoc furnizor: ");
        for (Produs prod : listaProduse) {
            System.out.println("Produs: " + prod.getNumeProdus() + " numar produse: " + prod.getStocCurent());
        }
        System.out.println(listaProduse.contains(produs));
        if (listaProduse.contains(produs)) {
            if (numarProduse <= produs.stocMaxim) {
                produs.actualizareStocCurent(numarProduse);
                return true;
            } else {
                System.err.println("Stocul curent este mai mare decat stocul maxim!");
                return false;
            }
        }
        else {
            System.err.println("Acest furnizor nu detine acest produs!");
            return false;
        }
    }

    // Functie acceptare si contra oferta
    /*public void confirmareComanda(ComandaProdus comanda) {
            System.out.println();
            System.out.println("Cerere noua catre Furnizor!");
            System.out.println();
            comanda.afisare();
            System.out.print("Se necesita confirmarea unei oferte de catre Furnizor(y/n): ");
            Scanner scanner = new Scanner(System.in);
            String instr = scanner.nextLine();
            comanda.setCerereProdusAdmin(true);
            switch (instr) {
                case "y":
                    comanda.setCerereProdusFurnizor(true);
                    System.out.println("Comanda confirmata Furnizor.");
                    comanda.getFurnizor().adaugaStocProdus(comanda.getProdus(),comanda.getNumarBucatiComanda());
                    break;
                case "n":
                    comanda.setCerereProdusFurnizor(false);
                    Double pret = null;
                    boolean redo_command = true;

                    while (redo_command) {
                        redo_command = false;
                        try {
                            System.out.print("Pret propus de la Furnizor: ");
                            String x = scanner.nextLine();
                            pret = Double.valueOf(x);
                        } catch (Exception e) {
                            System.out.println("Eroare de citire! Reincearca;");
                            redo_command = true;
                        }
                    }
                    modificareComanda(comanda, pret);
                    comanda.getAdmin().confirmareComanda(comanda);
                    break;
                default:
                    System.out.println("Comanda invalida, reincearca!");
                    System.out.println();
                    break;
            }
    }*/

    public void confirmareComanda(ComandaProdus comanda){
        System.out.println("------------------------------");
        System.out.println("Cerere noua catre Furnizor!");
        System.out.println();
        comanda.afisare();
        comanda.setCerereProdusAdmin(true);
        if (comanda.getPretCumparare() >= comanda.getProdus().getPret()*0.8) {
            System.out.println("Comanda acceptata");
            comanda.setCerereProdusFurnizor(true);
            comanda.getFurnizor().adaugaStocProdus(comanda.getProdus(),comanda.getNumarBucatiComanda());
        }
        else {
            comanda.setCerereProdusFurnizor(false);
            Double pret = comanda.getPretCumparare() + comanda.getPretCumparare()*0.05;
            if(pret < comanda.getProdus().getPret()*0.8) {
                System.out.println("Oferta refuzata!");
                return;
            }
            System.out.println("Pret propus de la Furnizor: " + pret);
            System.out.println();
            modificareComanda(comanda, pret);
            comanda.getAdmin().confirmareComanda(comanda);
        }
    }
    public void modificareComanda(ComandaProdus comanda, Double pret) {
        comanda.setPretCumparare(pret);
    }
}

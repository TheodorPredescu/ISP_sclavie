package org.example.classes;

public class Client extends User{
    public static void achizitieProdus(Produs produs, Integer cantitate){
        if(produs.getStocCurent() > cantitate){
            Integer stocNou = produs.getStocCurent() - cantitate;
            produs.actualizareStocCurent(stocNou);
        }
        else {
            System.err.println("Incercati sa achizionati mai multe produse decat cele existente pe stoc");
        }
    }
}

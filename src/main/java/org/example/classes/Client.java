package org.example.classes;

public class Client extends User{
    public Client(String first_name,String last_name,String mail,String parola,Double buget){
        super(first_name,last_name,mail,parola,buget);
    }
    public void achizitieProdus(Produs produs, Integer cantitate){
        if(produs.getStocCurent() >= cantitate){
            Integer stocNou = produs.getStocCurent() - cantitate;
            produs.actualizareStocCurent(stocNou);
        }
        else {
            System.err.println("Eroare Client: ");
            System.err.println("Incercati sa achizionati mai multe produse decat cele existente pe stoc");
        }
    }
}

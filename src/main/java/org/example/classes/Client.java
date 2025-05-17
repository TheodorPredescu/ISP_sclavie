package org.example.classes;

import java.util.ArrayList;

public class Client extends User{
    private ArrayList<Produs> cos = new ArrayList<Produs>();
    public Client(String first_name,String last_name,String mail,String parola,Double buget){
        super(first_name,last_name,mail,parola,buget);
    }
    private Boolean achizitieProdus(Produs produs, Integer cantitate,Magazin magazin) {
        System.out.println(magazin.getNumarProduse(produs.getNumeProdus()));
        if(magazin.getNumarProduse(produs.getNumeProdus()) >= cantitate){
            produs.actualizareStocCurent(produs.getStocCurent() - cantitate);
            System.out.println("-Au ramas " + produs.getStocCurent() + " produse de " + produs.getNumeProdus());
            return true;
        } else {
            System.out.println("Eroare Client: ");
            System.out.println("Incercati sa achizionati mai multe produse decat cele existente pe stoc");
            if (magazin.getAdministrator() == null || produs.getFurnizor() == null) return null;
            magazin.reincarcareStoc(produs,produs.getFurnizor(),magazin.getAdministrator());
            return false;
        }
    }
    public Boolean adaugaInCos(Produs produs, Integer cantitate, Magazin magazin){
        if (produs == null || cantitate == null || magazin == null) return null;

        Double sum = 0.0;
        sum += (produs.getPret()*cantitate);
        if(buget >= sum){

            Boolean worked = achizitieProdus(produs,cantitate,magazin);
            if (worked == null ) return null;
            if(worked) {
                buget -= sum;
                cos.add(produs);
                return true;
            } else
                return false;
        } else {
            System.out.println("Nu mai sunt destui bani");
            return false;
        }
    }
}

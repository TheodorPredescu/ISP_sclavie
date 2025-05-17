package org.example.classes;

import org.example.enumerations.ProduseNume;

import java.util.ArrayList;

public class Magazin {
    private ArrayList<Produs> produse = new ArrayList<Produs>();
    private Admin administrator = null;
    public void adaugaProduse(Produs produs){
        this.produse.add(produs);
    }
    public void afisare(){
        System.out.println("Produse din magazin: ");
        for(Produs produs:produse){
            produs.afisare();
        }
    }
    public Produs getProdus(Integer pos){
        return produse.get(pos);
    }
    public void aplicareReduceriProduseAproapeExpirare() {
        for (Produs produs : produse) {
            produs.aplicaReducereDacaExpira();
        }
    }
    public void reincarcareStoc(Produs produs,Furnizor furnizor, Admin administrator){
        ComandaProdus produse = new ComandaProdus(produs,furnizor,produs.stocMaxim,produs.getPret(),false,false,administrator);
        furnizor.confirmareComanda(produse);
    }
    public void setAdministrator(Admin administrator){
        this.administrator = administrator;
    }
    public Admin getAdministrator(){
        return this.administrator;
    }

    public Integer getNumarProduse(ProduseNume numeProdus){
        Integer numarProduse = 0;

        for (Produs prod : produse) {
            if (prod.getNumeProdus().compareTo(numeProdus) == 0) numarProduse++;
        }

        return numarProduse;
    }
}

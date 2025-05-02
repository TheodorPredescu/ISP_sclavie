package org.example.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandaProdus {
    private Produs produs;
    private Furnizor furnizor;
    private Integer numarBucatiComanda;
    private Double pretCumparare;
    private Boolean cerereProdusFurnizor;
    private Boolean cerereProdusAdmin;
    private Admin admin;


    public ComandaProdus(Produs produs, Furnizor furnizor, Integer numarBucatiComanda, Double pretCumparare, Boolean cerereProdusFurnizor, Boolean cerereProdusAdmin, Admin admin) {
        this.produs = produs;
        this.furnizor = furnizor;
        this.numarBucatiComanda = numarBucatiComanda;
        this.pretCumparare = pretCumparare;
        this.cerereProdusAdmin = cerereProdusAdmin;
        this.cerereProdusFurnizor = cerereProdusFurnizor;
        this.admin = admin;
    }

    public void setPretCumparare(Double pret) {
        this.pretCumparare = pret;
    }
    public void setCerereProdusFurnizor(Boolean val){
        cerereProdusFurnizor = val;
    }
    public void setCerereProdusAdmin(Boolean val){
        cerereProdusAdmin = val;
    }
    public Furnizor getFurnizor(){
        return this.furnizor;
    }
    public Admin getAdmin(){
        return this.admin;
    }

    public void afisare(){
        System.out.println("Produs: " + this.produs.nume());
        System.out.println("Furnizor: " + this.furnizor.getNumeFirma());
        System.out.println("Cantitate: " + this.numarBucatiComanda);
        System.out.println("Pret: " + this.pretCumparare);
    }

    public Produs getProdus() {
        return produs;
    }
    public Integer getNumarBucatiComanda(){
        return numarBucatiComanda;
    }
}

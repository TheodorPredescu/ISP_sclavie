package org.example.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandaProdus {
    private Produs produs;
    private Furnizor furnizor;
    private Integer numarBucatiComanda;
    private Double pretCumparare;
    private LocalDate dataCerere;
    private LocalDate dataLivrare;
    private Boolean cerereProdusFurnizor;
    private Boolean cerereProdusAdmin;
    private Admin admin;


    public ComandaProdus(Produs produs, Furnizor furnizor, Integer numarBucatiComanda, Double pretCumparare, LocalDate dataCerere, LocalDate dataLivrare, Boolean cerereProdusFurnizor, Boolean cerereProdusAdmin, Admin admin) {
        this.produs = produs;
        this.furnizor = furnizor;
        this.numarBucatiComanda = numarBucatiComanda;
        this.pretCumparare = pretCumparare;
        this.dataCerere = dataCerere;
        this.dataLivrare = dataLivrare;
        this.cerereProdusAdmin = cerereProdusAdmin;
        this.cerereProdusFurnizor = cerereProdusFurnizor;
        this.admin = admin;
    }

    public void setPretCumparare(Double pret) {
        this.pretCumparare = pret;
    }
    public void setProdusCumparare(Produs produs) {
        this.produs = produs;
    }
    public void setFurnizorCumparare(Furnizor furnizor) {
        this.furnizor = furnizor;
    }
    public void setNrBucatiCumparare(Integer numarBucatiComanda) {
        this.numarBucatiComanda = numarBucatiComanda;
    }
    public Boolean getCerereProdusFurnizor(){
        return cerereProdusFurnizor;
    }
    public Boolean getCerereProdusAdmin(){
        return cerereProdusAdmin;
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
    public Boolean eConfirmata(){
        if(this.cerereProdusFurnizor == true && this.cerereProdusAdmin == true)
            return true;
        return false;
    }
    public void SolicitareComanda(Produs produs, Furnizor furnizor, Integer numarBucatiComanda, Double pretCumparare){
        setProdusCumparare(produs);
        setPretCumparare(pretCumparare);
        setFurnizorCumparare(furnizor);
        setNrBucatiCumparare(numarBucatiComanda);
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

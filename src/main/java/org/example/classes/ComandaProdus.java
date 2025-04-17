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
    private Boolean cerereProdusFurnizor;
    private Boolean cerereProdusAdmin;


    public ComandaProdus(Produs produs, Furnizor furnizor, Integer numarBucatiComanda, Double pretCumparare, LocalDateTime dataCerere, LocalDate dataLivrare, Boolean cerereProdusFurnizor, Boolean cerereProdusAdmin) {
        this.produs = produs;
        this.furnizor = furnizor;
        this.numarBucatiComanda = numarBucatiComanda;
        this.pretCumparare = pretCumparare;
        this.dataCerere = dataCerere;
        this.dataLivrare = dataLivrare;
        this.cerereProdusAdmin = cerereProdusAdmin;
        this.cerereProdusFurnizor = cerereProdusFurnizor;
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
    public void SolicitareComanda(){}
}

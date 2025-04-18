package org.example.classes;

public abstract class User {
    private String first_name;
    private String last_name;
    private String mail;
    private String password;
    private Double buget;
    public User(String first_name,String last_name,String mail,String parola,Double buget){
        this.first_name = first_name;
        this.last_name = last_name;
        this.mail = mail;
        this.password = parola;
        this.buget = buget;

    }
}

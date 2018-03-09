/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KnaldeKalle
 */
public class Adress {
    private String adressName;
    private int adressNumber;
    public int adressId;
    
    private List<Person> residents = new ArrayList<>();

    public Adress(String adressName, int adressNumber, int adressId) {
        this.adressName = adressName;
        this.adressNumber = adressNumber;
        this.adressId = adressId;
    }
    
      public void addResident(Person p) {
        residents.add(p);
        p.getAdresses().add(this);
    }

    public String getAdressName() {
        return adressName;
    }

    public void setAdressName(String adressName) {
        this.adressName = adressName;
    }

    public int getAdressNumber() {
        return adressNumber;
    }

    public void setAdressNumber(int adressNumber) {
        this.adressNumber = adressNumber;
    }

    public int getAdressId() {
        return adressId;
    }

    public void setAdressId(int adressId) {
        this.adressId = adressId;
    }

    public List<Person> getResidents() {
        return residents;
    }

    public void setResidents(List<Person> residents) {
        this.residents = residents;
    }
    
    
}

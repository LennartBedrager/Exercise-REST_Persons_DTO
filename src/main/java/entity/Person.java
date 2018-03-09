/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;


public class Person {
    
    private int userId;
    private int phoneNumber;
    private String firstName;
    private String lastName;
    
    private List<Adress> adresses = new ArrayList<>();

    public Person(int userId, int phoneNumber, String firstName, String lastName) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Person(int userId, int phoneNumber, String firstName, String lastName, List<Adress> adresses) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresses = adresses;
    }

        public List<Adress> getAdresses() {
        if (adresses == null) {
            adresses = new ArrayList<>();
        }
        return adresses;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" + "userId=" + userId + ", phoneNumber=" + phoneNumber + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
    
    
}

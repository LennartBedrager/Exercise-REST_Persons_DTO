/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.HashMap;


import java.util.HashMap;
import javax.print.attribute.HashAttributeSet;

/**
 *
 * @author bladt
 */
public class PersonFacade {
    public static HashMap<Integer, Person> persons = new HashMap<>();
    public static HashMap<Integer, Adress> addresses = new HashMap<>();

    static{
        Person p1 = new Person(1,888888,"GERY","John");
        Person p2 = new Person(2,444444,"Gurt","Hansen");
        Person p3 = new Person(3,555555,"Jon","Blond");
    
        persons.put(p1.getUserId(),p1);
        persons.put(p2.getUserId(),p2);
        persons.put(p3.getUserId(),p3);
        
        Adress a1 = new Adress("Hansensvej",12,1);
        
        addresses.put(a1.getAdressId(),a1);
        
        
        //This line will break our REST endpoints, as the gson library tries
        //to make an endless chain of Persons with Adresses with Persons with Adresses.
        a1.addResident(p1);
        
        //To fix this we implemented the jsonmesseages classes

    }
    
     public static Adress findAdressById(int id){
        return addresses.get(id);
    }
    
     public void createPerson(Person p){
        persons.put(p.getUserId(), p);
    }
    
 

}



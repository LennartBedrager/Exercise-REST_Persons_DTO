/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonmessages;

import entity.Adress;
import entity.Person;
import entity.PersonFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author bladt
 */
public class PersonMessage implements JSONMessage<Person>
{
    public int userId;
    public int phoneNumber;
    public String firstName;
    public String lastName;
    
    public List<Integer> addressIds;

    public PersonMessage(Person p) {
        this.phoneNumber = p.getPhoneNumber();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        //Get coursenames as list.
        Stream<Adress> Adress = p.getAdresses().stream();
        Stream<Integer> adressIds = Adress.map(c -> c.adressId);
        this.addressIds = adressIds.collect(Collectors.toList());
    }
    
    @Override
    public Person toInternal(){
        ArrayList<Adress> adresses = new ArrayList<>();
        for(int id : addressIds) {
            adresses.add(PersonFacade.findAdressById(id));
        }
        return new Person(userId,phoneNumber,firstName, lastName, adresses);
    }
    
}

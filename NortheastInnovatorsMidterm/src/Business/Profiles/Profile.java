/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;

/**
 *
 * @author kal bugrara
 */
public abstract class Profile {
    
    
    // ATTRIBUTE
    Person person;
    
    
    // CONSTRUCTOR
    public Profile(Person p){
        person = p;    
    }
    
    
    // METHODS
    public abstract String getRole(); // Must be implemented in subclasses
    
    public Person getPerson(){
        return person;
    }
    
    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author kal bugrara
 */
public class Person {

    
    // ATTRIBUTE
    String id; // Person name

    
    // CONSTRUCTOR
    public Person(String id) {
        this.id = id;
    }

    
    // GETTER
    public String getPersonId() {
        return id;
    }

    
    // EXTRA METHODS
    public boolean isMatch(String id) {
        return getPersonId().equals(id);
    }

    @Override
    public String toString() {
        return getPersonId();
    }
}

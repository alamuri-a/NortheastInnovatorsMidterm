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
public class FacultyProfile extends Profile {

    
    // ATTRIBUTES
    Person person;
    //Transcript transcript;
    //EmploymentHistroy employmenthistory;

    
    // CONSTRUCTOR
    public FacultyProfile(Person p) {
        super(p);

        //transcript = new Transcript(this);
        //employmenthistory = new EmploymentHistroy();
    }

    
    // METHODS
    @Override
    public String getRole() {
        return "Student";
    }

}

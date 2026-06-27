/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;
import java.util.ArrayList;
/**
 *
 * @author kal bugrara
 */
public class StudentProfile extends Profile {

    
    // ATTRIBUTES
    Person person;
    ArrayList<String> registeredCourses;
    //Transcript transcript;
    //EmploymentHistroy employmenthistory;

    
    // CONSTRUCTOR
    public StudentProfile(Person p) {
    super(p);

    registeredCourses = new ArrayList<String>();

    //transcript = new Transcript(this);
    //employmenthistory = new EmploymentHistroy();
}

    
    // METHODS
    @Override
    public String getRole() {
        return "Student";
    }

public void registerCourse(String courseCode) {
    if (!registeredCourses.contains(courseCode)) {
        registeredCourses.add(courseCode);
    }
}

public void dropCourse(String courseCode) {
    registeredCourses.remove(courseCode);
}

public boolean isRegisteredForCourse(String courseCode) {
    return registeredCourses.contains(courseCode);
}

public ArrayList<String> getRegisteredCourses() {
    return registeredCourses;
}

public int getRegisteredCreditTotal() {
    return registeredCourses.size() * 4;
}}

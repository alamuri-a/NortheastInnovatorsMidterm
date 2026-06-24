/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.StudentDirectory;

import Business.UserAccounts.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

    
    // ATTRIBUTES
    String name;
    PersonDirectory persondirectory; // All Person profiles regardless of the role
    EmployeeDirectory employeedirectory; // Admin profile list
    UserAccountDirectory useraccountdirectory; // User account list
    StudentDirectory studentdirectory; // Student profile list
    
    
    // CONSTRUCTOR
    public Business(String n) {
        name = n;

        persondirectory = new PersonDirectory();
        employeedirectory = new EmployeeDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        studentdirectory = new StudentDirectory();
    }

    
    // GETTERS AND SETTERS
    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }
    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }


    public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }
    public StudentDirectory getStudentDirectory(){
        return studentdirectory;
    }

    
    // EXTRA METHODS
}

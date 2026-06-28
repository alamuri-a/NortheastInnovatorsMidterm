/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.StudentAccount;
import Business.Profiles.StudentDirectory;
import Business.UserAccounts.UserAccount;

import Business.UserAccounts.UserAccountDirectory;
import university.Department.Department;

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
    FacultyDirectory facultydirectory;//Faculty profile list 
    private Department department;
    
    // CONSTRUCTOR
    public Business(String n) {
        name = n;

        persondirectory = new PersonDirectory();
        employeedirectory = new EmployeeDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        studentdirectory = new StudentDirectory();
        facultydirectory= new FacultyDirectory();
         
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
    public FacultyDirectory getFacultyDirectory() {
        return facultydirectory;
    }
    
    // EXTRA METHODS
    public static boolean Authorize(UserAccount ua, String role) {
        // Check whether or not user is authorized for specific area

        if (role.equalsIgnoreCase("Admin")) {
            return ua.getRole().equals("Admin");
        } else if (role.equalsIgnoreCase("Faculty")) {
            return ua.getRole().equals("Faculty");
        } else if (role.equalsIgnoreCase("Student")) {
            // If student, check to make sure user account is a StudentAccount first
            if (ua instanceof StudentAccount) {
                return ua.getRole().equals("Student");
            }
        }
        return false;
    }
  

        // Add this Getter and Setter inside Business.java
    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

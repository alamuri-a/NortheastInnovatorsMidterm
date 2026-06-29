/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Profiles.EmployeeDirectory;
import Business.Profiles.StudentAccount;
import Business.UserAccounts.UserAccount;

import Business.UserAccounts.UserAccountDirectory;
import University.Department.Department;

/**
 *
 * @author kal bugrara
 */
public class Business {
    
    
    // ATTRIBUTES
    EmployeeDirectory employeedirectory; // Admin profile list
    UserAccountDirectory useraccountdirectory; // User account list
    Department department;
    
    // CONSTRUCTOR
    public Business(String n) {
        department = new Department(n);
        
        employeedirectory = new EmployeeDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
    }

    
    // METHODS
    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }
    
    // @author Ajay Alamuri
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

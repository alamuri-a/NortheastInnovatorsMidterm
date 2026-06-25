/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;

import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;


/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Information Systems");

        // Create Person Directory (Container for Persons)
        PersonDirectory persondirectory = business.getPersonDirectory();
        
        // Initialize demo Person data
        Person person001 = persondirectory.newPerson("John Smith");
        Person person002 = persondirectory.newPerson("Gina Montana");
        Person person003 = persondirectory.newPerson("Adam Rollen");
        Person person004 = persondirectory.newPerson("Jim Dellon");
        Person person005 = persondirectory.newPerson("Anna Shnider");
        Person person006 = persondirectory.newPerson("Laura Brown");
        Person person007 = persondirectory.newPerson("Jack While");

        // Create Admin (Employee) directory + initialize demo Admin profile
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);
        
        // Create Student directory + initialize demo Student profile
        StudentDirectory studentdirectory = business.getStudentDirectory();
        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);
   
        // Create User accounts for demo profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "****"); // Admin
        UserAccount ua4 = uadirectory.newStudentAccount(studentprofile0, "adam", "****", 1); // Student

        return business;
    }

}

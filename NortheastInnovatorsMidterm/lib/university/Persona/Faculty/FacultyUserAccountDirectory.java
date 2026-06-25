/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.Persona.Faculty;

import university.Persona.Persona;
import university.Persona.PersonaUserAccount;
import university.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class FacultyUserAccountDirectory {

    Department department;
    ArrayList<PersonaUserAccount> studentlist;

    public FacultyUserAccountDirectory(Department d) {

        department = d;
        studentlist = new ArrayList();

    }

    public PersonaUserAccount newUserAccount(Persona p) {

        PersonaUserAccount sp = new PersonaUserAccount(p);
        studentlist.add(sp);
        return sp;
    }

    public PersonaUserAccount findStudent(String id) {

        for (PersonaUserAccount sp : studentlist) {

         //   if (sp.isMatch(id)) {
         //       return sp;
         //   }
        }
            return null; //not found after going through the whole list
         }
    
}

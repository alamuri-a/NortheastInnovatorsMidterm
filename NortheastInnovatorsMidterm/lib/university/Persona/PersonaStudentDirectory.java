/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.Persona;

import university.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonaStudentDirectory {

    Department department;
    ArrayList<PersonaStudentProfile> studentlist;

    public PersonaStudentDirectory(Department d) {

        department = d;
        studentlist = new ArrayList();

    }

    public PersonaStudentProfile newStudentProfile(Persona p) {

        PersonaStudentProfile sp = new PersonaStudentProfile(p);
        studentlist.add(sp);
        return sp;
    }

    public PersonaStudentProfile findStudent(String id) {

        for (PersonaStudentProfile sp : studentlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
    
}

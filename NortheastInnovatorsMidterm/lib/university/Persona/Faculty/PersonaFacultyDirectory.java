/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.Persona.Faculty;

import university.Persona.Persona;
import university.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonaFacultyDirectory {

    Department department;
    ArrayList<PersonaFacultyProfile> teacherlist;

    public PersonaFacultyDirectory(Department d) {

        department = d;
        teacherlist = new ArrayList();

    }

    public PersonaFacultyProfile newFacultyProfile(Persona p) {

        PersonaFacultyProfile sp = new PersonaFacultyProfile(p);
        teacherlist.add(sp);
        return sp;
    }
    
    public PersonaFacultyProfile getTopProfessor(){
        
        double bestratingsofar = 0.0;
        PersonaFacultyProfile BestProfSofar = null;
        for(PersonaFacultyProfile fp: teacherlist)
           if(fp.getProfAverageOverallRating()>bestratingsofar){
           bestratingsofar = fp.getProfAverageOverallRating();
           BestProfSofar = fp;
           }
        return BestProfSofar;
        
    }

    public PersonaFacultyProfile findTeachingFaculty(String id) {

        for (PersonaFacultyProfile sp : teacherlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.Persona.Faculty;

import university.CourseSchedule.CourseOffer;

/**
 *
 * @author kal bugrara
 */
public class FacultyAssignment {
    double tracerating;
    CourseOffer courseoffer;
    PersonaFacultyProfile facultyprofile;
    public FacultyAssignment(PersonaFacultyProfile fp, CourseOffer co){
        courseoffer = co;
        facultyprofile = fp;
    }

       public double getRating(){
        
        return tracerating;
    }
       public void seProfRating(double r){
           
           tracerating = r;
       }
    public PersonaFacultyProfile getFacultyProfile(){
        return facultyprofile;
    }
    
}

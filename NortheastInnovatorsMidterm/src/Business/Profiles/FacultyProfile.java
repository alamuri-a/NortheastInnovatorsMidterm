/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;
import java.util.ArrayList;
import university.CourseSchedule.CourseOffer;
import university.Department.Department;
import university.Persona.Faculty.FacultyAssignment;
import university.Persona.Faculty.PersonaFacultyProfile;

/**
 *
 * @author meredith molyneux
 */
public class FacultyProfile extends Profile {

    
    // ATTRIBUTES
    Person person;
    String Name;
    String id;
    Department department;
    ArrayList <FacultyAssignment> facultyassignments; 
       PersonaFacultyProfile personaFacultyProfile; 
    
    //Transcript transcript;
    //EmploymentHistroy employmenthistory;

    
    // CONSTRUCTOR
    public FacultyProfile(Person p) {
        super(p);
            this.facultyassignments = new ArrayList<>(); 


        //transcript = new Transcript(this);
        //employmenthistory = new EmploymentHistroy();
    }

    // Getter and Setter to link and retrieve the library data model
    public PersonaFacultyProfile getPersonaFacultyProfile() {
        return personaFacultyProfile;
    }

    public void setPersonaFacultyProfile(PersonaFacultyProfile pfp) {
        this.personaFacultyProfile = pfp;
    }
    

      public  double getProfAverageOverallRating(){
        
        double sum = 0.0;
        //for each facultyassignment extract class rating
        //add them up and divide by the number of teaching assignmnet;
        for(FacultyAssignment fa: facultyassignments){
            
            sum = sum + fa.getRating();
            
        }
        //divide by the total number of faculty assignments
        
        return sum/(facultyassignments.size()*1.0); //this ensure we have double/double
        
    }




// Inside your updated AssignAsTeacher method:
public FacultyAssignment AssignAsTeacher(CourseOffer co) {
    if (this.personaFacultyProfile == null) {
        // You may need to adapt this depending on what constructors PersonaFacultyProfile provides
        // this.personaFaculty = new PersonaFacultyProfile(...); 
    }
    
    // Pass the matching type expected by the library object
    FacultyAssignment fa = new FacultyAssignment(this.personaFacultyProfile, co); 
    facultyassignments.add(fa);
    return fa;
}
    
    public PersonaFacultyProfile getCourseOffer(String courseid){
        return null; //complete it later
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }
    
    // Pass-through helper method to get the name safely
    public String getFacultyName() {
        return (person != null) ? person.getPersonId() : "Unknown";
    }

    public String getNUID() {
        return id;
    }

    public void setNUID(String id) {
        this.id = id;
    }
    

    
    // METHODS
    @Override
    public String getRole() {
        return "Faculty";
    }

}

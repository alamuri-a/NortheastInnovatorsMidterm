/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;
import java.util.ArrayList;
import University.CourseSchedule.CourseOffer;
import University.Department.Department;

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

    
    // CONSTRUCTOR
    public FacultyProfile(Person p) {
        super(p);
        this.facultyassignments = new ArrayList<>(); 
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
        // Pass the matching type expected by the library object
        FacultyAssignment fa = new FacultyAssignment(this, co); 
        facultyassignments.add(fa);
        return fa;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

import university.CourseCatalog.Course;
import university.CourseCatalog.CourseCatalog;
import university.CourseSchedule.CourseLoad;
import university.CourseSchedule.CourseOffer;
import university.CourseSchedule.CourseSchedule;
import university.Department.Department;
import university.Persona.Persona;
import university.Persona.PersonaDirectory;
import university.Persona.PersonaStudentDirectory;
import university.Persona.PersonaStudentProfile;

/**
 *
 * @author kal bugrara
 */
public class University {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Department department = new Department("Information Systems");
        CourseCatalog coursecatalog = department.getCourseCatalog();
        
        Course course = coursecatalog.newCourse("app eng", "info 5100", 4);
        
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        if (courseoffer==null)return;
        courseoffer.generatSeats(10);
        PersonaDirectory pd = department.getPersonDirectory();
        Persona person = pd.newPerson("0112303");
        PersonaStudentDirectory sd = department.getStudentDirectory();
        PersonaStudentProfile student = sd.newStudentProfile(person);
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
//        
        courseload.newSeatAssignment(courseoffer); //register student in class
        
        int total = department.calculateRevenuesBySemester("Fall2020");
        System.out.print("Total: " + total);

    }

}

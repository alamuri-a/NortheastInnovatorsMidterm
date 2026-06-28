package Business;

import university.CourseCatalog.Course;
import university.CourseCatalog.CourseCatalog;
import university.CourseSchedule.CourseLoad;
import university.CourseSchedule.CourseOffer;
import university.CourseSchedule.CourseSchedule;
import university.CourseSchedule.SeatAssignment;
import university.CourseSchedule.Seats;
import university.Department.Department;
import university.Persona.Persona;
import university.Persona.PersonaDirectory;
import university.Persona.PersonaStudentDirectory;
import university.Persona.PersonaStudentProfile;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mmoly
 */
public class UniversityModel {
      // Keep references to the main entry points
    private Department department;
    private String departmentName;
    private CourseSchedule courseSchedule;

    public UniversityModel() {
          this.departmentName ="Information Systems";
          this.department = new Department(this.departmentName);
           initializeData();
    }
// Add this public method right here in the data model!
    public String getDepartmentName() {
        if (this.department != null) {
            return this.departmentName; // Accesses the package-private field from your snippet
        }
        return "No Department Initialized";
    }
      public Department getDepartment() {
        return this.department;
    }


    private void initializeData() {
        // 1. Department and Catalog Check
        //System.out.println("UniversityModel [STEP 1] Created Department: " + this.departmentName); 
        CourseCatalog coursecatalog = department.getCourseCatalog();
        //System.out.println("UniversityModel [STEP 2] Retrieved Catalog. Total existing courses: " + coursecatalog.getCourseList().size()); 

        // 2. Course Creation Check
        Course course = coursecatalog.newCourse("app eng", "info 5100", 4);
          // System.out.println("UniversityModel [STEP 3] Created Course: " + course.getName()+ " (" + course.getCourseNumber() + ")");
    
        //System.out.println("UniversityModel [STEP 2] Retrieved Catalog. Total existing courses: " + coursecatalog.getCourseList().size()); 

        // 3. Schedule and Offer Check
        this.courseSchedule = department.newCourseSchedule("Fall2026");
        System.out.println("UniversityModel [STEP 4] Created Schedule for: " + courseSchedule.getSemester());
        CourseOffer courseoffer = courseSchedule.newCourseOffer("info 5100");

        if (courseoffer == null) {
            System.out.println("UniversityModel [ALERT] CourseOffer returned NULL for 'info 5100'!");
            return;
        }
        System.out.println("UniversityModel [STEP 5] Created Course Offer successfully.");

        // 4. Seats Allocation Check
        courseoffer.generatSeats(10); // Note: check library spelling for generatSeats vs generateSeats
        
      int emptySeatCount = 0;
            // Loop to check seat availability structure depending on library behavior
            Seats emptySeat = courseoffer.getEmptySeat(); 

                if (emptySeat != null) {
                //System.out.println("UniversityModel [STEP 6] Number of Avaliable seats: " + courseoffer.getSeatlist().size()+ " of 10");
            } else {
                //System.out.println("UniversityModel [STEP 6] ALERT: No empty seats found! The class is full.");

                }

        // 5. Directory and Person Check
        PersonaDirectory pd = department.getPersonDirectory();
        Persona person = pd.newPerson("0112303");
        //System.out.println("UniversityModel [STEP 7] Created Person with ID: " + person.getPersonId());

        // 6. Student Profile and Course Load Check
        PersonaStudentDirectory sd = department.getStudentDirectory();
        PersonaStudentProfile student = sd.newStudentProfile(person);
       // System.out.println("UniversityModel [STEP 8] Created Student Profile linked to Person ID: " + person.getPersonId());
        
        CourseLoad courseload = student.newCourseLoad("Fall2026");
        //System.out.println("UniversityModel [STEP 9] Created Course Load for Fall2020.");

        // 7. Registration Check
        SeatAssignment assignment = courseload.newSeatAssignment(courseoffer);
        //System.out.println("UniversityModel [STEP 10] Student registered in seat. Assignment status: " + (assignment != null ? "Assigned" : "Failed"));

        // 8. Revenue Calculation Check
        int total = department.calculateRevenuesBySemester("Fall2026");
        
           
       }

    // Getters to allow your JPanels to pull the data they need
    public CourseSchedule getCourseSchedule() {
        return courseSchedule;
    }
}



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
import Business.Profiles.FacultyDirectory;
import Business.Profiles.FacultyProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;

import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import university.CourseCatalog.Course;
import university.CourseCatalog.CourseCatalog;
import university.CourseSchedule.CourseOffer;
import university.CourseSchedule.CourseSchedule;
import university.Department.Department;


/**
 *
 * @author kal bugrara
 * @author meredith molyneux
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
        
          // Create Faculty directory + initialize demo Faculty profile
        FacultyDirectory facultydirectory = business.getFacultyDirectory();
        FacultyProfile facultyprofile0 = facultydirectory.newFacultyProfile(person007);
   
        // Create User accounts for demo profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "****"); // Admin
        UserAccount ua4 = uadirectory.newStudentAccount(studentprofile0, "adam", "****", 1); // Student
        UserAccount ua5 = uadirectory.newFacultyAccount(facultyprofile0, "jackW", "****","1235681");//Faculty
           
       //System.out.println("ConfigureABusiness FacultyProfile complete: Name"+ facultyprofile0.getPerson().getPersonId());
       
        // 5. Initialize University Structure
        Department department = new Department("Information Systems");
        business.setDepartment(department);
        CourseCatalog coursecatalog = department.getCourseCatalog();

        // Take note of this variable 'course'
        Course course = coursecatalog.newCourse("App Eng", "info 5100", 4); 

        // 6. Build Schedule Matrix explicitly for Fall2026
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2026");

        // FIX: Make sure your framework takes the Course object or the correct ID 
        // If your newCourseOffer method takes a String, try using the course number variable:
        CourseOffer courseoffer = courseschedule.newCourseOffer(course.getCourseNumber()); 

        // 7. Verify object instantiation state before assigning seats
        if (courseoffer != null) {
            courseoffer.generatSeats(10); 
            ConfigureABusiness.assignFacultyToCourse(ua5, courseoffer);
        } else {
            //System.out.println("❌ ERROR: CourseOffer initialization failed inside data block!");
        }

        
        return business; 
        }
    
         public static boolean assignFacultyToCourse(UserAccount ua, CourseOffer courseOffer) { 
        //System.out.println("[SYSTEM LOG] Initiating Faculty Course Assignment..."); 
        //System.out.println("🔄 Checking profile type structure..."); 

        // 1. Core Object Guard Rails 
        if (ua == null || courseOffer == null) { 
            //System.out.println("❌ Assignment Failed: User Account or Course Offer missing (Null)."); 
            return false; 
        } 

        // 2. STRUCTURAL CHECK: Bypass role text string parsing errors completely 
        if (ua.getAssociatedPersonProfile() instanceof FacultyProfile) { 
            FacultyProfile facultyProfile = (FacultyProfile) ua.getAssociatedPersonProfile(); 

            // Extracting Faculty / Teacher data identifiers safely
            String facultyId = "N/A";
            String facultyName = "Unknown";

            if (facultyProfile.getPerson() != null) {
                facultyName = facultyProfile.getPerson().getPersonId(); 
                      } else {
                     }

            // Execute assignment linkage step 
            facultyProfile.AssignAsTeacher(courseOffer); 

            //System.out.println("CAB 👤 Verified Profile Structural Type: [FacultyProfile]"); 
           // System.out.println("CAB 🆔 Assigned Teacher " + " | Name: " + facultyName); // Added identity tracking
            //System.out.println("CAB ✅ Successfully assigned course: " + courseOffer.getCourseNumber()); 
            //System.out.println("CAB [SYSTEM LOG] Faculty assignment step finalized."); 
           // System.out.println("CAB Assigned Teacher | Name: " + facultyName); // Added identity tracking
            return true; 
        } else { 
            //System.out.println("CAB ❌ Assignment Failed: Account profile is an instance of " + (ua.getAssociatedPersonProfile() != null ? ua.getAssociatedPersonProfile().getClass().getSimpleName() : "Null")); 
            return false; 
        }}     
     
}

package Business.Profiles;

import Business.Person.Person;
import University.CourseSchedule.CourseLoad;
import University.CourseSchedule.SeatAssignment;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 * @author Nicholas Woodward
 */
public class StudentProfile extends Profile {

    // ATTRIBUTES
    Person person;
    
    Transcript transcript;
    
    ArrayList<String> registeredCourses;
    ArrayList<String> submittedAssignments;

    // CONSTRUCTOR
    public StudentProfile(Person p) {
        super(p);
        registeredCourses = new ArrayList<String>();
        submittedAssignments = new ArrayList<String>();
        this.transcript = new Transcript(this); // Two-way link to Transcript object
    }

    // METHODS
    @Override
    public String getRole() {
        return "Student";
    }

    /**
     * Registers a course for the student if it is not already registered.
     */
    public void registerCourse(String courseCode) {
        if (!registeredCourses.contains(courseCode)) {
            registeredCourses.add(courseCode);
        }
    }

    /**
     * Drops a registered course from the student's saved course list.
     */
    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }

    /**
     * Checks whether the student is registered for a course.
     */
    public boolean isRegisteredForCourse(String courseCode) {
        return registeredCourses.contains(courseCode);
    }

    /**
     * Returns the student's currently registered courses.
     */
    public ArrayList<String> getRegisteredCourses() {
        return registeredCourses;
    }

    /**
     * Calculates the total registered credits assuming each course is four credits.
     */
    public int getRegisteredCreditTotal() {
        return registeredCourses.size() * 4;
    }

    /**
     * Saves an assignment as submitted for the student.
     */
    public void submitAssignment(String assignmentName) {
        if (!submittedAssignments.contains(assignmentName)) {
            submittedAssignments.add(assignmentName);
        }
    }

    /**
     * Checks whether an assignment has already been submitted.
     */
    public boolean isAssignmentSubmitted(String assignmentName) {
        return submittedAssignments.contains(assignmentName);
    }

    /**
     * Returns the student's submitted assignments.
     */
    public ArrayList<String> getSubmittedAssignments() {
        return submittedAssignments;
    }
    
    // AJAY TEST
    
    // Get list of courses
    public ArrayList<SeatAssignment> getCourseList() {
        return transcript.getCourseList();
    }
    
    /*
     * Get current course load
    */
    public CourseLoad getCurrentCourseLoad() {
        return this.transcript.getCurrentCourseLoad();
    }
}
package Business.Profiles;

import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 * @author Nicholas Woodward
 */
public class StudentProfile extends Profile {

    // ATTRIBUTES
    Person person;
    ArrayList<String> registeredCourses;
    ArrayList<String> submittedAssignments;

    // CONSTRUCTOR
    public StudentProfile(Person p) {
        super(p);
        registeredCourses = new ArrayList<String>();
        submittedAssignments = new ArrayList<String>();
    }

    // METHODS
    @Override
    public String getRole() {
        return "Student";
    }

    public void registerCourse(String courseCode) {
        if (!registeredCourses.contains(courseCode)) {
            registeredCourses.add(courseCode);
        }
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }

    public boolean isRegisteredForCourse(String courseCode) {
        return registeredCourses.contains(courseCode);
    }

    public ArrayList<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public int getRegisteredCreditTotal() {
        return registeredCourses.size() * 4;
    }

    public void submitAssignment(String assignmentName) {
        if (!submittedAssignments.contains(assignmentName)) {
            submittedAssignments.add(assignmentName);
        }
    }

    public boolean isAssignmentSubmitted(String assignmentName) {
        return submittedAssignments.contains(assignmentName);
    }

    public ArrayList<String> getSubmittedAssignments() {
        return submittedAssignments;
    }
}

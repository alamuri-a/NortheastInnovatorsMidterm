/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;
import University.Department.Department;

import java.util.ArrayList;


/**
 *
 * @author kal bugrara
 */
public class StudentDirectory {


    // ATTRIBUTE
    ArrayList<StudentProfile> studentlist;
    Department department;
    
    // CONSTRUCTOR
    public StudentDirectory(Department dep) {
        studentlist = new ArrayList();
    }

    
    // METHODS
    public ArrayList<StudentProfile> getList() {
        return this.studentlist;
    }
    
    public void deleteStudentProfile(StudentProfile sp) {
        this.studentlist.remove(sp);
    }
    
    public StudentProfile newStudentProfile(Person p) {
        StudentProfile sp = new StudentProfile(p);
        studentlist.add(sp);
        return sp;
    }

    public StudentProfile findStudent(String id) {
        for (StudentProfile sp : studentlist) {
            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; //not found after going through the whole list
    }
    
}

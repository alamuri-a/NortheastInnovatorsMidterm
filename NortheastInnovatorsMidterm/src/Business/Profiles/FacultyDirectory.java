/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Business;
import Business.Person.Person;
import University.Department.Department;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class FacultyDirectory {

    Business business;
    ArrayList<FacultyProfile> facultylist;
    Department department;

    public ArrayList<FacultyProfile> getFacultyList() {
        return facultylist;
    }

    public void setFacultylist(ArrayList<FacultyProfile> facultylist) {
        this.facultylist = facultylist;
    }

    public FacultyDirectory(Department dept) {
        facultylist = new ArrayList();
        this.department = dept;
    }
    
    public void deleteFacultyProfile(FacultyProfile fp) {
        this.facultylist.remove(fp);
    }
    
    public FacultyProfile newFacultyProfile(Person p) {

        FacultyProfile sp = new FacultyProfile(p);
        facultylist.add(sp);
        return sp;
    }

    public FacultyProfile findEmployee(String id) {

        for (FacultyProfile sp : facultylist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
    
}

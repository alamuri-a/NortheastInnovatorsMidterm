/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.Employer;

import university.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class UniEmployerDirectory {

    Department department;
    ArrayList<UniEmployerProfile> employerlist;

    public UniEmployerDirectory(Department d) {

        department = d;
        employerlist = new ArrayList();

    }

    public UniEmployerProfile newEmployerProfile(String n) {

        UniEmployerProfile sp = new UniEmployerProfile(n);
        employerlist.add(sp);
        return sp;
    }

    public UniEmployerProfile findTeachingFaculty(String id) {

        for (UniEmployerProfile ep : employerlist) {

            if (ep.isMatch(id)) {
                return ep;
            }
        }
            return null; //not found after going through the whole list
         }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.Persona.EmploymentHistory;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class EmploymentHistory {
    ArrayList<Employment> employments;
    public EmploymentHistory(){
        employments = new ArrayList();
    }
    
    public Employment newEmployment(String job){
        Employment ne = new Employment(job);
        employments.add(ne);
        return ne;
    }
    
}

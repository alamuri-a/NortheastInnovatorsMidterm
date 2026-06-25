/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.workareas;

import university.Persona.Persona;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Workarea {
    
    Persona person; //owner
    ArrayList<WorkRequest> inQueue;
    ArrayList<WorkRequest> outQueue;
    
    public Workarea(Persona p){
        
        person = p;
        inQueue = new ArrayList();
        outQueue = new ArrayList();
        
        
    }
    
    public void addInQuestRequest(WorkRequest wr){
        inQueue.add(wr);
    }

}

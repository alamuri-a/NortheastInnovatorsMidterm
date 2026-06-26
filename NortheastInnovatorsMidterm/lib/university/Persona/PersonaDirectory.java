/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.Persona;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonaDirectory {
    
      ArrayList<Persona> personlist ;
    
      public PersonaDirectory (){
          
       personlist = new ArrayList();

    }

    public Persona newPerson(String id) {

        Persona p = new Persona(id);
        personlist.add(p);
        return p;
    }

    public Persona findPerson(String id) {

        for (Persona p : personlist) {

            if (p.isMatch(id)) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }
    
}

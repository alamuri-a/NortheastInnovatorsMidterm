/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Profiles;
import Business.UserAccounts.UserAccount;
/**
 *
 * @author meredith molyneux
 */
public class FacultyAccount extends UserAccount{
    // ATTRIBUTES
    private String ID;
    
    
    // CONSTRUCTOR
    public FacultyAccount(FacultyProfile p, String un, String pw, String id) {
        super(p,un, pw);
        
        ID = id;
    }
    
    // METHODS
    public String getID() {
        return ID;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }
   @Override
public String getRole() {
    return "Faculty";
} 
} 


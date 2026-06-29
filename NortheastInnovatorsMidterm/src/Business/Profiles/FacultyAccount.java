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
    private int NUID;
    
    
    // CONSTRUCTOR
    public FacultyAccount(FacultyProfile p, String un, String pw, int id) {
        super(p,un, pw);
        
        NUID = id;
    }
    
    // METHODS
    public int getNUID() {
        return NUID;
    }
    
    public void setNUID(int NUID) {
        this.NUID = NUID;
    }
   @Override
public String getRole() {
    return "Faculty";
} 
} 


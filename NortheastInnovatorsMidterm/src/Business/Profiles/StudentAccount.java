/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.UserAccounts.UserAccount;

/**
 *
 * @author kal bugrara
 */
public class StudentAccount extends UserAccount {
    
    
    // ATTRIBUTES
    private int NUID;
    
    
    // CONSTRUCTOR
    public StudentAccount(StudentProfile p, String un, String pw, int id) {
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
    
}

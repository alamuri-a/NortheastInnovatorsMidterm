/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;



/**
 *
 * @author kal bugrara
 */
public class UserAccount {
    
    
    // ATTRIBUTES
    Profile profile;
    String username;
    String password;
    
    
    // CONSTRUCTOR
    public UserAccount (Profile profile, String un, String pw){
        username = un;
        password = pw;
        this.profile = profile;
    }

    
    // GETTERS
    public String getUserLoginName(){
        return username;
    }
    
    public Profile getAssociatedPersonProfile(){
        return profile;
    }
    
    public String getPersonId(){
        return profile.getPerson().getPersonId();
    }
    
    public String getRole(){
        return profile.getRole();
    }
    
    
    // EXTRA METHODS
    public boolean isMatch(String id){
        return profile.isMatch(id);
    }
    
    public boolean IsValidUser(String un, String pw){    
        return (username.equalsIgnoreCase(un) && password.equals(pw));    
    }
        
    @Override
    public String toString(){
        return getUserLoginName();
    }
        
}


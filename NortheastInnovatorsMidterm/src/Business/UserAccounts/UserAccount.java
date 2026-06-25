/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



/**
 *
 * @author kal bugrara
 */
public class UserAccount {
    
    
    // ATTRIBUTES
    Profile profile;
    String username;
    String password;
    boolean status;
    LocalDateTime activity;
    LocalDateTime updated;
    
    
    // CONSTRUCTOR
    public UserAccount (Profile profile, String un, String pw){
        username = un;
        password = pw;
        this.profile = profile;
        activity = LocalDateTime.now();
        updated = LocalDateTime.now();
        status = false;
    }

    
    // GETTERS AND SETTERS
    public String getUserLoginName(){
        return username;
    }
    
    public void setUserLoginName(String un){
        username = un;
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
    
    public String getActivity() {
        return this.activity.format(DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss"));
    }
    
    public void setActivity() {
        this.activity = LocalDateTime.now();
    }
    
    public String getUpdated() {
        return this.updated.format(DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss"));
    }
    
    public void setUpdated() {
        this.updated = LocalDateTime.now();
    }
    
    public boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(boolean stat) {
        this.status = stat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


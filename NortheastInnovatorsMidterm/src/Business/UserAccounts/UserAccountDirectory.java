/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;
import Business.Profiles.StudentAccount;
import Business.Profiles.StudentProfile;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class UserAccountDirectory {
    
    
    // ATTRIBUTE
    ArrayList<UserAccount> useraccountlist;
    
    
    // CONSTRUCTOR
    public UserAccountDirectory (){
        useraccountlist = new ArrayList();
    }

    
    // METHODS
    public UserAccount newUserAccount(Profile p, String un, String pw) {
        UserAccount ua = new UserAccount(p,  un,  pw);
        useraccountlist.add(ua);
        return ua;
    }
    
    public UserAccount newStudentAccount(StudentProfile p, String un, String pw, int id) {
        UserAccount ua = new StudentAccount(p,  un,  pw, id);
        useraccountlist.add(ua);
        return ua;
    }
    
    public void deleteUserAccount(UserAccount ua) {
        useraccountlist.remove(ua);
    }

    public UserAccount findUserAccount(String id) {
        for (UserAccount ua : useraccountlist) {
            if (ua.isMatch(id)) {
                return ua;
            }
        }
        return null; //not found after going through the whole list
    }
    
    public UserAccount AuthenticateUser(String un, String pw) {
        for (UserAccount ua : useraccountlist) {
            if (ua.IsValidUser(un, pw)) {
                return ua;
            }
        }
        return null; //not found after going through the whole list
    }
    
    public ArrayList<UserAccount> getUserAccountList() {
        return useraccountlist;
    }
}

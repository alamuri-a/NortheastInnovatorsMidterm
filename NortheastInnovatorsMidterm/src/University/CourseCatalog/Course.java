/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package University.CourseCatalog;

/**
 *
 * @author abala
 */
public class Course {
    
    String number;
    String name;
    int credits;
    
    /*
    * @param n
    * @param numb
    * @param ch
    */
    public Course(String n, String numb, int ch) {
        name = n;
        number = numb;
        credits = ch;
    }

    public String getCourseNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }
    
    
}

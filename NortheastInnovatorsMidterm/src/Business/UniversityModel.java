package Business;

import java.util.ArrayList;
import university.CourseCatalog.Course;
import university.CourseSchedule.CourseLoad;
import university.CourseSchedule.CourseOffer;
import university.CourseSchedule.CourseSchedule;
import university.CourseSchedule.SeatAssignment;
import university.CourseSchedule.Seats;
import university.Department.Department;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author meredith molyneux
 */
public class UniversityModel {
       
    private Department department;
    private String departmentName;
    private CourseSchedule courseSchedule;
    private ArrayList<Seats> seatlist = new ArrayList<>();
    private ArrayList<SeatAssignment> seatassignments = new ArrayList<>();

      // Empty Constructor
    public UniversityModel() {}

    // Overloaded Constructor to accept the generated configuration data
    public UniversityModel(CourseSchedule schedule) {
        this.courseSchedule = schedule;
    }

    public CourseSchedule getCourseSchedule() {
        return this.courseSchedule;
    }

    public void setCourseSchedule(CourseSchedule schedule) {
        this.courseSchedule = schedule;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartment(Department dept) {
        this.department = dept;
    }

    public Department getDepartment() {
        return this.department;
    }

    public int getEmptySeatCount() {
        int count = 0;
        for (Seats seat : seatlist) {
            if (!seat.isOccupied()) {
                count++;
            }
        }
        return count; 
    }

    public ArrayList<Seats> getSeatlist() {
        return seatlist;
    }

    public ArrayList<SeatAssignment> getSeatAssignments() {
        return seatassignments;
    }
    
}

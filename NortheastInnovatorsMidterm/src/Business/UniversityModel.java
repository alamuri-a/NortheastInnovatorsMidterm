package Business;

import University.CourseSchedule.CourseSchedule;
import University.Department.Department;

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

    // 1. CLEAN CONSTRUCTOR: No longer hardcodes duplicate text objects or runs initializeData()
    public UniversityModel() {
        this.departmentName = "Information Systems";
    }

    // 2. SETTERS: Allows ConfigureABusiness to inject the live memory data at root startup
    public void setDepartment(Department dept) {
        this.department = dept;
    }

    public void setCourseSchedule(CourseSchedule schedule) {
        this.courseSchedule = schedule;
    }

    // 3. GETTERS: Allows your dashboard JPanels to pull the valid shared data references cleanly
    public CourseSchedule getCourseSchedule() {
        return this.courseSchedule;
    }

    public Department getDepartment() {
        return this.department;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }
}

package com.company.mc210413533;

import java.util.ArrayList;

public class Employee {

    String EmployeeName;
    double EmployeeBaseSalary;
    static int EmployeeIdCount;
    int EmployeeId;

    Employee Manager;
    //Should construct a new employee object and take in two parameters,
    //one for the name of the user and one for their base salary
    public Employee(String name, double baseSalary){
        EmployeeIdCount++;
        EmployeeName = name;
        EmployeeBaseSalary = baseSalary;
        EmployeeId = EmployeeIdCount;
    }
    //Should return the employee's current salary
    public double getBaseSalary(){ return EmployeeBaseSalary; }

    public double setBaseSalary(double addEmployeeBaseSalary){return this.EmployeeBaseSalary = addEmployeeBaseSalary;}

    public String getName(){ return EmployeeName; }
    //Should return the employee's ID. The ID should be issued on behalf of
    //the employee at the time they are constructed. The first ever
    //employee should have an ID of "1", the second "2" and so on
    public int getEmployeeID(){ return EmployeeId; }
    //Should return a reference to the Employee object that represents this
    //employee's manager
    public Employee getManager() { return Manager; }
    //Should return true if the two employee IDs are the same, false
    //otherwise
    public boolean equals(Employee other){
        if(this.EmployeeId == other.getEmployeeID()){
            return true;
        }
        return false;
    }
    public boolean equals(Employee[] other) {
        for (int i = 0; i <= other.length; i++) {
            if (this.EmployeeId == other[i].EmployeeId) {
                return true;
            }
        }
        return false;
    }
    //Should return a String representation of the employee that is a
    //combination of their id followed by their name. Example: "1 Kasey
    public String toString(){ return EmployeeId+" "+EmployeeName; }
    //Should return a String representation of that Employee's current
    //status. This will be different for every subclass of Employee
    public String employeeStatus(){ return toString(); }



}

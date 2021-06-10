package com.company.mc210413533;

public class TechnicalEmployee extends Employee {
    static double BaseSalary = 75000.00;
    int successfulCheckIns = 0;
    //Has a default base salary of 75000
    public TechnicalEmployee(String name){ super(name,BaseSalary); }
    //Should return a String representation of this TechnicalEmployee that
    //includes their ID, name and how many successful check ins they have
    //had. Example: "1 Kasey has 10 successful check ins"
    public String employeeStatus(){ return super.employeeStatus(); }
}

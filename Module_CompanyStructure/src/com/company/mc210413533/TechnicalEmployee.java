package com.company.mc210413533;

public class TechnicalEmployee extends Employee {
    int successfulCheckIns = 0;

    public TechnicalEmployee(String name){ super(name,75000.00); }

    public String employeeStatus(){ return super.employeeStatus(); }
}

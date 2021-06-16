package com.company.mc210413533;

abstract class Employee {

    private final String EmployeeName;
    public double EmployeeBaseSalary;
    static int EmployeeIdCount;
    private final int EmployeeId;

    Employee Manager;

    public Employee(String name, double baseSalary){
        this.EmployeeIdCount++;
        this.EmployeeName = name;
        this.EmployeeBaseSalary = baseSalary;
        this.EmployeeId = EmployeeIdCount;
    }

    public double getBaseSalary(){ return EmployeeBaseSalary; }

    public double setBaseSalary(double addEmployeeBaseSalary){return this.EmployeeBaseSalary = addEmployeeBaseSalary;}

    public String getName(){ return EmployeeName; }

    public int getEmployeeID(){ return EmployeeId; }

    public Employee getManager() { return Manager; }

    public void setManager(Employee manager){
        this.Manager = manager;
    }

    public boolean equals(Employee other){ return this.EmployeeId == other.getEmployeeID(); }

    public String toString(){ return EmployeeId+" "+EmployeeName; }

    public String employeeStatus(){ return toString(); }



}

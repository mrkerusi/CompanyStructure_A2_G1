package com.company.mc210413533;

import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    int headCount;
    BusinessLead manager;
    Accountant supportAccountant;
    ArrayList<SoftwareEngineer> Reports;

    public TechnicalLead(String name) {
        super(name);
        headCount = 4;
        this.EmployeeBaseSalary *= 1.3;
        Reports = new ArrayList<>();
    }
    public boolean hasHeadCount() { return Reports.size() < this.headCount; }

    public void addReport(SoftwareEngineer e) {
        if (this.hasHeadCount()) {
            Reports.add(e);
            e.setManager(this);
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e) { return e.getManager().equals(this) && e.getCodeAccess(); }

    public boolean requestBonus(Employee e, double bonus) {

        if (manager.approveBonus(e, bonus)) {
            e.setBaseSalary(e.getBaseSalary() + bonus);
            return true;
        }
        return false;
    }

    public String getTeamStatus() {

        if (Reports.size() > 0) {
            StringBuilder s= new StringBuilder(this.employeeStatus() + " and is managing:");

            for (SoftwareEngineer softwareEngineer : Reports) {
                s.append("\n").append(softwareEngineer.employeeStatus());
            }

            return s.toString()+"\n";
        } else {
            return this.employeeStatus() + " and no direct report yet";
        }
    }


}

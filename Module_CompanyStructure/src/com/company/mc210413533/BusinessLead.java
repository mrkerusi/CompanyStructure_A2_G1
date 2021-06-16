package com.company.mc210413533;

import java.util.ArrayList;


public class BusinessLead extends BusinessEmployee{
    int headCount;
    String status = "";
    ArrayList<Accountant> reports;

    public BusinessLead(String name){
        super(name);
        this.headCount = 10;
        this.EmployeeBaseSalary *=2.00;
        this.reports = new ArrayList<>();
    }

    public boolean hasHeadCount(){
        return reports.size() < this.headCount;
    }

    public void addReport(Accountant e, TechnicalLead supportTeam){

        if (this.hasHeadCount()) {
            reports.add(e);
            e.setManager(supportTeam);
            this.bonusBudget = e.EmployeeBaseSalary * 1.1;
            e.supportTeam(supportTeam);
            supportTeam.supportAccountant=e;
        }
    }

    public boolean requestBonus(Employee e, double bonus){

        if(bonus <= bonusBudget) {
            e.setBaseSalary(e.getBaseSalary() + bonus);
            bonusBudget -= bonus;
            return true;
        }else{
            return false;
        }
    }

    public boolean approveBonus(Employee e, double bonus){

        for (int i = 0; i < reports.size(); i++) {
            if (reports.get(i).equals(e.getManager()) && reports.get(i).approveBonus(bonus)) {
                return true;
            }
        }
        return false;
    }
    public String getTeamStatus(){

        status += super.employeeStatus();
        if (reports.size() == 0) status += " and no direct reports.\n";
        else {
            status += " and is managing: \n";
            for (int i = 0; i < reports.size(); i++) {
                if(reports.get(i) != null) {
                    status = status + reports.get(i).employeeStatus() + "\n";
                }
            }
        }
        return status;
    }
}

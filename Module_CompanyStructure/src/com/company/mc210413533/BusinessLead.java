package com.company.mc210413533;

import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee{
    int headCount;
    int numberOfDirectReport = 0;
    String status = "";
    //ArrayList<Accountant> reports = new ArrayList<>();
    Accountant[] reports;
    //Should create a new BusinessLead that is a Manager. The
    //BusinessLead's base salary should be twice that of an
    //Accountant. They should start with a head count of 10.
    public BusinessLead(String name){
        super(name);
        headCount =10;
        setBaseSalary(2*getBaseSalary());
        reports = new Accountant[10];
    }
    //Should return true if the number of direct reports this manager
    //has is less than their headcount.
    public boolean hasHeadCount(){
        return numberOfDirectReport < this.headCount;
    }
    //Should accept the reference to an Accountant object, and if the
    //BusinessLead has head count left should add this employee to
    //their list of direct reports. If the employee is successfully added
    //to the BusinessLead's direct reports true should be returned,
    //false should be returned otherwise. Each time a report is added
    //the BusinessLead's bonus budget should be increased by 1.1
    //times that new employee's base salary. That employee's team
    //they are supporting should be updated to reflect the reference
    //to the TechnicalLead given. If the employee is successfully added
    //true should be returned, false otherwise
    public boolean addReport(Accountant e, TechnicalLead supportTeam){

        if (hasHeadCount()) {
            reports[numberOfDirectReport]=e;
            numberOfDirectReport++;
            bonusBudget += e.getBaseSalary() * 1.1;
            return true;
        }
        return false;
    }
    //Should check if the bonus amount requested would fit in current
    //BusinessLead's budget. If it is, that employee should get that
    //bonus, the BusinessLeader's budget should be deducted and
    //true should be returned. False should be returned otherwise
    public boolean requestBonus(Employee e, double bonus){

        if(bonus <= bonusBudget) {
            e.setBaseSalary(e.getBaseSalary() + bonus);
            bonusBudget -= bonus;
            return true;
        }else{
            return false;
        }
    }
    //This function should look through the Accountants the
    //BusinessLead manages, and if any of them are supporting a the
    //TechnicalLead that is the manager of the Employee passed in
    //then the Accountant's budget should be consulted to see if the
    //bonus could be afforded. If the team can afford the bonus it
    //should be rewarded and true returned, false otherwise
    public boolean approveBonus(Employee e, double bonus){

        for (int i = 0; i < reports.length; i++) {
            if (reports[i].equals(e.getManager()) && reports[i].approveBonus(bonus)) {
                return true;
            }
        }
        return false;
    }
    public String getTeamStatus(){

        status += employeeStatus();
        if (reports.length == 0) status += " and no direct reports.\n";
        else {
            status += " and is managing: \n";
            for (int i = 0; i < reports.length; i++) {
                if(reports[i] != null) {
                    status = status + reports[i].employeeStatus() + "\n";
                }
            }
        }
        return status;
    }
}

package com.company.mc210413533;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TechnicalLead extends TechnicalEmployee{
    int headCount;
    int numberOfDirectReports;
    BusinessLead manager;
    double baseSalary;
    //ArrayList<SoftwareEngineer> listOfDirectReports = new ArrayList<>();
    //List<SoftwareEngineer> listOfDirectReports;
    SoftwareEngineer[] listOfDirectReports;
    //Should create a new TechnicalLead that is a Manager. The
    //TechnicalLead's base salary should be 1.3 times that of a
    //TechnicalEmployee. TechnicalLeads should have a default
    //head count of 4.
    public TechnicalLead(String name){
        super(name);
        headCount = 4;
        baseSalary = 1.3*getBaseSalary();
        listOfDirectReports = new SoftwareEngineer[headCount];
        numberOfDirectReports = 0;
        //listOfDirectReports = Arrays.asList(new SoftwareEngineer[headCount]);


    }
    //Should return true if the number of direct reports this
    //manager has is less than their headcount.
    public boolean hasHeadCount(){

        if(numberOfDirectReports<headCount)
        {
            return true;
        }
        return false;
    }
    //Should accept the reference to a SoftwareEngineer object,
    //and if the TechnicalLead has head count left should add this
    //employee to their list of direct reports. If the employee is
    //successfully added to the TechnicalLead's direct reports true
    //should be returned, false should be returned otherwise
    public boolean addReport(SoftwareEngineer e){
        if(hasHeadCount()){
            listOfDirectReports[numberOfDirectReports]=e;
            numberOfDirectReports++;
        }
        return false;
    }
    //Should see if the employee passed in does report to this
    //manager and if their code access is currently set to "true". If
    //both those things are true, true is returned, otherwise false
    //is returned
    public boolean approveCheckIn(SoftwareEngineer e){
        if(e.getCodeAccess() && e.equals(listOfDirectReports)){
            return true;
        }
        return false;
    }
    //Should check if the bonus amount requested would be
    //approved by the BusinessLead supporting this TechnicalLead.
    //If it is, that employee should get that bonus and true should
    //be returned. False should be returned otherwise
    public boolean requestBonus(Employee e, double bonus){

        if( manager.approveBonus(e,bonus) ) {
            e.setBaseSalary(e.getBaseSalary() + bonus);
            return true;
        }
        return false;


    }
    //Should return a String that gives insight into this Manager
    //and all their direct reports. It should return a string that is a
    //combination of the TechnicalLead's employee status
    //followed by each of their direct employee's status on
    //subsequent lines. If the TechnicalLead has no reports it
    //should print their employee status followed by the text " and
    //no direct reports yet ". Example: "10 Kasey has 5 successful
    //check ins and no direct reports yet". If the TechnicalLead
    //does have reports it might look something like "10 Kasey has
    //5 successful check ins and is managing: /n 5 Niky has 2
    //successful check ins"
    public String getTeamStatus(){
        String result;
        result = employeeStatus() + " and is managing: \n";
        if(numberOfDirectReports > 0) {
            for (int i = 0; i < headCount; i++) {
                if (listOfDirectReports[i] != null) {
                    result = result + listOfDirectReports[i].employeeStatus() + "\n";
                }
            }
        }else{
            result = result + " and no direct reports yet";
        }
        return result;
    }


}

package com.company.mc210413533;

public class SoftwareEngineer extends TechnicalEmployee {
    Boolean AccessToCode;
    int CodeCheckIns;
    TechnicalLead Manager = null;

    //Should start without access to code and with 0 code check ins
    public SoftwareEngineer(String name){
        super(name);
        AccessToCode = false;
        CodeCheckIns = 0;
    }
    //Should return whether or not this SoftwareEngineer has access to
    //make changes to the code base
    public boolean getCodeAccess(){
        return this.AccessToCode;
    }
    //Should allow an external piece of code to update the
    //SoftwareEngineer's code privileges to either true or false
    public void setCodeAccess(boolean access){
        AccessToCode = access;
    }
    //Should return the current count of how many times this
    //SoftwareEngineer has successfully checked in code
    public int getSuccessfulCheckIns(){
        return this.CodeCheckIns;
    }
    //Should check if this SoftwareEngineer's manager approves of their
    //check in. If the check in is approved their successful checkin count
    //should be increased and the method should return "true". If the
    //manager does not approve the check in the SoftwareEngineer's code
    //access should be changed to false and the method should return
    //"false"
    public boolean checkInCode(){
        if(Manager.approveCheckIn(this)){
            CodeCheckIns++;
            setCodeAccess(true);
            return true;
        }else{
            setCodeAccess(false);
            return false;
        }
    }
    public String employeeStatus(){
        return super.employeeStatus()+ " has " + getSuccessfulCheckIns() + " successful check ins.";
    }
}

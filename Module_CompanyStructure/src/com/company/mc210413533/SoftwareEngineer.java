package com.company.mc210413533;

public class SoftwareEngineer extends TechnicalEmployee {
    Boolean AccessToCode;
    int CodeCheckIns;
    TechnicalLead Manager = null;


    public SoftwareEngineer(String name){ super(name); AccessToCode = false; CodeCheckIns = 0; }

    public boolean getCodeAccess(){
        return this.AccessToCode;
    }

    public void setCodeAccess(boolean access){
        AccessToCode = access;
    }

    public int getSuccessfulCheckIns(){
        return this.CodeCheckIns;
    }

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

    public String employeeStatus(){ return super.employeeStatus()+ " has " + getSuccessfulCheckIns() + " successful check ins."; }
}

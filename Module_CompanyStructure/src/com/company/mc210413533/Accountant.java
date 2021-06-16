package com.company.mc210413533;

public class Accountant extends BusinessEmployee {
    private double total;
    private TechnicalLead teamSupported;

    public Accountant(String name){ super(name); }

    public TechnicalLead getTeamSupported(){
        return teamSupported;
    }

    public void supportTeam(TechnicalLead lead){
        this.teamSupported = lead;
        total = 0.00;
        for (int i = 0; i < lead.Reports.size(); i++) {
            total += lead.Reports.get(i).EmployeeBaseSalary;
        }
        total *=1.1;
        this.setBonusBudget(total);
    }

    public boolean approveBonus(double bonus){ return teamSupported != null && bonus < bonusBudget; }

    public String employeeStatus(){ return super.employeeStatus() +" is supporting " + this.teamSupported.getName(); }
}

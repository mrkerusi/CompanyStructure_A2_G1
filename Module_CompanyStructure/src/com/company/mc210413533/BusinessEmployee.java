package com.company.mc210413533;
import java.util.Formatter;

public class BusinessEmployee extends Employee{
    double bonusBudget = 0.00;
    Formatter df;

    public BusinessEmployee(String name){ super(name, 50000); }

    public double getBonusBudget(){ return this.bonusBudget; }

    public void setBonusBudget(double bonusBudget){ this.bonusBudget = bonusBudget;};

    public String employeeStatus(){
        df = new Formatter();
        df.format("%.1f",this.getBonusBudget());
        return super.employeeStatus() + " with a budget of " + df.toString();

    }
}

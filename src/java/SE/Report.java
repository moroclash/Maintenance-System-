/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

/**
 *
 * @author moroclash
 */
public class Report {
    
    private double presantage;
    private int EmployeNum;
    private double Salaries;
    private int Customer_ComplainNumper;
    private int Employee_ComplainNumper;

    public void setCustomer_ComplainNumper(int Customer_ComplainNumper) {
        this.Customer_ComplainNumper = Customer_ComplainNumper;
    }

    public void setEmployeNum(int EmployeNum) {
        this.EmployeNum = EmployeNum;
    }

    public void setEmployee_ComplainNumper(int Employee_ComplainNumper) {
        this.Employee_ComplainNumper = Employee_ComplainNumper;
    }

    public void setPresantage(double presantage) {
        this.presantage = presantage;
    }

    public void setSalaries(double Salaries) {
        this.Salaries = Salaries;
    }

    public int getCustomer_ComplainNumper() {
        return Customer_ComplainNumper;
    }

    public int getEmployeNum() {
        return EmployeNum;
    }

    public int getEmployee_ComplainNumper() {
        return Employee_ComplainNumper;
    }

    public double getPresantage() {
        return presantage;
    }

    public double getSalaries() {
        return Salaries;
    }
    
}

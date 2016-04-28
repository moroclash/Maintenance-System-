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
public class BranchReport extends Report{

    private Branch branch;
    private Employee Manager;
    private double Earnings;
    
    public BranchReport(Branch b) {
        this.branch = b;
        
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Branch getBranch() {
        return branch;
    }

    
    public void setEarnings(double Earnings) {
        this.Earnings = Earnings;
    }

    public double getEarnings() {
        return Earnings;
    }

    public void setManager(Employee Manager) {
        this.Manager = Manager;
    }

    public Employee getManager() {
        return Manager;
    }

    
    
    
    
    
}

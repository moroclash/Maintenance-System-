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
public class Employee extends User{
    
    private Branch My_branch;

    public void setMy_branch(Branch My_branch) {
        this.My_branch = My_branch;
    }

    public Branch getMy_branch() {
        return My_branch;
    }
    
    
}

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
public class Employee extends User
{
    private int MyBranch_id;
    public void SetMyBranchID(int Branch_id)
    {
        this.MyBranch_id=Branch_id;
    }
    public int GetMyBranchID()
    {
        return this.MyBranch_id;
    }
}

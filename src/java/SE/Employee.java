/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.sql.SQLException;


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
        return Integer.parseInt(this.getAdditional_data().get(19));
    }
  //sala7
    @Override
    public boolean Log_in(String User_Name, String Password) {
       
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result ;
        System_manage s = System_manage.Get_System_manage();
        Employee employee ;
        int id = -1;
        result = DB.Select("User_id ", " user ", " Email =  '" + User_Name + "'" + " and " + "Password = '" + Password +"'");
        int employee_id = -1;
        try {
              while(result.next())
            {
              employee_id = result.getInt("User_id");
            }
              employee = (Employee) s.Search_user_by_id(employee_id);
              setF_name(employee.getF_name());
              setL_name(employee.getL_name());
              setEmail(employee.getEmail());
              setPassword(employee.getPassword());
              setGander(employee.getGander());
              setBlock(employee.getBlock());
              setType_id(employee.getType_id());
              setPhones(employee.getPhones());
              setAddresses(employee.getAddresses());
              
              result = DB.Select(" Type_id ", " user ", " User_id = " + employee_id);
              while(result.next())
              {
                 id = result.getInt("Type_id");
              }
            switch (id) {
                case 1:
                    setAdditional_data(employee.getAdditional_data());
                    break;
                case 2:
                    setAdditional_data(employee.getAdditional_data());
                    break;
                case 3:
                    setAdditional_data(employee.getAdditional_data());
                    break;
                case 4:
                    setAdditional_data(employee.getAdditional_data());
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
              ex.printStackTrace();
              DB.Close();
        }
        return true;
    }
}

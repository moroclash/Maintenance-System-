/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.util.ArrayList;

/**
 *
 * @author moroclash
 */

public class Massage extends MSG{

    private ArrayList<Comment> My_Commint;
    private int Reciver;

    

    public void setMy_Commint(ArrayList<Comment> My_Commint) {
        this.My_Commint = My_Commint;
    }
    
    public void setReciver(int Reciver) {
        this.Reciver = Reciver;
    }

    public int getReciver() {
        return Reciver;
    }

    public ArrayList<Comment> getMy_Commint() {
        return My_Commint;
    }
    
    public void Add_Comment(Comment New_Comment)
    {
    
    }
    
    public boolean Delete_Comment(int Comment_id)
    {
        return false;
    }
}

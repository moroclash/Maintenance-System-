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
<<<<<<< HEAD
public class Massage {
     
}
=======
public class Massage extends MSG{
    private ArrayList<Comment> My_Commint;
    private int Reciver;

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
>>>>>>> 1a6159337d60f87ff7db1643928e96ef161fa4d4

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

/**
 *
 * @author Mohamed Salah
 */
public class Customer extends User{
   private String Sequrity_question;
   private String Sequrity_question_answer;
    
    public void Set_sequrity_question (String Sequrity_question)
    {
      this.Sequrity_question = Sequrity_question;
    }
    public void Set_sequrity_question_answer (String Sequrity_question_answer)
    {
       this.Sequrity_question_answer = Sequrity_question_answer;
    }
    public String Get_sequrity_question()
    {
        return this.Sequrity_question;
    }
    public String Get_sequrity_question_answer ()
    {
        return this.Sequrity_question_answer;
    }
    public boolean Make_request (Request request)
    {
      return true;  
    }
    public boolean Select_time (Time_chooser My_chooser)
    {
        return true;
    }
    public Device Trace_my_device (int Device_id)
    {
       return null; 
    }
    public boolean Make_complain (Complain complain , int Order_id)
    {
        return true;
    }
    public boolean Make_feedback (Feedback feedback , int Order_id)
    {
      return true;    
    }
    
}

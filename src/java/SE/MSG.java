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
public class MSG {
    private int Id;
    private String Date_id;
    private String Time;
    private String Content;
    private int Massage_type_id;
    private int State;

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getContent() {
        return Content;
    }

    public void setDate_id(String Date_id) {
        this.Date_id = Date_id;
    }

    public String getDate_id() {
        return Date_id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setMassage_type_id(int Massage_type_id) {
        this.Massage_type_id = Massage_type_id;
    }

    public int getMassage_type_id() {
        return Massage_type_id;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getTime() {
        return Time;
    }
    
    public void setState(int State) {
        this.State = State;
    }

    public int getState() {
        return State;
    }
    
}

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
    private String Date;
    private String Time;
    private String Content;
    private String Massage_type;
    private int State;

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getContent() {
        return Content;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getDate() {
        return Date;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setMassage_type(String Massage_type) {
        this.Massage_type = Massage_type;
    }

    public String getMassage_type() {
        return Massage_type;
    }

    public void setState(int State) {
        this.State = State;
    }

    public int getState() {
        return State;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getTime() {
        return Time;
    }
    
}

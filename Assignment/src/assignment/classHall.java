/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author zhusheng
 */
public class classHall {
    private int hallCapacity;//hall capacity
    public String hallType;//hall type
    private int hallNumber;//hall number
    private double bookingRate;
    
    public classHall(){}

    public classHall(String hallType, int hallNumber) {
        this.hallType = hallType;
        this.hallNumber = hallNumber;
        if(this.hallType=="audi")
        {
            this.hallCapacity=1000;
            this.bookingRate=300.00;
        }
        else if(this.hallType=="banquet")
        {
            this.hallCapacity=300;
            this.bookingRate=100.00;
        }
        else if(this.hallType=="meeting")
        {
            this.hallCapacity=30;
            this.bookingRate=50.00;
        }
    }        
}

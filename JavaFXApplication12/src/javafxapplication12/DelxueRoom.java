/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

/**
 *
 * @author Oluchi
 */
public class DelxueRoom extends StandardRoom{
    
    public DelxueRoom(String name, boolean safe, String arrival, String departure) {
        super(name, safe, arrival, departure);
        this.name = name ;
        this.safe = safe ;
        this.setArrival(arrival);
        this.setDeparture(departure);
        calculateNights(160);
    }
     @Override
     void Display(){
       int price = calculateNights(160);
       System.out.println(name + "/n " + price + "/n "+ selectedRoomType + "/n "+ roomNumber);
   }
}

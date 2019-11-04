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
public class JuniorRoom extends StandardRoom {
    
    public JuniorRoom(String name, boolean safe, String arrival, String departure) {
        super(name, safe, arrival, departure);
        this.name = name ;
        this.isSafe = safe ;
        this.setArrival(arrival);
        this.setDeparture(departure);
        this.calculateNights(200);
    }
    
    @Override
     void Display(){
       int price = calculateNights(200);
       System.out.println(name + "/n " + price + "/n "+ selectedRoomType + "/n "+ roomNumber);
   }
       String results(){
         int price = calculateNights(200);
         String stringPrice = Integer.toString(price);
         String newResults = "Price: " +  stringPrice + "\n " + "Room Number: "  +  roomNumber;
         return newResults;
    }   
    
   
    
}

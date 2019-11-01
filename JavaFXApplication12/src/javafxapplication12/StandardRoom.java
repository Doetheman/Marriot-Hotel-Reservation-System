/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oluchi
 */
public class StandardRoom {
   public String name;
   public String selectedRoomType;
   public Date arrival;
   public Date departure;
   public boolean safe;
   public int price;
   public boolean []rooms;
   public int roomNumber;
   
   public void StandardRoom(String name, boolean safe, String arrival, String departure){
       this.setName(name);
       this.setSelectedRoomType("Standard Room");
       this.setPrice();
       this.setSafe(safe);
       this.setArrival(arrival);
       this.setDeparture(departure);
       calculateNights(100);
       Display();
   }
   public void ReserveRoom(){
      for(int i=1; i< 46; i++){
          if(!rooms[i]){
              rooms[i] = true;
              setRoomNumber(i);
              break;
          }
      }
   }
   
   public void calculateNights(int charge){
       int nights = (int) (departure.getTime() - arrival.getTime());
       if(nights>24){
           nights = nights/24;
       } else {
           nights = 1;
       }
       price =+ charge*nights;
   }
   
   public void setDeparture(String date){
       try {
           departure =new SimpleDateFormat("dd/MM/yyyy").parse(date);
       } catch (ParseException ex) {
           Logger.getLogger(StandardRoom.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public Date getDeparture(){
       return departure;
   }
   
   public void setArrival(String date){
       try {
           arrival =new SimpleDateFormat("dd/MM/yyyy").parse(date);
       } catch (ParseException ex) {
           Logger.getLogger(StandardRoom.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public Date getArrival(){
       return arrival;
   }
   public void setRoomNumber(int number){
       roomNumber = number;
   }
   
   public int getRoomNumber(){
       return roomNumber;
   }
   public void setName(String client){
       name = client;
   }
   
   public String getName(){
       return name;
   }
   
   public int getPrice(){
       return price;
   }
   
   public void setPrice(){
       price = 0;
   }
   
   public void setSelectedRoomType(String roomType){
       selectedRoomType = roomType;
   }
   
   public String getSelectedRoomType(){
       return selectedRoomType;
   }
   
   public void setSafe(boolean safeFee){
       if(safeFee){
           this.price =+ 20;
       }
   }
   
   void Display(){
       System.out.println(name + price + selectedRoomType + roomNumber);
   }

}

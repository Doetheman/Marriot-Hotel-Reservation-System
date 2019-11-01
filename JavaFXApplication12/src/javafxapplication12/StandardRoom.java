/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication12;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
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
       this.setRooms(rooms);
       this.setName(name);
       this.setSelectedRoomType("Standard Room");
       this.setPrice();
       this.setSafe(safe);
       this.setArrival(arrival);
       this.setDeparture(departure);
       this.ReserveRoom();
       calculateNights(100);
       Display();
   }
   public void ReserveRoom(){
      for(int i=0; i< 15; i++){
          if(!this.rooms[i]){
              rooms[i] = true;
              setRoomNumber(i++);
              break;
          }
      }
   }
   
   public void calculateNights(int charge){
        long diff = departure.getTime() - arrival.getTime();
        int nights = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
       if(nights>24){
           nights = nights/24;
       } else {
           nights = 1;
       }
       price =+ charge*nights;
   }
   
   public void setRooms( boolean[]rooms){
       rooms = new boolean[15];
       for(int i=0;i<15;i++){
           rooms[i] = false;
       }
       this.rooms = rooms;
   }
   
   public void setDeparture(String date){
       try {
           departure =new SimpleDateFormat("dd/MM/yyyy").parse(date);
       } catch (ParseException ex) {
           System.out.println(ex);
       }
   }
   
   public Date getDeparture(){
       return departure;
   }
   
   public void setArrival(String date){
       try {
           arrival =new SimpleDateFormat("dd/MM/yyyy").parse(date);
       } catch (ParseException ex) {
           System.out.println(ex);
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

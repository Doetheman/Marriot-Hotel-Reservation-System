/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



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
   public String selectedRoomType = "Standard Room";
   public Date arrival;
   public Date departure;
   public boolean isSafe;
   public int safeFee;
   public int price;
   public boolean []rooms;
   public int roomNumber;
   
   public StandardRoom(String name, boolean safe, String arrival, String departure){
       this.setRooms(rooms);
       this.addSafe(safe);
       this.setName(name);
       this.setSelectedRoomType("Standard Room");
       this.setPrice();
       this.setArrival(arrival);
       this.setDeparture(departure);
       this.ReserveRoom();
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
   
   public int calculateNights(int charge){
       long diff = departure.getTime() - arrival.getTime();
       int nights = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
       if(nights == 0){
           nights = 1;
       }
       return price = charge*nights + getSafeFee();
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
       price = 100;
   }
   
   public void setSelectedRoomType(String roomType){
       selectedRoomType = roomType;
   }
   
   public String getSelectedRoomType(){
       return selectedRoomType;
   }
   
   public void addSafe(boolean checked){
       if(checked){
           this.safeFee = safeFee + 20;
       } else {
           this.safeFee = 0;
        }
   }
   
   public int getSafeFee(){
       return safeFee;
   }
   
   void Display(){
       int price = calculateNights(100);
       ReserveRoom();
       System.out.println(name + "/n " + price + "/n "+ selectedRoomType + "/n "+ roomNumber);
   }
     String results(){
         int price = calculateNights(160);
         ReserveRoom();
         String stringPrice = Integer.toString(price);
         String newResults = stringPrice + "/n " + roomNumber;
         return newResults;
    }
}

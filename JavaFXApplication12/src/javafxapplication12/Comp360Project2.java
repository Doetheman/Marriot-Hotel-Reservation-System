/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

import java.text.ParseException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

/**
 *
 * @author Oluchi
 */
public class Comp360Project2 extends Application {

    //Title Marriott Systems
    private Label ProjectTitileLabel = new Label ("Marriot Hotel Reservation System ");
 //---------------------------------------
    //Name Label
    private Label usersNameLabel = new Label ("Name:  ");
    //Name Textfeild
    private TextField nameInput = new TextField ();
 //---------------------------------------
     //Arrival and departure Label
    private Label arriveLabel = new Label ("When are you arriving:(\"dd/MM/yyyy\" )   ");
    private TextField arrivalDate = new TextField(); 
    private Label departureLabel = new Label ("When are you departing: (\"dd/MM/yyyy\" ) ");
    private TextField departureDate = new TextField(); 

//---------------------------------------
    //Select what roomn type Label 
     private Label roomSelectionLabel = new Label ("Select which room want?");
    //A radio button with the specified label
     private RadioButton standRoomRB = new RadioButton("Stand Room");
     private RadioButton deluxeRB = new RadioButton("Deluxe Room");
     private RadioButton juniorRoomRB = new RadioButton("Junior Room");
 //---------------------------------------

    //Label for if you want safe bank
     private Label safeLabel = new Label ("Is a safe included: ");
     private RadioButton safeRB= new RadioButton("Yes");
    // RadioButton
 //---------------------------------------
    //Submit
     private Button submitButton = new Button("Submit");

    // Results label
     private Label results = new Label ("");


    @Override
    public void start(Stage primaryStage) {
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                  if ((nameInput.getText() != null && arrivalDate.getText()!= null &&  departureDate.getText()!= null)) {
                        results.setText(
                                         "Name:" +  nameInput.getText() + "\n" +
                                         "Arrival Date: " + arrivalDate.getText() +  "\n" +
                                         "Departure Date: " +   departureDate.getText() + "\n" +
                                         determineRoom()
                                         );
                   } else {
                        results.setText("You have not left a comment.");
                   }
              // results.setText();
            }
        });
        
        
        VBox entireThing = new VBox();
        HBox top = new HBox();
        HBox sec1 = new HBox();
        VBox sec2 = new VBox();
        VBox sec4 = new VBox();
        HBox sec3 = new HBox();
        HBox bottom = new HBox();

        top.getChildren().addAll(getProjectTitileLabel());
        sec1.getChildren().addAll(getUsersNameLabel(), getNameInput());
        sec2.getChildren().addAll(getRoomSelectionLabel(), getStandRoomRB(), getDeluxeRB(), getJuniorRoomRB());
        sec3.getChildren().addAll(getSafeLabel(), getSafeRB());
        sec4.getChildren().addAll(getArriveLabel(), getArrivalDate(), getDepartureLabel(), getDepartureDate());
        bottom.getChildren().addAll(getSubmitButton());
        bottom.getChildren().addAll(getResults());
        entireThing.getChildren().addAll(top,sec1,sec4,sec2,sec3, bottom);

        StackPane root = new StackPane();
        root.getChildren().add(entireThing);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        System.out.println();
//        StandardRoom rm = new StandardRoom();
//        rm.StandardRoom("Dorian",true, "11/01/2019", "11/02/2019");
    }
    /**
     * @return the ProjectTitileLabel
     */
    public Label getProjectTitileLabel() {
        return ProjectTitileLabel;
    }
    
    public String determineRoom(){
        if (standRoomRB.isSelected()){
           StandardRoom rm = new StandardRoom(this.nameInput.getText(),safeRB.isSelected(),this.arrivalDate.getText(),this.departureDate.getText());
           rm.Display();
           return rm.results();
        }
        if(deluxeRB.isSelected()){
            DelxueRoom dm = new DelxueRoom(this.nameInput.getText(),safeRB.isSelected(),this.arrivalDate.getText(),this.departureDate.getText());
            dm.Display();
            return dm.results();
        }
        if(juniorRoomRB.isSelected()){
            JuniorRoom jm = new JuniorRoom(this.nameInput.getText(),safeRB.isSelected(),this.arrivalDate.getText(),this.departureDate.getText());
            jm.Display();
            return jm.results();
        }
        return " ";
    }

    /**
     * @param ProjectTitileLabel the ProjectTitileLabel to set
     */
    public void setProjectTitileLabel(Label ProjectTitileLabel) {
        this.ProjectTitileLabel = ProjectTitileLabel;
    }

    /**
     * @return the usersNameLabel
     */
    public Label getUsersNameLabel() {
        return usersNameLabel;
    }

    /**
     * @param usersNameLabel the usersNameLabel to set
     */
    public void setUsersNameLabel(Label usersNameLabel) {
        this.usersNameLabel = usersNameLabel;
    }

    /**
     * @return the nameInput
     */
    public TextField getNameInput() {
        return nameInput;
    }

    /**
     * @param nameInput the nameInput to set
     */
    public void setNameInput(TextField nameInput) {
        this.nameInput = nameInput;
    }

    /**
     * @return the arriveLabel
     */
    public Label getArriveLabel() {
        return arriveLabel;
    }

    /**
     * @param arriveLabel the arriveLabel to set
     */
    public void setArriveLabel(Label arriveLabel) {
        this.arriveLabel = arriveLabel;
    }

 

    /**
     * @return the departureLabel
     */
    public Label getDepartureLabel() {
        return departureLabel;
    }

    /**
     * @param departureLabel the departureLabel to set
     */
    public void setDepartureLabel(Label departureLabel) {
        this.departureLabel = departureLabel;
    }

    /**
     * @return the roomSelectionLabel
     */
    public Label getRoomSelectionLabel() {
        return roomSelectionLabel;
    }

    /**
     * @param roomSelectionLabel the roomSelectionLabel to set
     */
    public void setRoomSelectionLabel(Label roomSelectionLabel) {
        this.roomSelectionLabel = roomSelectionLabel;
    }

    /**
     * @return the standRoomRB
     */
    public RadioButton getStandRoomRB() {
        return standRoomRB;
    }

    /**
     * @param standRoomRB the standRoomRB to set
     */
    public void setStandRoomRB(RadioButton standRoomRB) {
        this.standRoomRB = standRoomRB;
    }

    /**
     * @return the deluxeRB
     */
    public RadioButton getDeluxeRB() {
        return deluxeRB;
    }

    /**
     * @param deluxeRB the deluxeRB to set
     */
    public void setDeluxeRB(RadioButton deluxeRB) {
        this.deluxeRB = deluxeRB;
    }

    /**
     * @return the juniorRoomRB
     */
    public RadioButton getJuniorRoomRB() {
        return juniorRoomRB;
    }

    /**
     * @param juniorRoomRB the juniorRoomRB to set
     */
    public void setJuniorRoomRB(RadioButton juniorRoomRB) {
        this.juniorRoomRB = juniorRoomRB;
    }

    /**
     * @return the safeLabel
     */
    public Label getSafeLabel() {
        return safeLabel;
    }

    /**
     * @param safeLabel the safeLabel to set
     */
    public void setSafeLabel(Label safeLabel) {
        this.safeLabel = safeLabel;
    }

    /**
     * @return the safeRB
     */
    public RadioButton getSafeRB() {
        return safeRB;
    }

    /**
     * @param safeRB the safeRB to set
     */
    public void setSafeRB(RadioButton safeRB) {
        this.safeRB = safeRB;
    }

    /**
     * @return the submitButton
     */
    public Button getSubmitButton() {
        return submitButton;
    }

    /**
     * @param submitButton the submitButton to set
     */
    public void setSubmitButton(Button submitButton) {
        this.submitButton = submitButton;
    }

    /**
     * @return the results
     */
    public Label getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(Label results) {
        this.results = results;
    }

    /**
     * @return the arrivalDate
     */
    public TextField getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @param arrivalDate the arrivalDate to set
     */
    public void setArrivalDate(TextField arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * @return the departureDate
     */
    public TextField getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departureDate to set
     */
    public void setDepartureDate(TextField departureDate) {
        this.departureDate = departureDate;
    }

}

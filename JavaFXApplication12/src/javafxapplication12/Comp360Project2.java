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

    //Select what roomn type Label
     private Label roomSelectionLabel = new Label ("Select which room want?");
    //A radio button with the specified label
     private RadioButton standRoomRB = new RadioButton("Stand Room");
     private RadioButton deluxeRB = new RadioButton("Deluxe Room");
     private RadioButton juniorRoomRB = new RadioButton("Junior Room");
 //---------------------------------------

    //Label for if you want safe bank
     private Label safeLabel = new Label ("Is a safe included ?: ");
     private RadioButton safeRB= new RadioButton("Yes");
    // RadioButton
 //---------------------------------------
    //Submit
     Button submitButton = new Button("Submit");

    // Results label
     private Label results = new Label ("");


    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
        VBox entireThing = new VBox();
        HBox top = new HBox();
        HBox sec1 = new HBox();
        VBox sec2 = new VBox();
        HBox sec3 = new HBox();
        HBox bottom = new HBox();

        top.getChildren().addAll(ProjectTitileLabel);
        sec1.getChildren().addAll(usersNameLabel,nameInput);
        sec2.getChildren().addAll(roomSelectionLabel,standRoomRB,deluxeRB, juniorRoomRB);
        sec3.getChildren().addAll(safeLabel,safeRB);
        bottom.getChildren().addAll(submitButton,results);
        entireThing.getChildren().addAll(top,sec1,sec2,sec3,bottom);

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
        System.out.println("hello");
        StandardRoom rm = new StandardRoom();
        rm.StandardRoom("Dorian",true, "11/01/2019", "11/02/2019");
    }

}

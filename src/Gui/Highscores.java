package Gui;

import java.awt.Color;
import javafx.scene.layout.AnchorPane;
import Game.GameController;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;

import javafx.util.Duration;

import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;
import sun.audio.AudioPlayer;



public class Highscores {
    
    private Scene scene;
    private Pane pane = new Pane();
    private GameController gamecontroller = GameController.getInstance();
    private MediaPlayer mediaPlayer;
    TextArea textArea = new TextArea();
   
    


    public Highscores(Stage stage) {
       // textArea.setStyle("-fx-background-color: transparent;");
        textArea.setLayoutX(550);
                textArea.setLayoutY(200);
                textArea.setLayoutX(100);
                textArea.setPrefSize(1000,500);
                textArea.setStyle("-fx-text-fill: black;");
                textArea.setFont(new Font(25));
                textArea.setStyle("-fx-background-color: transparent;");

        Media sound = new Media(Paths.get("Audio/ScoreBoard.mp3").toUri().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.play();
        
        
        
        //Label
        Label label = new Label("Welcome to Score Board!");
        label.setPrefHeight(63);
        label.setPrefWidth(1200);
        label.setLayoutX(300);
        label.setLayoutY(34);
        label.setFont(new Font(60));
        label.setStyle("-fx-text-fill: white;");
      
        //Background
        Image image = new Image("file:images/Highscores.jpg");
        ImageView BackGround = new ImageView(image);
        pane.getChildren().add(BackGround);
        scene=new Scene(pane,1200,800);
        stage.setScene(scene);
        BackGround.setPreserveRatio(false);
        BackGround.setFitWidth(1220);
        BackGround.setFitHeight(820);
         
         //Arcade Button
         FileInputStream input1 = null;    
        try {
            input1 = new FileInputStream("images/Arcade.png");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Highscores.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image i1 = new Image(input1); 
        ImageView iw1 = new ImageView(i1); 
        Button Arcade = new Button("",iw1);
         Arcade.setPrefSize(10, 10);
         Arcade.setStyle("-fx-background-color: transparent;");
         Arcade.setLayoutX(950);
         Arcade.setLayoutY(700);
       
         //Easy Button
         FileInputStream input2 = null;    
        try {
            input2 = new FileInputStream("images/EasyButton.png");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Highscores.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image i2 = new Image(input2); 
        ImageView iw2 = new ImageView(i2); 
        Button Easy = new Button("",iw2);
         Easy.setPrefSize(10, 10);
         Easy.setStyle("-fx-background-color: transparent;");
         Easy.setLayoutX(50);
         Easy.setLayoutY(700);
        
        //Medium Button
        FileInputStream input3 = null;    
        try {
            input3 = new FileInputStream("images/MediumButtonnew.png");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Highscores.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image i3 = new Image(input3); 
        ImageView iw3 = new ImageView(i3); 
        Button Medium = new Button("",iw3);
         Medium .setPrefSize(10, 10);
         Medium .setStyle("-fx-background-color: transparent;");
         Medium .setLayoutX(350);
         Medium .setLayoutY(700);
        
        //Hard Button
        FileInputStream input4 = null;    
        try {
            input4 = new FileInputStream("images/HardButtonnew.png");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Highscores.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image i4 = new Image(input4); 
        ImageView iw4 = new ImageView(i4); 
        Button Hard = new Button("",iw4);
         Hard .setPrefSize(10, 10);
         Hard .setStyle("-fx-background-color: transparent;");
         Hard .setLayoutX(650);
         Hard .setLayoutY(700);
      
         //Back Button
        FileInputStream input5 = null;    
        try {
            input5 = new FileInputStream("images/BackButton.png");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Highscores.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image i5 = new Image(input5); 
        ImageView iw5 = new ImageView(i5); 
        Button Back = new Button("",iw5);
         Back .setPrefSize(10, 10);
         Back .setStyle("-fx-background-color: transparent;");
         Back .setLayoutX(20);
         Back .setLayoutY(20);
        
        
          Arcade.setOnAction(e->{
              textArea.setText("");
             gamecontroller.getScores().forEach((player) -> {
                 
                if(player.getDifficulty().equalsIgnoreCase("Arcade"))
                {
                    textArea.appendText(player.getScore()+"\n");
                }
            });
        });
          
           Easy.setOnAction(e->{
               textArea.setText("");
               gamecontroller.getScores().forEach((player) -> {
                   
                if(player.getDifficulty().equalsIgnoreCase("ClassicEasy"))
                {
                    textArea.appendText(player.getScore()+"\n");
                }
            });
        });
           
            Medium.setOnAction(e->{
                textArea.setText("");
                gamecontroller.getScores().forEach((player) -> {
                    
                if(player.getDifficulty().equalsIgnoreCase("ClassicMedium"))
                {
                    textArea.appendText(player.getScore()+"\n");
                }
            });
        });
            
            
             Hard.setOnAction(e->{  
                 textArea.setText("");
                 gamecontroller.getScores().forEach((player) -> {
                     
                if(player.getDifficulty().equalsIgnoreCase("ClassicHard"))
                {
                    textArea.appendText(player.getScore()+"\n");
                   
                }
            });
        });
             
                Back.setOnAction(e->{
        mediaPlayer.stop();           
        StartMenu startMenu = new StartMenu(stage);
        stage.setScene(startMenu.getScene());
        stage.centerOnScreen();
        });
               
                 Pane pane = new Pane();
                 Image cursor1 = new Image("file:images/cursor.gif");
                 ImageCursor cursor = new ImageCursor(cursor1);
                 pane.setCursor(cursor);
      
         
                scene = new Scene(pane,1200,800);
        
    pane.getChildren().addAll(BackGround,Arcade,Easy,Medium,Hard,label,Back,textArea);
                 }
       
    public Scene getScene() {
        return scene;
    }

    
}

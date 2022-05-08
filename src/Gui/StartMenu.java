package Gui;

import Game.GameController;
import Game.HighScores;
import Modes.Arcade;
import Modes.Classic;
import Modes.Easy;
import Modes.Hard;
import Modes.IStrategy;
import Modes.Medium;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.lang.Runnable;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.ImageCursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class StartMenu {
    
    private Scene scene;
    private GameController gamecontroller = GameController.getInstance();
    private MediaPlayer startMenuMusic;
    
    StartMenu(Stage primarystage) 
    {
       
        Media sound = new Media(Paths.get("Audio/starting_background_music.mp3").toUri().toString());
        startMenuMusic = new MediaPlayer(sound);
        startMenuMusic.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                startMenuMusic.seek(Duration.ZERO);
            }
        });
         startMenuMusic.play();
         
         GameController gamecontroller = GameController.getInstance();
         
         Image image = new Image("file:images/background.jpg");
         Image icon = new Image("file:images/icon.png");
         Image logo = new Image("file:images/logo.png");
         
         ImageView BackGround = new ImageView(image);
         ImageView Logo = new ImageView(logo);
         
         AnchorPane root = new AnchorPane();
         root.getChildren().add(BackGround);
         
         scene=new Scene(root,1200,800);
         primarystage.setScene(scene);
         primarystage.getIcons().add(icon);
         primarystage.centerOnScreen();
      
         
         BackGround.setPreserveRatio(false);
         BackGround.setFitWidth(1220);
         BackGround.setFitHeight(820);
         
         Logo.setLayoutX(250);
         Logo.setLayoutY(40);
         Logo.setPreserveRatio(false);
         
      
        FileInputStream inputEasy = null;
        FileInputStream inputMedium = null;
        FileInputStream inputHard = null;
        FileInputStream inputArcade = null;
        FileInputStream inputHighscore = null;
        
        try {
            inputEasy = new FileInputStream("images/EasyButton.png");
            inputMedium = new FileInputStream("images/MediumButtonnew.png");
            inputHard = new FileInputStream("images/HardButtonnew.png");
            inputArcade = new FileInputStream("images/Arcade.png");
            inputHighscore = new FileInputStream("images/HighScorenew.png");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StartMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image easy = new Image(inputEasy);
        ImageView imageViewEasy = new ImageView(easy);
         
        Image medium = new Image(inputMedium);
        ImageView imageViewMedium = new ImageView(medium);
         
        Image hard = new Image(inputHard);
        ImageView imageViewHard = new ImageView(hard);

        Image arcade = new Image(inputArcade);
        ImageView imageViewArcade = new ImageView(arcade);
         
        Image Highscore = new Image(inputHighscore);
        ImageView imageViewHighscore = new ImageView(Highscore);
         
         
         
         Button EasyButton = new Button("",imageViewEasy);
         EasyButton.setLayoutX(100);
         EasyButton.setLayoutY(450);
         EasyButton.setStyle("-fx-background-color: transparent;");
         EasyButton.setPrefWidth(0);
         EasyButton.setPrefHeight(0);
        
         Button MediumButton = new Button("",imageViewMedium);
         MediumButton.setLayoutX(350);
         MediumButton.setLayoutY(450);
         MediumButton.setStyle("-fx-background-color: transparent;");
         MediumButton.setPrefWidth(0);
         MediumButton.setPrefHeight(0);
        
         Button HardButton = new Button("",imageViewHard);
         HardButton.setLayoutX(600);
         HardButton.setLayoutY(450);
         HardButton.setStyle("-fx-background-color: transparent;");
         HardButton.setPrefWidth(0);
         HardButton.setPrefHeight(0);
        
         Button ArcadeButton = new Button("",imageViewArcade);
         ArcadeButton.setLayoutX(900);
         ArcadeButton.setLayoutY(450);
         ArcadeButton.setStyle("-fx-background-color: transparent;");
         ArcadeButton.setPrefWidth(0);
         ArcadeButton.setPrefHeight(0);
       
         Button HighscoreButton = new Button("",imageViewHighscore);
         HighscoreButton.setLayoutX(480);
         HighscoreButton.setLayoutY(650);
         HighscoreButton.setStyle("-fx-background-color: transparent;");
         HighscoreButton.setPrefWidth(0);
         HighscoreButton.setPrefHeight(0);
        
        
          ArcadeButton.setOnAction(e->{
        	startMenuMusic.stop();
                IStrategy gameMode = new Arcade() {};
                gamecontroller.newGame(gameMode);
                
            Game guiGameplayView = new Game(primarystage);
            primarystage.setScene(guiGameplayView.getScene());
            primarystage.centerOnScreen();

        });
          
             EasyButton.setOnAction(e->{
        	startMenuMusic.stop();
                IStrategy gameMode = new Classic() {};
                gamecontroller.newGame(new Easy(gameMode));
            Game guiGameplayView = new Game(primarystage);
            primarystage.setScene(guiGameplayView.getScene());
            primarystage.centerOnScreen();

        });
                MediumButton.setOnAction(e->{
        	startMenuMusic.stop();
                IStrategy gameMode = new Classic() {};
                gamecontroller.newGame(new Medium(gameMode));
                
                Game guiGameplayView = new Game(primarystage);
                primarystage.setScene(guiGameplayView.getScene());
                primarystage.centerOnScreen();

        });
                
                HardButton.setOnAction(e->{
        	startMenuMusic.stop();
                IStrategy gameMode = new Classic() {};
                gamecontroller.newGame(new Hard(gameMode));                
                Game guiGameplayView = new Game(primarystage);
                primarystage.setScene(guiGameplayView.getScene());
                primarystage.centerOnScreen();

        });
          
           HighscoreButton.setOnAction(e->{
          
               startMenuMusic.stop();
            
             Highscores highscores = new Highscores(primarystage);
             primarystage.setScene(highscores.getScene());
             primarystage.centerOnScreen();
        });
         
         Pane pane = new Pane();
        Image cursor1 = new Image("file:images/cursor.gif");
        ImageCursor cursor = new ImageCursor(cursor1);
        pane.setCursor(cursor);
      
         scene = new Scene(pane,1200,800);
         pane.getChildren().addAll(BackGround,Logo,EasyButton,MediumButton,HardButton,ArcadeButton,HighscoreButton);
         
         
         
    }
    
     public Scene getScene() {
        return scene;
    }
}
package Gui;

import Commands.Controller;
import Commands.FileCommand;
import Commands.ICommand;
import Game.GameController;
import Game.Player;
import Modes.Arcade;
import Modes.IStrategy;
import Objects.IObject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game {
    
    private Scene scene;
    private Pane pane = new Pane();
    private GameController gamecontroller = GameController.getInstance();
    
    private MediaPlayer gamePlayMusic;
    private MediaPlayer gameOverMusic;
    
    private AnimationTimer timer;
    private long startTime = System.currentTimeMillis();
    private long old = 0;
    private int secs = 0, mins = 0;
    
    private boolean runFlag = true;
        private Controller controller =new Controller();
	private ICommand command= new FileCommand();
        
        Player player = new Player();
        

    Game(Stage stage){
        
         Media GamePlaySound = new Media(Paths.get("Audio/game_background_sound.mp3").toUri().toString());
         gamePlayMusic = new MediaPlayer(GamePlaySound);
       
         Media GameOverSound = new Media(Paths.get("Audio/end_game_sound.mp3").toUri().toString());
         gameOverMusic = new MediaPlayer(GameOverSound);
         
         Image image = new Image("file:images/background.jpg");
         ImageView BackGround = new ImageView(image);
         BackGround.setMouseTransparent(true);
         BackGround.setPreserveRatio(false);
         BackGround.setFocusTraversable(false);
         BackGround.setFitWidth(1220);
         BackGround.setFitHeight(820);
         
        Label scoreLabel = new Label("Score: " + gamecontroller.getScore());
         scoreLabel.setFont(Font.font("Verdana", 20));
         scoreLabel.setTextFill(Color.WHITE);
         scoreLabel.setPrefHeight(50);
         scoreLabel.setPrefWidth(300);
         scoreLabel.setLayoutX(550);
         scoreLabel.setLayoutY(40);
         gamecontroller.addObserver(scoreLabel);
         
         
         FileInputStream ipause = null;
         FileInputStream iresume = null;
         FileInputStream ireset = null;
         FileInputStream iback = null;
        try {
            ipause = new FileInputStream("images/pause_button.png");
            iresume = new FileInputStream("images/resume_button.png");
            ireset = new FileInputStream("images/Reset.png");
            iback = new FileInputStream("images/MainMenu.png");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
         Image pause = new Image(ipause);
         ImageView imageViewPause = new ImageView(pause);
         Button PauseButton = new Button("",imageViewPause);
         PauseButton.setLayoutX(15);
         PauseButton.setLayoutY(15);
         PauseButton.setStyle("-fx-background-color: transparent;");
         PauseButton.setPrefWidth(0);
         PauseButton.setPrefHeight(0);
        
         Image resume = new Image(iresume);
         ImageView imageViewResume = new ImageView(resume);
         Button ResumeButton = new Button("",imageViewResume);
         ResumeButton.setLayoutX(15);
         ResumeButton.setLayoutY(15);
         ResumeButton.setStyle("-fx-background-color: transparent;");
         ResumeButton.setPrefWidth(0);
         ResumeButton.setPrefHeight(0);
         ResumeButton.setVisible(false);
        
         Image reset = new Image(ireset);
         ImageView imageViewReset = new ImageView(reset);
         Button ResetButton = new Button("",imageViewReset);
         ResetButton.setLayoutX(630);
         ResetButton.setLayoutY(380);
         ResetButton.setStyle("-fx-background-color: transparent;");
         ResetButton.setPrefWidth(0);
         ResetButton.setPrefHeight(0);
         ResetButton.setVisible(false);
        
         Image back = new Image(iback);
         ImageView imageViewBack = new ImageView(back);
         Button BackButton = new Button("",imageViewBack);
         BackButton.setLayoutX(430);
         BackButton.setLayoutY(380);
         BackButton.setStyle("-fx-background-color: transparent;");
         BackButton.setPrefWidth(0);
         BackButton.setPrefHeight(0);
         BackButton.setVisible(false);
        
         Label timePlayed = new Label("time: " +gamecontroller.getTime());
         timePlayed.setFont(Font.font("Verdana", FontWeight.BOLD, 17));
         timePlayed.setTextFill(Color.WHITE);
         timePlayed.setPrefHeight(50);
         timePlayed.setPrefWidth(400);
         timePlayed.setLayoutX(550);
         timePlayed.setLayoutY(70);
         
         Label best = new Label("Best: " +gamecontroller.Best(gamecontroller.difficulty()));
         best.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
         best.setTextFill(Color.GOLDENROD);
         best.setPrefHeight(50);
         best.setPrefWidth(400);
         best.setLayoutX(550);
         best.setLayoutY(100);
         
         Label timerLabel = new Label("TIME LEFT:  " + gamecontroller.getTime()); 
         timerLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 22));
         timerLabel.setTextFill(Color.WHITE);
         timerLabel.setPrefHeight(50);
         timerLabel.setPrefWidth(200);
         timerLabel.setLayoutX(950);
         timerLabel.setLayoutY(40);
        if (gamecontroller.getTime() < 0) {
            timerLabel.setVisible(false);
        }
         
        
           PauseButton.setOnAction(e->{
              ResumeButton.setVisible(true);
              ResetButton.setVisible(true);
              BackButton.setVisible(true);
              PauseButton.setVisible(false);
              gamePlayMusic.pause();
               runFlag=false;
        	timer.stop();
        });        
     
           ResumeButton.setOnAction(e->{
               PauseButton.setVisible(true);
               ResumeButton.setVisible(false);
              ResetButton.setVisible(false);
              BackButton.setVisible(false);
               runFlag=true;
               gamePlayMusic.play();
        	timer.start();
        });    
           
         BackButton.setOnAction(e->{
            gamePlayMusic.stop();           
            StartMenu startMenu = new StartMenu(stage);
            stage.setScene(startMenu.getScene());
            stage.centerOnScreen();
        });
        
         ResetButton.setOnAction(e -> {
            gameOverMusic.stop();
            gamePlayMusic.stop(); 
            if (gamecontroller.difficulty().equalsIgnoreCase("Arcade")){

                IStrategy gameMode = new Arcade() {};
                gamecontroller.newGame(gameMode);
                
            Game guiGameplayView2 = new Game(stage);
            stage.setScene(guiGameplayView2.getScene());
            stage.centerOnScreen();
           }
           else {
               
            gamecontroller.ResetGame();
            Game guiGameplayView = new Game(stage);
            stage.setScene(guiGameplayView.getScene());
            stage.centerOnScreen();
           }
        });
        scene = new Scene(pane,1200,800);
        
          Image lives3 = new Image ("file:images/lives3.png");
         ImageView lives_3 = new ImageView(lives3);
         
         Image lives2 = new Image ("file:images/lives2.png");
         ImageView lives_2 = new ImageView(lives2);
         
         Image lives1 = new Image ("file:images/lives1.png");
         ImageView lives_1 = new ImageView(lives1);
         
         
         lives_3.setLayoutX(1050);
         lives_3.setLayoutY(40);
         lives_3.setPreserveRatio(false);
         
         lives_2.setLayoutX(1050);
         lives_2.setLayoutY(40);
         lives_2.setPreserveRatio(false);
         
         lives_1.setLayoutX(1050);
         lives_1.setLayoutY(40);
         lives_1.setPreserveRatio(false);
         
        
        Image cursor1 = new Image("file:images/cursor.gif");
        ImageCursor cursor = new ImageCursor(cursor1);
        pane.setCursor(cursor);
      
        pane.getChildren().addAll(BackGround,scoreLabel,lives_3,lives_2,lives_1,timePlayed,best,timerLabel,PauseButton,ResumeButton,ResetButton,BackButton);
   
         ArrayList<IObject> myObjects = new ArrayList<>();
         ArrayList<IObject> objectsToRemove = new ArrayList<>();
         ArrayList<IObject> objectsToSlice = new ArrayList<>();
         HashMap<ImageView,IObject> objectsOnScreen = new HashMap<>();
           
         
         gamePlayMusic.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                gamePlayMusic.seek(Duration.ZERO);
            }
        });
        gamePlayMusic.play();

          timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                long timepassed = System.currentTimeMillis() - startTime;
                long secondspassed = timepassed / 1000;

                if (secondspassed > old) {
                    gamecontroller.EditTime(-secondspassed + old);
                    old = secondspassed;
                }
                timerLabel.setText("TIME LEFT: " + gamecontroller.getTime());
                secs = (int) secondspassed % 60;
                mins = (int) secondspassed / 60;
                timePlayed.setText("time:  " + mins + " : " + secs);
                
                if(myObjects.size() < 1){
                    List<IObject> newMyObjects = gamecontroller.createGameObject(1);
                    myObjects.addAll(newMyObjects);
                    
                    for (IObject object : myObjects) {
                        updateLivesPic(lives_3,lives_2,lives_1);
                        objectsOnScreen.put(object.getImageView(), object);
                        object.getImageView().setOnMouseMoved(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (objectsOnScreen.get(event.getTarget()).IsSliced() == false && runFlag == true) {
                                    objectsToSlice.add(objectsOnScreen.get(event.getTarget()));
                                }
                            }
                        });
                        pane.getChildren().add(object.getImageView());
                    }
                }
                gamecontroller.updateObjectsLocations(myObjects, objectsToRemove);
                
               slice(objectsToSlice);
               objectsToSlice.clear();
               myObjects.removeAll(objectsToRemove);
               moveOffScreen(objectsToRemove);
               objectsToRemove.clear();
               
               if (gamecontroller.getScore() > gamecontroller.Best(gamecontroller.difficulty()))
               {
                   best.setText("Best: " + gamecontroller.getScore());
                   scoreLabel.setText("Score: " + gamecontroller.getScore());
               }
               if (gamecontroller.GameOver())
               {
                PauseButton.setVisible(false);
                endGame(stage);    
               }
              
            }
         };
         timer.start();
       
    }
    
    public void updateLivesPic(ImageView lives_3,ImageView lives_2,ImageView lives_1){
        
        switch (gamecontroller.getLives()) {
            case 3:
                lives_3.setVisible(true);
                lives_2.setVisible(false);
                lives_1.setVisible(false);
                break;
            case 2:
                lives_3.setVisible(false);
                lives_2.setVisible(true);
                lives_1.setVisible(false);
                break;
            case 1:
                lives_3.setVisible(false);
                lives_2.setVisible(false);
                lives_1.setVisible(true);
                break;
            default:
                lives_3.setVisible(false);
                lives_2.setVisible(false);
                lives_1.setVisible(false);
                break;
        }
    }
    
     public void endGame(Stage stage){
             
         timer.stop();
         gamePlayMusic.stop();
         player.setDifficulty(gamecontroller.difficulty());
         player.setScore(gamecontroller.getScore());
         gamecontroller.AddScore(player);  
        
         FileInputStream iback = null;
         FileInputStream ireset = null;
        try {
            iback = new FileInputStream("images/MainMenu.png");
            ireset = new FileInputStream("images/Reset.png");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } 
         Image back = new Image(iback);
         ImageView imageViewBack = new ImageView(back);
         Button BackButton = new Button("",imageViewBack);
         BackButton.setLayoutX(430);
         BackButton.setLayoutY(380);
         BackButton.setStyle("-fx-background-color: transparent;");
         BackButton.setPrefWidth(0);
         BackButton.setPrefHeight(0);
         
         
         gameOverMusic.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                gameOverMusic.seek(Duration.ZERO);
            }
        });
        gameOverMusic.play();
         
        BackButton.setOnAction(e->{
            gamePlayMusic.stop();           
            StartMenu startMenu = new StartMenu(stage);
            stage.setScene(startMenu.getScene());
            stage.centerOnScreen();
        });
        
        
         Image reset = new Image(ireset);
         ImageView imageViewReset = new ImageView(reset);
         Button ResetButton = new Button("",imageViewReset);
         ResetButton.setLayoutX(630);
         ResetButton.setLayoutY(380);
         ResetButton.setStyle("-fx-background-color: transparent;");
         ResetButton.setPrefWidth(0);
         ResetButton.setPrefHeight(0);
         
        ResetButton.setOnAction(e -> {
            gameOverMusic.stop();
            gamePlayMusic.stop(); 
            if (gamecontroller.difficulty().equalsIgnoreCase("Arcade")){

                IStrategy gameMode = new Arcade() {};
                gamecontroller.newGame(gameMode);
                
            Game guiGameplayView2 = new Game(stage);
            stage.setScene(guiGameplayView2.getScene());
            stage.centerOnScreen();
           }
           else {
               
            gamecontroller.ResetGame();
            Game guiGameplayView = new Game(stage);
            stage.setScene(guiGameplayView.getScene());
            stage.centerOnScreen();
           }
        });
        
        Label label = new Label("GAME OVER!! Your score is    "+gamecontroller.getScore());
        label.setTextFill(Color.WHITESMOKE);
        label.setLayoutX(475);
        label.setLayoutY(400);
        label.setPrefWidth(800);
        label.setPrefHeight(450);
        label.setFont(Font.font("Agency FB",30));
        label.setPrefHeight(450);
        label.setFont(Font.font("Agency FB",30));

        
                controller.setCommand(command);
                controller.activateButton();
       pane.getChildren().addAll(label,BackButton,ResetButton);
        
         }
    
    public void moveOffScreen(List<IObject> objectsToRemove) {
        gamecontroller.throwOffScreen(objectsToRemove);
    }
    
    public void slice(List<IObject> objectsToSlice) {

        gamecontroller.sliceObjects(objectsToSlice);

        for (IObject object : objectsToSlice) {
            object.getImageView().setImage(object.getMyImage()[1]);
        }
    }
    
    
    public Scene getScene() {
        return scene;
    }


    public void backToMainMenu(Stage stage) {
        gamePlayMusic.stop();
        gameOverMusic.stop();
        StartMenu backtoStart = new StartMenu(stage);
        stage.setScene(backtoStart.getScene());
        stage.centerOnScreen();
    }
}

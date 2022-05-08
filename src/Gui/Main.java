package Gui;

import Commands.Controller;
import Commands.FileCommand;
import Commands.ICommand;
import Game.Player;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
    
     private Controller controller =new Controller();
     
     private ICommand command= new FileCommand();
     
     public static void main(String[] args) {
        launch(args);
    }

     
    @Override
    public void start(Stage stage) {
 
        controller.setCommand(command);
        controller.unactivateButton();
        StartMenu startMenu = new StartMenu(stage);
        stage.setScene(startMenu.getScene());
        stage.setTitle("Fruit Ninja");
        stage.centerOnScreen();
        stage.show();
        stage.setResizable(false);
    }
    
     
    
}

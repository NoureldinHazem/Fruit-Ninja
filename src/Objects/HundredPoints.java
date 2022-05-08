package Objects;

import Game.GameController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import java.nio.file.Paths;


public class HundredPoints extends Fruits {
    private GameController gamecontroller = GameController.getInstance();
    
    public HundredPoints(){
        this.YCoordinate=800;
        this.XCoordinate=random.nextInt(1000);
        this.Type="ExtraPoints";
        this.ScoreIncrease=100;
        this.IsSliced=false;
        this.FallingVelocity=10;
        this.TakeOffVelocity=30;
        this.LifeDecrease=0;
        if (random.nextBoolean()) {
        this.XVelocity = TakeOffVelocity+random.nextInt(10);
        }
        else {
            this.XVelocity=-1*(TakeOffVelocity+random.nextInt(10));
        }
    this.YVelocity=TakeOffVelocity/5;
    
    this.myImageView.setLayoutX(XCoordinate);
    this.myImageView.setLayoutY(YCoordinate);
    this.localPrefSize = standardPrefSize*0.9;
    this.myImageView.setFitWidth(localPrefSize);
    this.myImageView.setFitHeight(localPrefSize);
    this.slashClip = new AudioClip("file:Audio/pristine.mp3");
    this.myImageView = new ImageView(this.getMyImage()[0]);

    }
    
    
    
    
    
    

    @Override
    public Image[] getMyImage() {
        Image[] View= new Image[4];
        View [0]=new Image("file:images/Pomegranate.png");
        View [1]=new Image("file:images/100.png");

        return View;
    }
    

    
    
    
    
    
    
      
}

package Objects;

import Game.GameController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import java.nio.file.Paths;


public class ExtraLife extends Fruits {
    private GameController gamecontroller = GameController.getInstance();

    @Override
    public int slice() {
        if (gamecontroller.getLives()<3){
        gamecontroller.EditLives(1);
        }
        return 0;
    }
    
    
    public ExtraLife(){
        this.YCoordinate=800;
        this.XCoordinate=random.nextInt(1000);
        this.Type="ExtraLife";
        this.ScoreIncrease=0;
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
    this.slashClip = new AudioClip(Paths.get("Audio/pristine.mp3").toUri().toString());
    this.myImageView = new ImageView(this.getMyImage()[0]);

    }
    
    
    
    
    
    

    @Override
    public Image[] getMyImage() {
        Image[] View= new Image[4];
        View [0]=new Image("file:images/ExtraLife.png");
        View [1]=new Image("file:images/ExtraLifeCut.png");
        

        return View;
    }
    

    
    
    
    
    
    
      
}
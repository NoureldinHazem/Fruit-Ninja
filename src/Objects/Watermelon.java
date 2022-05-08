package Objects;

import java.nio.file.Paths;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;


public class Watermelon extends Fruits{

         public Watermelon(){
        this.YCoordinate=800;
        this.XCoordinate=random.nextInt(1000);
        this.Type="Watermelon";
        this.ScoreIncrease=20;
        this.IsSliced=false;
        this.FallingVelocity=25;
        this.TakeOffVelocity=30;
        this.LifeDecrease=1;
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
    this.slashClip = new AudioClip(Paths.get("Audio/cut_fruit4.mp3").toUri().toString());
    this.myImageView = new ImageView(this.getMyImage()[0]);

    }
    
    
    
    
    
    

    @Override
    public Image[] getMyImage() {
        Image[] View= new Image[4];
        View [0]=new Image("file:images/Watermelon.png");
        View [1]=new Image("file:images/WatermelonCut.png");
        
        return View;
    }

 
}

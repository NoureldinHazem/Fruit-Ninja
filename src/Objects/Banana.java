package Objects;

import java.nio.file.Paths;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;



public class Banana extends Fruits{
    
        public Banana(){
        this.YCoordinate=800;
        this.XCoordinate=random.nextInt(1000);
        this.Type="Banana";
        this.ScoreIncrease=20;
        this.IsSliced=false;
        this.FallingVelocity=8;
        this.TakeOffVelocity=25;
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
        View [0]=new Image("file:images/Banana.png");
        View [1]=new Image("file:images/BannaCut.png");

        return View;
    }


 
    

    
    
    
    
    
    
    

}

package Objects;

import java.nio.file.Paths;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;



public class FatalBomb extends Bombs{

    public FatalBomb(){
        this.LifeDecrease=0;
        this.IsSliced=false;
        this.YCoordinate=800;
        this.XCoordinate=random.nextInt(1000);
        this.ScoreIncrease=0;
        this.lifeDamage=3;
        this.Type = "FatalBomb";
        
        this.FallingVelocity=8;
        this.TakeOffVelocity=15;
        
        if (random.nextBoolean()) {
            this.XVelocity = TakeOffVelocity+random.nextInt(10);
        } else {
            this.XVelocity = -1*(TakeOffVelocity+random.nextInt(10));
        }
        this.YVelocity = TakeOffVelocity/5;
        
        this.myImageView = new ImageView(this.getMyImage()[0]);
        this.myImageView.setLayoutX(XCoordinate);
        this.myImageView.setLayoutY(YCoordinate);
        localPrefSize = standardPrefSize;
        this.myImageView.setFitWidth(localPrefSize);
        this.myImageView.setFitHeight(localPrefSize);

        slashClip = new AudioClip(Paths.get("Audio/cut_bomb.mp3").toUri().toString());



        
    }

    @Override
    public Image[] getMyImage() {
        Image[] View= new Image[3];
        View [0]=new Image("file:images/Fatal_Bomb.gif");
        View [1]=new Image("file:images/bomb_cut.png");
        
        return View;
    }

   
    
    
    
}

package Objects;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

public abstract class Object implements IObject{

Random random = new Random();
String Type;
protected int ScoreIncrease ;
protected int LifeDecrease ; 
double XCoordinate=random.nextInt(1000);
double YCoordinate;
protected double MaxYCoordinate;
protected double TakeOffVelocity;
protected double FallingVelocity;
protected double YVelocity;
protected double XVelocity;
protected boolean IsSliced;
protected boolean Disappeared;
protected ImageView myImageView = new ImageView();
protected AudioClip slashClip; 
protected double localPrefSize;
protected double standardPrefSize = 130;

@Override
public void Move(double time){
   
     XCoordinate=XCoordinate+XVelocity*time/10;
     YCoordinate=YCoordinate-YVelocity*time*1.5;
     YVelocity=YVelocity-FallingVelocity/170;
     
     if (YCoordinate<0) {
        YVelocity=-YVelocity*time/10-random.nextDouble()-.5;
    }
     if (XCoordinate>=1200-localPrefSize) {
        XVelocity=-XVelocity*time/30-random.nextDouble()-.5;
    }
     else if (XCoordinate<0) {
          XVelocity=-XVelocity*time/30+random.nextDouble()+5;
    }
    
}

 @Override
    public Boolean hasMovedOffScreen() {
        if (this.YCoordinate < 810){
            return true;
        }
        else return false;
    }

    @Override
    public String getType() {
        return this.Type;
    }

    @Override
    public double getXCoordinate() {
        return this.XCoordinate;
    }

    @Override
    public double getYCoordinate() {
        return this.YCoordinate;
    }

    @Override
    public double getMaxYCoordinate() {
        return this.MaxYCoordinate;
    }

    @Override
    public double getTakeOffVelocity() {
        return this.TakeOffVelocity;
    }

    @Override
    public double getFallingVelocity() {
        return this.FallingVelocity;
    }

    @Override
    public Boolean IsSliced() {

        return this.IsSliced;
    }

    @Override
    public ImageView getImageView() {
        return this.myImageView;
    }

}

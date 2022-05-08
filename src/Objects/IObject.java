
package Objects;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;





public interface IObject {
    
    String getType();

    public int offscreen();

    public Image[] getMyImage();

    double getXCoordinate();

    double getYCoordinate();

    double getMaxYCoordinate();

    ImageView getImageView();

    double getTakeOffVelocity();

    double getFallingVelocity();

    Boolean IsSliced();

    Boolean hasMovedOffScreen();

    int slice();
                            
    void Move(double time);


    
    
    
}

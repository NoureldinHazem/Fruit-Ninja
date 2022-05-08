package Modes;

import Objects.IObject;
import java.util.List;


public interface IStrategy {
    

    int getInitialLives();

    int timer () ;
    
    boolean CheckGameOver(int score , double time , int lives);

    List<IObject> NewBatch();

    void goOffScreen(List<IObject> objectsOffScreen);
    
    void sliceObjects(List<IObject> objectsToSlice);


    @Override
    String toString();
}

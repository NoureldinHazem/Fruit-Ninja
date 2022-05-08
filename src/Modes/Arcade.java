package Modes;

import Game.GameController;
import Objects.Fruits;
import Objects.IObject;
import Objects.ObjectsFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Arcade implements IStrategy {
    
    private GameController gamecontroller1 = GameController.getInstance();
    
    private ObjectsFactory factory1 = new ObjectsFactory();


    @Override
    public int getInitialLives() {
        return -1;
    }

    @Override
    public int timer() {
        return 60;
    }

    @Override
    public boolean CheckGameOver(int score, double time, int lives) {
            if(time<0)
                return true;
            else
                return false;
        }
    
    @Override
    public String toString() {
        return "Arcade";
    }

    @Override
    public List<IObject> NewBatch() {
        
        int x,y;
        List<IObject> list = new ArrayList<>();
        x = new Random().nextInt(4)+1;
        for(int i = 0;i < x; i++) {
            y = new Random().nextInt(119)+1;
            list.add(factory1.getFruits(y));
        }
        return list;
    }

    @Override
    public void goOffScreen(List<IObject> objectsOffScreen) {

    }

    @Override
    public void sliceObjects(List<IObject> objectsToSlice) {
        for (IObject object:objectsToSlice) {
    		            int x = object.slice();
    		            if (object instanceof Fruits) {
    		                gamecontroller1.EditScore(x);
    		            }
    }
    }
    
}

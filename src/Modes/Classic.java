package Modes;

import Game.GameController;
import Objects.Bombs;
import Objects.Fruits;
import Objects.IObject;
import Objects.ObjectsFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Classic implements IStrategy{
    
    GameController gamecontroller2 = GameController.getInstance();
    
    ObjectsFactory factory2 = new ObjectsFactory();
    
    private int IntialLives = 3;

    protected IStrategy gamemode;
    
    @Override
    public int getInitialLives() {
        return IntialLives;
    }

    @Override
    public List<IObject> NewBatch() {
        int y;
        int x;
         List<IObject> list = new ArrayList<>();
        x = new Random().nextInt(5)+1;
        for(int i = 0;i < x; i++) {
            y = new Random().nextInt(145)+1;
            list.add(factory2.getFruits(y));
        }
        return list;
    }

    @Override
    public void goOffScreen(List<IObject> objectsOffScreen) {
            for (IObject object:objectsOffScreen ) {
    		int x = object.offscreen();
    	            if (object instanceof Fruits) 
    	                gamecontroller2.EditLives(-x);
                        }
    		            
            }

    @Override
    public void sliceObjects(List<IObject> objectsToSlice) {
          for (IObject object:objectsToSlice
        ) {
            int x = object.slice();
            if (object instanceof Fruits) {
                gamecontroller2.EditScore(x);
            }
            else if(object instanceof Bombs){
                gamecontroller2.EditLives(-x);
            }
        }
    }

    @Override
    public int timer() {
            return -1;
        }

    @Override
    public boolean CheckGameOver(int score, double time, int lives) {
        if (lives <=0)
            return true;
        else
            return false;
    }
    
    
    @Override
    public String toString() {
        return null;
    }
    
}

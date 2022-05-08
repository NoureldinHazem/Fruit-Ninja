package Modes;

import Objects.IObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hard extends Classic{
    
    @Override
    public String toString() {
        return "ClassicHard";
    }
    
    @Override
    public List<IObject> NewBatch() {
         int y;
        int x;
         List<IObject> list = new ArrayList<>();
        x = new Random().nextInt(6)+1;
        for(int i = 0;i < x; i++) {
            y = new Random().nextInt(150)+1;
            list.add(factory2.getFruits(y));
        }
        return list; 
    }
    
       public Hard(IStrategy gamemode) {
        this.gamemode = gamemode;
    }

    
}

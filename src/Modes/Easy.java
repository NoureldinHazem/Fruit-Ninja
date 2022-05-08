package Modes;

import Objects.IObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Easy extends Classic {

    @Override
    public List<IObject> NewBatch() {
         int y;
        int x;
         List<IObject> list = new ArrayList<>();
        x = new Random().nextInt(2)+1;
        for(int i = 0;i < x; i++) {
            y = new Random().nextInt(150)+1;
            list.add(factory2.getFruits(y));
        }
        return list;
    }
    
    @Override
    public String toString() {
        return "ClassicEasy";
    }
    
    
    public Easy(IStrategy gamemode) {
        this.gamemode = gamemode;
    }

    
}

package Objects;


public abstract class Fruits extends Object{
  
    
    
    public int slice() {
     if(!IsSliced) {
        IsSliced = true;
        slashClip.play();
        return ScoreIncrease;
     }
     return 0;
     }
     
    
     public int offscreen() {
    	
        if(!Disappeared) {
        	Disappeared=true;
        if(IsSliced == true)
            return 0; 
        else
            return LifeDecrease;
        }
        return 0;
    }

    
    
    
}

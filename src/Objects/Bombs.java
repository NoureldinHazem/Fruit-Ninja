package Objects;


public abstract class Bombs extends Object{
    
      protected int lifeDamage;

      
    @Override
    public int slice() {

        this.IsSliced = true;
        slashClip.play();
        return lifeDamage;

    }

    @Override
    public int offscreen() {
        return 0;
    }
    
    
    
}

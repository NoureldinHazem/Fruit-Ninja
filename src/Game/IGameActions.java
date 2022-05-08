package Game;

import Objects.IObject;
import java.util.List;

public interface IGameActions {
    
    public void Save();
    
    public void Load();
    
    public void ResetGame();
 
    boolean GameOver();

    public List<IObject> createGameObject(int time);
    
    public void throwOffScreen(List<IObject> objects);
    
    public void updateObjectsLocations(List<IObject> myObjects, List<IObject> objectsToRemove);
    
    public void sliceObjects(List<IObject> objects);
    
    
}

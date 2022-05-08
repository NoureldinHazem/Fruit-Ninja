package Game;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class Player {
    
    
   @XmlElement( name = "score")
    private int Score;
    
    @XmlElement( name = "difficulty")
    private String Difficulty;

    
    public Player() {
        this.Score = 0;
        this.Difficulty = null;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public String getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(String Difficulty) {
        this.Difficulty = Difficulty;
    }

   
  
}
 
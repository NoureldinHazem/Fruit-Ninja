package Game;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement( name = "HighScores")
@XmlAccessorType(XmlAccessType.FIELD)
public class HighScores {
    
     @XmlElement( name = "player")
    private List <Player> HighScores;
   

    public List<Player> getHighScores() {
        return HighScores;
    }

    public void setHighScores(List<Player> HighScores) {
        this.HighScores = HighScores;
    }
    
}
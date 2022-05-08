package Game;

import Gui.Game;
import Modes.IStrategy;
import Objects.IObject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class GameController implements IGameActions {

    private int score;
    private int time;
    private int lives;
    private String difficulty;
    private int best;

    private IStrategy strategy;
    Game game;

    private static GameController instance;

    private GameController() {
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }

        return instance;
    }

    private ArrayList<Label> observerLabels = new ArrayList<>();
    private List<Player> scores = new ArrayList<>();

    public List<Player> getScores() {
        return scores;
    }

    public void setScores(List<Player> scores) {
        this.scores = scores;
    }

    public int getScore() {
        return score;
    }

    public int getTime() {
        return time;
    }

    public int getLives() {
        return lives;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void addObserver(Label label) {
        observerLabels.add(label);
    }

    public void updateObservers() {
        for (Label label : observerLabels) {
            label.setText("Current Score: " + score);
        }
    }

    public void newGame(IStrategy IStrategy) {
        this.strategy = IStrategy;
        score = 0;
        time = strategy.timer();
        lives = strategy.getInitialLives();
    }

    public void EditScore(int change) {

        score += change;
    }

    public void EditLives(int change) {
        lives += change;
    }

    @Override
    public void Save() {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(HighScores.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            HighScores highscores = new HighScores();
            highscores.setHighScores(GameController.getInstance().scores);
            marshaller.marshal(highscores, new File("HighScores.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void Load() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(HighScores.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            HighScores savedHighScores = (HighScores) unmarshaller.unmarshal(new File("HighScores.xml"));
            savedHighScores.getHighScores().forEach((r) -> {
                scores.add(r);
            });
        } catch (NullPointerException e) {
        } catch (JAXBException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void ResetGame() {
        lives = strategy.getInitialLives();
        score = 0;

    }

    @Override
    public boolean GameOver() {
        return strategy.CheckGameOver(score, time, lives);
    }

    @Override
    public List<IObject> createGameObject(int time) {
        return strategy.NewBatch();
    }

    @Override
    public void throwOffScreen(List<IObject> objects) {
        strategy.goOffScreen(objects);
    }

    @Override
    public void updateObjectsLocations(List<IObject> myObjects, List<IObject> objectsToRemove) {
        for (IObject fruit : myObjects) {
            fruit.Move(3);
            fruit.getImageView().setLayoutY(fruit.getYCoordinate());
            fruit.getImageView().setLayoutX(fruit.getXCoordinate());
        }
        for (IObject fruit : myObjects) {
            if (fruit.getYCoordinate() > 900) {
                objectsToRemove.add(fruit);
            }
        }
    }

    @Override
    public void sliceObjects(List<IObject> objectsToSlice) {

        strategy.sliceObjects(objectsToSlice);
        updateObservers();
    }

    public String difficulty() {
        return strategy.toString();
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int Best(String GameMode) {
        best = 0;
        if (GameMode.equalsIgnoreCase("Arcade")) {
            scores.forEach((player) -> {
                if (player.getScore() > best && player.getDifficulty().equalsIgnoreCase(GameMode)) {
                    best = player.getScore();

                }
            });
        }
        if (GameMode.equalsIgnoreCase("ClassicEasy")) {
            scores.forEach((player) -> {
                if (player.getScore() > best && player.getDifficulty().equalsIgnoreCase(GameMode)) {
                    best = player.getScore();

                }
            });
        }
        if (GameMode.equalsIgnoreCase("ClassicMedium")) {
            scores.forEach((player) -> {
                if (player.getScore() > best && player.getDifficulty().equalsIgnoreCase(GameMode)) {
                    best = player.getScore();
                }
            });
        }
        if (GameMode.equalsIgnoreCase("ClassicHard")) {
            scores.forEach((player) -> {
                if (player.getScore() > best && player.getDifficulty().equalsIgnoreCase(GameMode)) {
                    best = player.getScore();
                }
            });
        }

        return best;
    }

    public void AddScore(Player player) {
        if (player.getDifficulty().equalsIgnoreCase("Arcade")) {
            scores.add(player);
        } else if (player.getDifficulty().equalsIgnoreCase("ClassicEasy")) {
            scores.add(player);
        } else if (player.getDifficulty().equalsIgnoreCase("ClassicMedium")) {
            scores.add(player);

        } else if (player.getDifficulty().equalsIgnoreCase("ClassicHard")) {
            scores.add(player);
        }
    }

    public void EditTime(double change) {
        time += change;
    }
}

package utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import model.Ball;
import model.Level;
import model.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LevelManager {
    public Level currentLevel;
    public Integer currentLevelNumber;
    Player player;
    Integer levelSpeed;
    List<Ball> balls = new ArrayList<Ball>();
    float[] medals_array = new float[3];

    /**
     * can be passed either level or fileName
     * if fileName is empty -> "" then it will be taken the levelNumber
     */
    public void loadLevel(int level, String fileName){
        currentLevelNumber = level;
        XmlReader reader = new XmlReader();
        XmlReader.Element file;
        try {
            if(fileName.equals("")) {
                file = reader.parse(Gdx.files.internal("levels/level"+level+".xml"));
                fileName = "level"+level+".xml";
            } else {
                file = reader.parse(Gdx.files.internal("levels/"+fileName));
            }
            System.out.println("Load File: "+fileName);
            int playerX = Integer.parseInt(file.getChildByName("player").getAttribute("x"));
            int levelSpeed = Integer.parseInt(file.getChildByName("levelSpeed").getAttribute("speed"));
            this.levelSpeed = levelSpeed;
            medals_array[0] = Float.parseFloat(file.getChildByName("bronze").getAttribute("value"));
            medals_array[1] = Float.parseFloat(file.getChildByName("silver").getAttribute("value"));
            medals_array[2] = Float.parseFloat(file.getChildByName("gold").getAttribute("value"));
            balls.clear();
            for (int i = 0; i < file.getChildByName("balls").getChildCount() ; i++) {
                XmlReader.Element ball = file.getChildByName("balls").getChild(i);
                int ballX = Integer.parseInt(ball.getAttribute("x"));
                int ballY = Integer.parseInt(ball.getAttribute("y"));
                int vectorX = Integer.parseInt(ball.getAttribute("xVector"));
                String size = ball.getAttribute("size");
                Ball.sizeDef[] allSizes = Ball.sizeDef.values();
                for (Ball.sizeDef sizeDef : allSizes) {
                    if(size.equals(sizeDef.toString())){
                        balls.add(new Ball(ballX, ballY, sizeDef, vectorX));
                    }
                }
                player = null;
                player = new Player(playerX);
                currentLevel = null;
                currentLevel = new Level(0, 0);
                currentLevel.init(player, balls, levelSpeed, medals_array);
                currentLevel.background = Assets.levelBackgrounds.get(level);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void loadNextLevel() {
        currentLevelNumber++;
        loadLevel(currentLevelNumber, "");
    }

    public void reloadLevel() {
        currentLevel = null;
        currentLevel = new Level(0,0);
        currentLevel.init(player, balls, levelSpeed, medals_array);
        currentLevel.background = Assets.levelBackgrounds.get(currentLevelNumber);
    }
}
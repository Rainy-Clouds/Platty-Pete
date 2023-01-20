import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class MapManager 
{
    private BufferedImage background;
    private MapLevel[] levels = new MapLevel[4];
    private static String[] levelStates = new String[4];

    public MapManager()
    {
        try
        {
            background = ImageIO.read(new File("Assets\\map.png"));
        }
        catch(Exception e)
        {
            System.out.println("One or more image files not found!");
        }
        
        levels[0] = new MapLevel(67, 450, 1, "Holmer Hills", 35);
        levels[1] = new MapLevel(454, 381, 2, "Java Isles", 45);
        levels[2] = new MapLevel(143, 233, 3, "Newman Forest", 15);
        levels[3] = new MapLevel(537, 87, 4, "Cooklin City", 35);

        levelStates[0] = "unfinished";
        for(int i = 1; i < 4; i++)
        {
            levelStates[i] = "locked";
        }
    }

    public void update()
    {
        for(int i = 0; i < 4; i++)
        {
            levels[i].setState(levelStates[i]);
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(background, 0, 0, null);
        for(int i = 0; i < 4; i++)
        {
            levels[i].draw(g);
        }
    }

    public void mouseClick(int x, int y, Game game)
    {
        for(int i = 0; i < 4; i++)
        {
            levels[i].mouseClick(x, y, game);
        }
    }

    public static String[] getLevelStates()
    {
        return levelStates;
    }

    public static void setLevelStates(String[] newStates)
    {
        levelStates = newStates;
    }
}

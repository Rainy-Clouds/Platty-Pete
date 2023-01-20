import java.awt.*;
//import javax.swing.*;

public class Game 
{
    private String state;
    private int lvl = 1;
    private TitleManager title = new TitleManager();
    private LevelManager level = new LevelManager(lvl);
    private MapManager map = new MapManager();
    private ChooseManager choose = new ChooseManager();
    private int frame;

    public Game()
    {
        state = "title";
    }

    public String getState()
    {
        return state;
    }

    public void tick()
    {
        frame++;
        if(state == "title")
        {
            title.update();
        } 
        else if(state == "level")
        {
            level.update(frame);
        }
        else if(state == "map")
        {
            map.update();
        }
        else if(state == "choose")
        {
            choose.update();
        }
    }

    public void paint(Graphics g)
    {
        if(state == "title")
        {
            title.draw(g);
        }
        else if(state == "level")
        {
            level.draw(g, frame);
        }
        else if(state == "map")
        {
            map.draw(g);
        }
        else if(state == "choose")
        {
            choose.draw(g);
        }

        Transition.draw(g, this);
    }

    public void playerAction(String action)
    {
        level.playerAction(action);
    }

    public void mouseClick(int x, int y)
    {
        if(state == "map")
        {
            map.mouseClick(x, y, this);
        }
        if(state == "title")
        {
            title.mouseClick(x, y);
        }
        if(state == "choose")
        {
            choose.mouseClick(level);
        }
    }

    public void mouseRelease()
    {
        if(state == "title")
        {
            title.mouseRelease();
        }
    }

    public void mouseMotion(int x, int y)
    {
        if(state == "choose")
        {
            choose.mouseMotion(x, y);
        }
    }

    public void enterState(String newState, int lvl)
    {
        level.setLevel(lvl);
        state = newState;
    }
}

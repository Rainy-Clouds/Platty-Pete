import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class MapLevel 
{
    private int x;
    private int y;
    private int level;
    private int offset;
    private String name;
    private BufferedImage frame;
    private String state;

    public MapLevel(int x, int y, int level, String name, int offset)
    {
        this.x = x;
        this.y = y;
        this.level = level;
        state = "locked";
        this.name = name;
        this.offset = offset;

        try
        {
            frame = ImageIO.read(new File("Assets\\levelholder.png"));
        }
        catch(Exception e)
        {
            System.out.println("One or more image files not found!");
        }
    }

    public void draw(Graphics g)
    {
        if(state == "locked")
        {
            g.setColor(new Color(234, 194, 129));
        }
        else if(state == "unfinished")
        {
            g.setColor(new Color(244, 51, 51));
        }
        else if(state == "finished")
        {
            g.setColor(new Color(61, 126, 229));
        }
        g.fillRect(x + 19, y + 20, 140, 63);

        if(state == "finished" || state == "unfinished")
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString(name, x + offset, y + 125);
        }

        g.drawImage(frame, x, y, null);
    }

    public void mouseClick(int x, int y, Game game)
    {
        if((x >= this.x + 19 && x <= this.x + 159) && (y >= this.y + 20 && y <= this.y + 83))
        {
            if(state == "unfinished" || state == "finished")
            {
                Transition.transition("level", level);
            }
        }
    }

    public void setState(String newState)
    {
        state = newState;
    }
}

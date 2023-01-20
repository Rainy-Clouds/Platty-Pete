import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class Option 
{
    private BufferedImage render;
    private int x;
    private int y;
    private String name;
    private boolean mouse;
    private int skinNum;

    public Option(int x, int y, String name, int skinNum)
    {
        this.x = x;
        this.y = y;
        this.name = name;
        this.skinNum = skinNum;

        try
        {
            render = ImageIO.read(new File("Assets\\" + name + "render.png"));
        }
        catch(Exception e)
        {
            System.out.println("One or more image files not found!");
        }
    }

    public void touchingMouse(int mx, int my)
    {
        if((mx > x && mx < x + 80) && (my > y && my < y + 80))
        {
            mouse = true;
        }
        else
        {
            mouse = false;
        }
    }

    public String gettingInfo()
    {
        if(mouse)
        {
            return name;
        }
        return null;
    }

    public void mouseClick(LevelManager lm)
    {
        if(mouse)
        {
            lm.getPlayer().setSkin(skinNum);
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(render, x, y, null);
    }
}

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class TitleManager 
{
    private TitleBackground background = new TitleBackground();
    private TitleButton playButton = new TitleButton("PLAY", 110, 400, 0);
    private TitleButton skinButton = new TitleButton("SKIN", 500, 400, 1);
    private BufferedImage logo;

    public TitleManager()
    {
        try
        {
            logo = ImageIO.read(new File("Assets\\Logo.png"));
        }
        catch(Exception e)
        {
            System.out.println("One or more image files not found!");
        }
    }

    public void update()
    {
        background.update();
    }

    public void mouseClick(int x, int y)
    {
        playButton.mouseClick(x, y);
        skinButton.mouseClick(x, y);
    }

    public void mouseRelease()
    {
        playButton.mouseRelease();
        skinButton.mouseRelease();
    }

    public void draw(Graphics g)
    {
        background.draw(g);
        g.drawImage(logo, 175, 50, null);
        playButton.draw(g);
        skinButton.draw(g);
    }
}

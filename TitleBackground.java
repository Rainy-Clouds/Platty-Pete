import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class TitleBackground 
{
    private BufferedImage background;
    private int scroll;

    public TitleBackground()
    {
        try
        {
            background = ImageIO.read(new File("Assets\\titleback.png"));
        }
        catch(Exception e)
        {
            System.out.println("One or more image files not found!");
        }
    }

    public void update()
    {
        scroll--;
    }

    public void draw(Graphics g)
    {
        g.drawImage(background, scroll % 1600, 0, null);
        g.drawImage(background, scroll % 1600 + 1600, 0, null);
    }
}

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class Background 
{
    private BufferedImage[] backgrounds = new BufferedImage[4];
    private BufferedImage[] skyboxes = new BufferedImage[4];
    private final int scrollFactor = 8;

    public Background()
    {
        try
        {
            for(int i = 1; i <= 4; i++)
            {
                backgrounds[i - 1] = ImageIO.read(new File("Assets\\level" + i + ".png"));
                skyboxes[i - 1] = ImageIO.read(new File("Assets\\level" + i + "back.png"));
            } 
        }
        catch(Exception e)
        {
            System.out.println("One or more image files not found!");
        }
    }

    public void draw(Graphics g, int scroll, int level)
    {
        g.drawImage(skyboxes[level - 1], 0, 0, null);

        g.drawImage(backgrounds[level - 1], (scroll / scrollFactor) % 1600, 0, null);
        g.drawImage(backgrounds[level - 1], (scroll / scrollFactor) % 1600 + 1600, 0, null);
        g.drawImage(backgrounds[level - 1], (scroll / scrollFactor) % 1600 - 1600, 0, null);
    }
}

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class PlayerImages 
{
    private String[] names = {"pete", "fred", "veronica", "serena", "bryce", "steven"};
    private BufferedImage[][] images = new BufferedImage[6][3]; 

    public PlayerImages()
    {
        try
        {
            for(int i = 0; i < 6; i++)
            {
                images[i][0] = ImageIO.read(new File("Assets\\" + names[i] + "die.png"));
                images[i][1] = ImageIO.read(new File("Assets\\" + names[i] + "right.png"));
                images[i][2] = ImageIO.read(new File("Assets\\" + names[i] + "left.png"));
            }
        }
        catch(Exception e)
        {
            System.out.println("One or more image files not found!");
        }
    }

    public Image player(String facing, boolean dying, int costumeNum)
    {
        if(dying)
        {
            return images[costumeNum][0];
        }
        else if(facing == "right")
        {
            return images[costumeNum][1];
        }
        else
        {
            return images[costumeNum][2];
        }
    }
}

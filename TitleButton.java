import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class TitleButton 
{
    private String title;
    private BufferedImage[] buttons = new BufferedImage[2];
    private BufferedImage[] buttonspress = new BufferedImage[2];
    private int x;
    private int y;
    private int color;
    private boolean pressed;

    public TitleButton(String title, int x, int y, int color)
    {
        this.title = title;
        this.x = x;
        this.y = y;
        this.color = color;

        try
        {
            buttons[0] = ImageIO.read(new File("Assets\\button1.png"));
            buttons[1] = ImageIO.read(new File("Assets\\button2.png"));
            buttonspress[0] = ImageIO.read(new File("Assets\\button1pressed.png"));
            buttonspress[1] = ImageIO.read(new File("Assets\\button2pressed.png"));
        }
        catch(Exception e)
        {
            System.out.println("One or more image files not found!");
        }
    }

    public void mouseClick(int mx, int my)
    {
        if((mx > x && mx < x + 200) && (my > y && my < y + 120))
        {
            pressed = true;
            if(title == "PLAY")
            {
                Transition.transition("map", 1);
            }
            if(title == "SKIN")
            {
                Transition.transition("choose", 1);
            }
        }
    }

    public void mouseRelease()
    {
        pressed = false;
    }

    public void draw(Graphics g)
    {
        if(pressed)
        {
            g.drawImage(buttonspress[color], x, y, null);
        }
        else
        {
            g.drawImage(buttons[color], x, y, null);
        }
        g.setFont(new Font("Arial", Font.PLAIN, 48));
        g.drawString(title, x + 36, y + 78);
    }
}

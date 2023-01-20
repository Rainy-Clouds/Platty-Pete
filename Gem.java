import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class Gem 
{
    private Hitbox hitbox;
    private int gridX;
    private int x;
    private int y;
    private int yOffset;
    private double animationVel;
    private double yvel;
    private boolean negativeVel;
    private boolean visible = true;
    private boolean animating;
    private boolean followingPlayer;
    private BufferedImage img;
    
    public Gem(int x, int y)
    {
        gridX = x;
        this.y = y * 40;
        hitbox = new Hitbox(gridX * 40, this.y + 6, 40, 28);
        try
        {
            img = ImageIO.read(new File("Assets\\gem.png"));
        }
        catch(Exception e)
        {
            System.out.println("One or more image files not found!");
        }
    }

    public Hitbox getHitbox()
    {
        return hitbox;
    }

    public boolean getVisible()
    {
        return visible;
    }

    public void update(int scroll, int frame)
    {
        if(!animating)
        {
            hitbox.changeValues(gridX * 40 + scroll, y + 6 + yOffset, 40, 28);
            if(negativeVel)
            {
                yvel -= 0.125;
                if(yvel <= -2)
                {
                    negativeVel = false;
                }
            }
            else
            {
                yvel += 0.125;
                if(yvel >= 2)
                {
                    negativeVel = true;
                }
            }
            yOffset += yvel;
            x = gridX * 40 + scroll;
        }
        else if(animating && !followingPlayer)
        {
            hitbox.changeValues(gridX * 40 + scroll, y + 6, 40, 28);
            if(animationVel <= 0)
            {
                y += animationVel;
                animationVel += 0.125;
            }
        }
    }

    public void draw(Graphics g)
    {
        if(hitbox.getX() >= -40 && hitbox.getX() <= 840 && visible)
        {
            g.drawImage(img, x, y + 6 + yOffset, null);
        }
    }

    public void collect()
    {
        visible = false;
    }

    public void animate(int x, int y)
    {
        animating = true;
        visible = true;
        this.x = x;
        this.y = y;
        yOffset = 0;
        animationVel = -3.5;
    }

    public void followPlayer(int x, int y)
    {
        followingPlayer = true;
        this.x = x;
        this.y = y;
    }
}
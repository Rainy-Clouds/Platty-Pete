import java.awt.Graphics;
import java.awt.Color;

public class Hitbox 
{
    private int x;
    private int y;
    private int width;
    private int height;

    public Hitbox(int x, int y, int w, int h)
    {
        this.x = x;
        this.y = y;
        width = w;
        height = h;
    }

    public boolean detectCollision(Hitbox h)
    {
        if(((x >= h.x && x <= h.x + h.width) && (y > h.y && y < h.y + h.height)) || ((x + width >= h.x && x + width <= h.x + h.width) && (y > h.y && y < h.y + h.height)) || ((x >= h.x && x <= h.x + h.width) && (y + height > h.y && y + height < h.y + h.height)) || ((x + width >= h.x && x + width <= h.x + h.width) && (y + height > h.y && y + height < h.y + h.height)))
        {
            return true;
        }
        return false;
    }

    public void changeValues(int x, int y, int w, int h)
    {
        this.x = x;
        this.y = y;
        width = w;
        height = h;
    }

    public void draw(Graphics g)
    {
        g.setColor(new Color(255, 20, 228));
        g.fillRect(x, y, width, height);
    }

    public int getY()
    {
        return y;
    }

    public int getX()
    {
        return x;
    }

    public String toString()
    {
        return x + " " + y + " " + width + " " + height;
    }
}

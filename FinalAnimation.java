import java.awt.*;

public class FinalAnimation 
{
    private int x;
    private int y;
    private double xvel;
    private boolean animating;

    public FinalAnimation()
    {
        x = -800;
        y = 254;
    }

    public void update()
    {
        if(animating)
        {
            x += xvel;
            xvel -= 0.1;
        }
    }

    public void draw(Graphics g)
    {
        g.setColor(new Color(255, 0, 187));
        g.setFont(new Font("Arial", Font.BOLD, 72));
        g.drawString("Gem Collected!", x, y);
        if(animating && xvel < 0 && x < -600)
        {
            animating = false;
            x = -800;
            y = 254;
            Transition.transition("map", 1);
        }
    }

    public void animate()
    {
        animating = true;
        xvel = 14;
    }
}

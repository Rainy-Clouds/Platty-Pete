import java.awt.*;

public class Transition 
{
    private static int alpha;
    private static int levelTo;
    private static boolean transitioning;
    private static boolean alphaUp;
    private static String stateTo;

    public static void transition(String newState, int newLevel)
    {
        if(!transitioning){
            transitioning = true;
            stateTo = newState;
            alphaUp = true;
            levelTo = newLevel;
        }
    }    

    public static void draw(Graphics g, Game game)
    {
        if(transitioning)
        {
            if(alphaUp)
            {
                alpha += 5;
                if(alpha > 255)
                {
                    alpha = 255;
                    alphaUp = false;
                }
            }
            else
            {
                alpha -= 5;
                if(alpha < 0)
                {
                    alpha = 0;
                    transitioning = false;
                }
            }
            g.setColor(new Color(0, 0, 0, alpha));
            g.fillRect(0, 0, 800, 600);
            if(alpha == 255)
            {
                game.enterState(stateTo, levelTo);
            }
        }
    }
}

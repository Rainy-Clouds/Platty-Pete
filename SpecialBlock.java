public class SpecialBlock 
{
    private int gridX;
    private int gridY;
    private String type;
    private Hitbox hitbox;
    private boolean visible = true;

    // temp block variables
    private boolean delaying;
    private final int delayCount = 60;
    private int delay;

    public SpecialBlock(int x, int y, String typ)
    {
        gridX = x;
        gridY = y;
        type = typ;

        if(type == "red flip")
        {
            visible = true;
        }
        else if(type == "blue flip")
        {
            visible = false;
        }
    }

    public void update(Player player, int frame)
    {
        if(gridX * 40 + player.getScrollX() >= -40 && gridX * 40 + player.getScrollX() <= 840)
        {
            hitbox = new Hitbox(gridX * 40 + player.getScrollX(), gridY * 40, 40, 40);
            if(type == "temp block" && !delaying)
            {
                if(player.getBottombox().detectCollision(hitbox) && visible)
                {
                    delaying = true;
                }
            }
        }

        if(type == "temp block" && delaying)
        {
            delay++;
            if(delay > delayCount)
            {
                delaying = false;
                visible = false;
            }
        }
        else if(type == "red blink")
        {
            visible = frame % 240 < 120;
        }
        else if(type == "blue blink")
        {
            visible = frame % 240 >= 120;
        }
        else if(type == "spikes")
        {
            visible = frame % 240 >= 120;
        }
    }

    public void makeChanges(String[][] level)
    {
        if(visible)
        {
            if(type == "temp block" && delaying)
            {
                level[gridY][gridX] = "temp block breaking";
            }
            else
            {
                level[gridY][gridX] = type;
            }
        }
        else
        {
            if(type == "spikes")
            {
                level[gridY][gridX] = "spikes off";
            }
            else if(type == "red blink" || type == "blue blink" || type == "red flip" || type == "blue flip")
            {
                level[gridY][gridX] = "empty frame";
            }
            else
            {
                level[gridY][gridX] = null;
            }
        }
    }

    public void flip()
    {
        if(type == "red flip" || type == "blue flip")
        {
            visible = !visible;
        }
    }
}
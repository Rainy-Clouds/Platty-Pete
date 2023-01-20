public class Conveyor 
{
    private String direction;
    private Hitbox hitbox;

    public Conveyor(String dir, int x, int y, int width, int height)
    {
        direction = dir;
        hitbox = new Hitbox(x, y, width, height);
    }

    public String getDirection()
    {
        return direction;
    }

    public Hitbox getHitbox()
    {
        return hitbox;
    }
}

public class Ground 
{
    private int gridX;
    private Hitbox hitbox = null;

    public Ground(int x, int y, int w, int h, int gridx)
    {
        hitbox = new Hitbox(x, y, w, h);
        gridX = gridx;
    }

    public Hitbox getHitbox()
    {
        return hitbox;
    }

    public int getGridX()
    {
        return gridX;
    }
}

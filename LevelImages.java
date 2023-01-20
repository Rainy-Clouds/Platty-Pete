import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class LevelImages 
{
    private BufferedImage grass;
    private BufferedImage dirt;
    private BufferedImage[] lava = new BufferedImage[4]; 
    private BufferedImage underlava;
    private BufferedImage[] water = new BufferedImage[4];
    private BufferedImage underwater;
    private BufferedImage block;
    private BufferedImage bridge;
    private BufferedImage blueblink;
    private BufferedImage redblink;
    private BufferedImage frame;
    private BufferedImage redflip;
    private BufferedImage blueflip;
    private BufferedImage tempblock;
    private BufferedImage tempblockbreak;
    private BufferedImage trampoline;
    private BufferedImage spikes;
    private BufferedImage spikesoff;
    private BufferedImage[] conveyorleft = new BufferedImage[5]; 
    private BufferedImage[] conveyorright = new BufferedImage[5]; 
    private BufferedImage conveyorleftend;
    private BufferedImage conveyorrightend;
    private BufferedImage sand;
    private BufferedImage snow;
    private BufferedImage concretetop;
    private BufferedImage concrete;

    public LevelImages()
    {
        try
        {
            grass = ImageIO.read(new File("Assets\\grass.png"));
            dirt = ImageIO.read(new File("Assets\\dirt.png"));
            sand = ImageIO.read(new File("Assets\\sand.png"));
            snow = ImageIO.read(new File("Assets\\snow.png"));
            concretetop = ImageIO.read(new File("Assets\\concretetop.png"));
            concrete = ImageIO.read(new File("Assets\\concrete.png"));
            for(int i = 0; i < 4; i++)
            {
                lava[i] = ImageIO.read(new File("Assets\\lava" + i + ".png"));
                water[i] = ImageIO.read(new File("Assets\\water" + i + ".png"));
            }
            underlava = ImageIO.read(new File("Assets\\underlava.png"));
            underwater = ImageIO.read(new File("Assets\\underwater.png"));
            block = ImageIO.read(new File("Assets\\block.png"));
            bridge = ImageIO.read(new File("Assets\\bridge.png"));
            blueblink = ImageIO.read(new File("Assets\\blueblink.png"));
            redblink = ImageIO.read(new File("Assets\\redblink.png"));
            frame = ImageIO.read(new File("Assets\\frame.png"));
            redflip = ImageIO.read(new File("Assets\\redflip.png"));
            blueflip = ImageIO.read(new File("Assets\\blueflip.png"));
            tempblock = ImageIO.read(new File("Assets\\tempblock.png"));
            tempblockbreak = ImageIO.read(new File("Assets\\tempblockbreak.png"));
            trampoline = ImageIO.read(new File("Assets\\trampoline.png"));
            spikes = ImageIO.read(new File("Assets\\spikes.png"));
            spikesoff = ImageIO.read(new File("Assets\\spikesoff.png"));
            for(int i = 0; i < 5; i++)
            {
                conveyorleft[i] = ImageIO.read(new File("Assets\\conveyleft" + i + ".png"));
                conveyorright[i] = ImageIO.read(new File("Assets\\conveyright" + i + ".png"));
            }
            conveyorleftend = ImageIO.read(new File("Assets\\conveyleftend.png"));
            conveyorrightend = ImageIO.read(new File("Assets\\conveyrighttend.png"));
        }
        catch(Exception e)
        {
            System.out.println("One or more image files not found!");
        }
    }

    public Image grass()
    {
        return grass;
    }

    public Image dirt()
    {
        return dirt;
    }

    public Image lava(int frame)
    {
        if(frame % 40 < 10)
        {
            return lava[0];
        }
        else if(frame % 40 < 20)
        {
            return lava[1];
        }
        else if(frame % 40 < 30)
        {
            return lava[2];
        }
        else
        {
            return lava[3];
        }
    }

    public Image underlava()
    {
        return underlava;
    }

    public Image water(int frame)
    {
        if(frame % 40 < 10)
        {
            return water[0];
        }
        else if(frame % 40 < 20)
        {
            return water[1];
        }
        else if(frame % 40 < 30)
        {
            return water[2];
        }
        else
        {
            return water[3];
        }
    }

    public Image underwater()
    {
        return underwater;
    }

    public Image block()
    {
        return block;
    }

    public Image bridge()
    {
        return bridge;
    }

    public Image blueblink()
    {
        return blueblink;
    }

    public Image redblink()
    {
        return redblink;
    }

    public Image frame()
    {
        return frame;
    }

    public Image redflip()
    {
        return redflip;
    }

    public Image blueflip()
    {
        return blueflip;
    }

    public Image tempblock()
    {
        return tempblock;
    }

    public Image tempblockbreak()
    {
        return tempblockbreak;
    }

    public Image trampoline()
    {
        return trampoline;
    }

    public Image spikes()
    {
        return spikes;
    }

    public Image spikesoff()
    {
        return spikesoff;
    }

    public Image conveyorleft(int frame)
    {
        return conveyorleft[(frame % 10) / 2];
    }

    public Image conveyorright(int frame)
    {
        return conveyorright[(frame % 10) / 2];
    }

    public Image conveyorleftend()
    {
        return conveyorleftend;
    }

    public Image conveyorrightend()
    {
        return conveyorrightend;
    }

    public Image sand()
    {
        return sand;
    }

    public Image snow()
    {
        return snow;
    }

    public Image concretetop()
    {
        return concretetop;
    }

    public Image concrete()
    {
        return concrete;
    }
}

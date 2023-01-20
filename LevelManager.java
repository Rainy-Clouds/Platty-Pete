import java.awt.Graphics;
import java.util.*;
import java.io.*;

public class LevelManager 
{
    private Player player = new Player();
    private Gem gem;
    private Background background = new Background();
    private List<Ground> groundList = new ArrayList<>();
    private List<Hitbox> deathZones = new ArrayList<>();
    private List<Hitbox> water = new ArrayList<>();
    private List<Hitbox> semiground = new ArrayList<>();
    private List<Hitbox> trampolines = new ArrayList<>();
    private List<SpecialBlock> specialBlocks = new ArrayList<>();
    private List<Conveyor> conveyors = new ArrayList<>();
    private int level;

    public LevelManager(int lvl)
    {
        level = lvl;
        specialBlocks = LevelConverter.getSpecialBlocks(getPath());

        String[][] levelArray = LevelConverter.textToLevel(new File(getPath()));
        for(int i = 0; i < 15; i++)
        {
            for(int j = 0; j < levelArray[0].length; j++)
            {
                if(levelArray[i][j] == "gem")
                {
                    gem = new Gem(j, i);
                }
            }
        }
    }

    public Player getPlayer()
    {
        return player;
    }

    public void update(int frame)
    {
        clearLists();
        for(int i = 0; i < specialBlocks.size(); i++)
        {
            specialBlocks.get(i).update(player, frame);
        }
        LevelConverter.getLists(getPath(), player.getScrollX(), specialBlocks, groundList, deathZones, water, semiground, trampolines, conveyors);
        player.update(groundList, gem, deathZones, water, semiground, trampolines, conveyors, this);
        gem.update(player.getScrollX(), frame);
    }

    public void clearLists()
    {
        groundList.clear();
        deathZones.clear();
        water.clear();
        semiground.clear();
        trampolines.clear();
        conveyors.clear();
    }

    public void draw(Graphics g, int frame)
    {
        background.draw(g, player.getScrollX(), level);
        LevelConverter.drawLevel(g, frame, getPath(), player.getScrollX(), specialBlocks);
        gem.draw(g);
        player.drawSelf(g);
    }

    public void playerAction(String action)
    {
        if(player.isMovable())
        {
            if(action == "jump")
            {
                player.jump(this, trampolines);
            }
            if(action == "move right")
            {
                player.moveRight();
            }
            if(action == "move left")
            {
                player.moveLeft();
            }
        }
    }

    public void resetSpecialBlocks()
    {
        specialBlocks.clear();
        specialBlocks = LevelConverter.getSpecialBlocks(getPath());
    }

    private String getPath()
    {
        if(level == 1)
        {
            return "Levels\\LevelOne.txt";
        }
        else if(level == 2)
        {
            return "Levels\\LevelTwo.txt";
        }
        else if(level == 3)
        {
            return "Levels\\LevelThree.txt";
        }
        else if(level == 4)
        {
            return "Levels\\LevelFour.txt";
        }
        return null;
    }

    public void flip()
    {
        for(int i = 0; i < specialBlocks.size(); i++)
        {
            specialBlocks.get(i).flip();
        }
    }

    public void setLevel(int newLevel)
    {
        level = newLevel;
        resetSpecialBlocks();
        player.reset(this);
    }

    public int getLevel()
    {
        return level;
    }

    public void getNewGem()
    {
        String[][] levelArray = LevelConverter.textToLevel(new File(getPath()));
        for(int i = 0; i < 15; i++)
        {
            for(int j = 0; j < levelArray[0].length; j++)
            {
                if(levelArray[i][j] == "gem")
                {
                    gem = new Gem(j, i);
                }
            }
        }
    }
}

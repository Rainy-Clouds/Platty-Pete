import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Player 
{
    private int x = 380;
    private int y = 440;
    private int yvel = 0;
    private int scrollX = 0;
    private Hitbox hitbox = new Hitbox(x + 1, y, 38, 40);
    private Hitbox bottombox = new Hitbox(x + 1, y + 40, 38, 1);
    private Hitbox rightbox = new Hitbox(x + 40, y + 1, 1, 38);
    private Hitbox leftbox = new Hitbox(x - 1, y + 1, 1, 38);
    private Hitbox topbox = new Hitbox(x + 1, y - 1, 38, 1);
    private Hitbox raybox = new Hitbox(x + 1, y + 40, 38, 600 - (y + 40));

    private boolean movable = true;
    private boolean interactable = true;
    private boolean collectedGem;
    private boolean dying;
    private boolean onGround;
    private boolean inGround;
    private boolean jumping;
    private boolean inRightWall;
    private boolean inLeftWall;
    private boolean onRightWall;
    private boolean onLeftWall;
    private boolean inWater;

    private final int deathDelay = 80;
    private int delayCount;
    private List<Hitbox> rayHits = new ArrayList<>();
    private String lastConveyor;
    private PlayerImages images = new PlayerImages();
    private String facing = "right";
    private int animationDelay;
    private int animationPhase;
    private double xvel;
    private FinalAnimation finalAni = new FinalAnimation();
    private int skin = 0;

    public int getScrollX()
    {
        return scrollX;
    }

    public void setSkin(int num)
    {
        skin = num;
    }

    public boolean isMovable()
    {
        return movable;
    }

    public Hitbox getBottombox()
    {
        return bottombox;
    }

    public void update(List<Ground> groundlist, Gem gem, List<Hitbox> deathzones, List<Hitbox> water, List<Hitbox> semiground, List<Hitbox> trampolines, List<Conveyor> conveyors, LevelManager manager)
    {
        if(interactable)
        {
            updateStatus(groundlist, water, semiground);
            if(!onGround || jumping)
            {
                yvel++;
                if(inWater && yvel > 3)
                {
                    yvel = 3;
                }
                y += yvel;
            }
            if(onGround && !jumping)
            {
                yvel = 0;
            }
            updateStatus(groundlist, water, semiground);
            if(touchingGround(topbox, groundlist) && !touchingGround(bottombox, groundlist))
            {
                for(Ground g : groundlist)
                {
                    if(topbox.detectCollision(g.getHitbox()))
                    {
                        y = g.getHitbox().getY() + 40;
                    }
                }
                yvel = 1;
            }
            updateStatus(groundlist, water, semiground);
            if(onGround && !inGround)
            {
                if(touchingList(bottombox, semiground))
                {
                    for(Hitbox box : semiground)
                    {
                        if(bottombox.detectCollision(box))
                        {
                            y = box.getY() - 40;
                        }
                    }
                }
                else
                {
                    for(Ground g : groundlist)
                    {
                        if(bottombox.detectCollision(g.getHitbox()))
                        {
                            y = g.getHitbox().getY() - 40;
                        }
                    }
                }
            }

            if(onGround && inGround)
            {
                if(touchingList(hitbox, semiground))
                {
                    for(Hitbox box : semiground)
                    {
                        if(hitbox.detectCollision(box))
                        {
                            y = box.getY() - 40;
                        }
                    }
                }
                else
                {
                    for(Ground g : groundlist)
                    {
                        if(hitbox.detectCollision(g.getHitbox()))
                        {
                            y = g.getHitbox().getY() - 40;
                        }
                    }
                }
            }
            updateStatus(groundlist, water, semiground);
            //System.out.println(inRightWall);
            if(touchingConveyorWithDirection(bottombox, conveyors) != "false")
            {
                lastConveyor = touchingConveyorWithDirection(bottombox, conveyors);
            }
            if(scrollX % 10 != 0 && touchingConveyorWithDirection(bottombox, conveyors).equals("false"))
            {
                if(lastConveyor == "left")
                {
                    scrollX = (scrollX / 10) * 10;
                }
                else
                {
                    scrollX = ((scrollX - 10) / 10) * 10;
                }
            }

            if(inRightWall)
            {
                for(Ground g : groundlist)
                {
                    if(hitbox.detectCollision(g.getHitbox()))
                    {
                        scrollX = -g.getGridX() * 40 + 420;
                    }
                }
            }
            if(inLeftWall)
            {
                for(Ground g : groundlist)
                {
                    if(hitbox.detectCollision(g.getHitbox()))
                    {
                        scrollX = -g.getGridX() * 40 + 340;
                    }
                }
            }

            if(touchingList(bottombox, trampolines))
            {
                yvel = -25;
            }

            if(touchingConveyorWithDirection(bottombox, conveyors).equals("left"))
            {
                scrollX += 8;
            }
            if(touchingConveyorWithDirection(bottombox, conveyors).equals("right"))
            {
                scrollX -= 8;
            }

            if(dying(hitbox, deathzones))
            {
                die(true);
            }
            if(y > 650)
            {
                die(false);
            }
            if(hitbox.detectCollision(gem.getHitbox()) && gem.getVisible())
            {
                gem.collect();
                movable = false;
                collectedGem = true;
                animationDelay = 0;
            }
        }
        else
        {
            if(dying)
            {
                y += yvel;
                yvel++;
                delayCount++;
                if(delayCount > deathDelay)
                {
                    dying = false;
                    scrollX = 0;
                    y = 440;
                    yvel = 0;
                    manager.resetSpecialBlocks();
                    movable = true;
                    interactable = true;
                }
            }
        }

        if(collectedGem)
        {
            animate(gem);
            finalAni.update();
            String[] arr = MapManager.getLevelStates();
            arr[manager.getLevel() - 1] = "finished";
            if(manager.getLevel() < 4 && arr[manager.getLevel()] != "finished")
            {
                arr[manager.getLevel()] = "unfinished";
            }
            MapManager.setLevelStates(arr);
        }
    }

    public void jump(LevelManager manager, List<Hitbox> trampolines)
    {
        if(onGround && !inWater)
        {
            if(touchingList(bottombox, trampolines))
            {
                yvel = -30;
            }
            else
            {
                yvel = -19;
            }
            manager.flip();
        }
        if(inWater)
        {
            yvel = -10;
        }
    }

    public void moveRight()
    {
        if(!onRightWall)
        {
            scrollX -= 10;
            facing = "right";
        }
    }

    public void moveLeft()
    {
        if(!onLeftWall)
        {
            scrollX += 10;
            facing = "left";
        }
    }

    public void die(boolean withAnimation)
    {
        movable = false;
        interactable = false;
        dying = true;
        delayCount = 0;
        if(withAnimation)
        {
            yvel = -16;
        }
    }

    public void animate(Gem gem)
    {
        if(interactable && onGround)
        {
            if(animationDelay == 0)
            {
                finalAni.animate();
            }
            animationDelay++;
            if(animationDelay > 60)
            {
                interactable = false;
                animationDelay = 0;
                animationPhase = 0;
            }
        }
        if(!interactable)
        {
            animationDelay++;
            facing = "right";
            if(animationPhase == 0)
            {
                if(animationDelay > 15)
                {
                    animationPhase = 1;
                    animationDelay = 0;
                    gem.animate(x, y);
                }
            }
            if(animationPhase == 1)
            {
                if(animationDelay > 40)
                {
                    yvel = -18;
                    animationPhase = 2;
                    animationDelay = 0;
                }
            }
            if(animationPhase == 2)
            {
                y += yvel;
                yvel++;
                updateHitboxes();
                if((hitbox.detectCollision(gem.getHitbox()) && yvel > 0) || yvel > 12)
                {
                    y = gem.getHitbox().getY() - 33;
                    yvel = 0;
                    animationPhase = 3;
                }
            }
            if(animationPhase == 3)
            {
                x += xvel;
                y -= Math.pow(2, 0.225 * xvel);//xvel / 2;
                xvel += 0.5;
                gem.followPlayer(x, y + 27);

                if(x > 900 || y < -100)
                {
                    animationPhase = 4;
                }
            }
        }
    }

    public void reset(LevelManager manager)
    {
        manager.getNewGem();
        x = 380;
        y = 440;
        yvel = 0;
        xvel = 0;
        movable = true;
        interactable = true;
        animationPhase = 0;
        collectedGem = false;
        scrollX = 0;
    }

    public void drawSelf(Graphics g)
    {
        g.drawImage(images.player(facing, dying, skin), x, y, null);
        if(collectedGem)
        {
            finalAni.draw(g);
        }
    }

    private boolean touchingGround(Hitbox h, List<Ground> glist)
    {
        for(Ground g : glist)
        {
            if(h.detectCollision(g.getHitbox()))
            {
                return true;
            }
        }
        return false;
    }

    private boolean dying(Hitbox h, List<Hitbox> dz)
    {
        for(Hitbox box : dz)
        {
            if(h.detectCollision(box))
            {
                return true;
            }
        }
        return false;
    }

    private boolean touchingList(Hitbox h, List<Hitbox> list)
    {
        for(Hitbox box : list)
        {
            if(h.detectCollision(box))
            {
                return true;
            }
        }
        return false;
    }

    private boolean touchingSemiGroundWithExceptions(Hitbox h, List<Hitbox> sg)
    {
        for(Hitbox box : sg)
        {
            if(h.detectCollision(box))
            {
                for(Hitbox ray : rayHits)
                {
                    if(box.equals(ray))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String touchingConveyorWithDirection(Hitbox h, List<Conveyor> cv)
    {
        for(Conveyor c : cv)
        {
            if(h.detectCollision(c.getHitbox()))
            {
                return c.getDirection();
            }
        }
        return "false";
    }

    private void updateStatus(List<Ground> glist, List<Hitbox> w, List<Hitbox> sg)
    {
        updateHitboxes();
        // System.out.println(onGround + " " + inGround);
        if((touchingGround(hitbox, glist) == false && touchingGround(bottombox, glist) == true) || (yvel >= 0 && !touchingList(hitbox, sg) && touchingList(bottombox, sg)))
        {
            onGround = true;
            inGround = false;
        }
        else if(touchingGround(hitbox, glist) == true || (yvel >= 0 && touchingSemiGroundWithExceptions(hitbox, sg)))
        {
            onGround = true;
            inGround = true;
        }
        else
        {
            onGround = false;
            inGround = false;
        }

        if(onGround)
        {
            rayHits.clear();
        }
        else
        {
            for(Hitbox box : sg)
            {
                if(raybox.detectCollision(box))
                {
                    rayHits.add(box);
                }
            }
        }

        if(touchingGround(rightbox, glist) && touchingGround(hitbox, glist))
        {
            inRightWall = true;
            onRightWall = true;
        }
        else if(touchingGround(rightbox, glist) && !touchingGround(hitbox, glist))
        {
            onRightWall = true;
            inRightWall = false;
        }
        else
        {
            onRightWall = false;
            inRightWall = false;
        }

        if(touchingGround(leftbox, glist) && touchingGround(hitbox, glist))
        {
            inLeftWall = true;
            onLeftWall = true;
        }
        else if(touchingGround(leftbox, glist) && !touchingGround(hitbox, glist))
        {
            onLeftWall = true;
            inLeftWall = false;
        }
        else
        {
            onLeftWall = false;
            inLeftWall = false;
        }

        inWater = false;
        for(Hitbox box : w)
        {
            if(hitbox.detectCollision(box))
            {
                inWater = true;
            }
        }

        jumping = yvel < 0;
    }

    private void updateHitboxes()
    {
        hitbox.changeValues(x + 1, y + 1, 38, 38);
        bottombox.changeValues(x + 1, y + 40, 38, 1);
        rightbox.changeValues(x + 40, y + 1, 1, 38);
        leftbox.changeValues(x - 1, y + 1, 1, 38);
        topbox.changeValues(x + 1, y - 1, 38, 1);
        raybox.changeValues(x + 1, y + 40, 38, 600 - (y + 40));
    }
}

import java.awt.*;

public class ChooseManager 
{
    private Option[] skins = new Option[6];
    private String[] names = {"pete", "fred", "veronica", "serena", "bryce", "steven"};

    public ChooseManager()
    {
        for(int i = 0; i < 6; i++)
        {
            skins[i] = new Option(((i * 150) + 210) % 600 + (150 * (i / 3)), 50 + (130 * (i / 3)), names[i], i);
        }
    }

    public void update()
    {
        
    }

    public void mouseMotion(int x, int y)
    {
        for(int i = 0; i < 6; i++)
        {
            skins[i].touchingMouse(x, y);
        }
    }

    public void mouseClick(LevelManager lm)
    {
        for(int i = 0; i < 6; i++)
        {
            skins[i].mouseClick(lm);
            Transition.transition("title", 1);
        }
    }

    public void drawInfo(Graphics g)
    {
        String activeOption = null;
        for(int i = 0; i < 6; i++)
        {
            activeOption = skins[i].gettingInfo();
            if(activeOption != null)
            {
                break;
            }
        }
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.setColor(Color.WHITE);
        if(activeOption == "pete")
        {
            g.drawString("Pete", 20, 380);
        }
        if(activeOption == "fred")
        {
            g.drawString("Fred", 20, 380);
        }
        if(activeOption == "veronica")
        {
            g.drawString("Veronica", 20, 380);
        }
        if(activeOption == "serena")
        {
            g.drawString("Serena", 20, 380);
        }
        if(activeOption == "bryce")
        {
            g.drawString("Bryce", 20, 380);
        }
        if(activeOption == "steven")
        {
            g.drawString("Steven", 20, 380);
        }
        g.setFont(new Font("Arial", Font.PLAIN, 32));
        if(activeOption == "pete")
        {
            g.drawString("The most average guy you'll ever meet.", 20, 420);
            g.drawString("Pale and male but not stale.", 20, 460);
        }
        if(activeOption == "fred")
        {
            g.drawString("Honor student at Cooklin Technical High School.", 20, 420);
            g.drawString("Only gets 3 hours of sleep every night.", 20, 460);
        }
        if(activeOption == "veronica")
        {
            g.drawString("World-class gaslighter and gatekeeper.", 20, 420);
            g.drawString("Only a regional-level girlboss.", 20, 460);
        }
        if(activeOption == "serena")
        {
            g.drawString("Usually calm and tranquil.", 20, 420);
            g.drawString("Gets frisky on weekends.", 20, 460);
        }
        if(activeOption == "bryce")
        {
            g.drawString("Self-proclaimed alpha male.", 20, 420);
            g.drawString("Too afraid to talk to women.", 20, 460);
        }
        if(activeOption == "steven")
        {
            g.drawString("Fell in love with an emo girl.", 20, 420);
            g.drawString("Would grow long black hair if he could.", 20, 460);
        }
    }

    public void draw(Graphics g)
    {
        // g.setColor(new Color());
        // g.fillRect(0, 0, 800, 600);
        for(Option o : skins)
        {
            o.draw(g);
        }
        
        g.setColor(new Color(100, 100, 100));
        g.fillRect(0, 310, 800, 20);
        g.setColor(new Color(160, 160, 160));
        g.fillRect(0, 330, 800, 500);
        drawInfo(g);
    }
}

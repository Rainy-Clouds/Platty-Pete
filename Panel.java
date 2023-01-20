import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener
{
    private static final int width = 800;
    private static final int height = 600; 
    
    public  static int number = 0;

    private boolean running = false;
    private Thread thread;
    private int fps = 60;
    private long time = 1000 / fps;

    private Game game = new Game();
    private boolean upKeyDown = false;
    private boolean rightKeyDown = false;
    private boolean leftKeyDown = false;

    //private FulfillFinalRequirements ffr = new FulfillFinalRequirements(null);

    public Panel()
    {
        this.setPreferredSize(new Dimension(width, height));

        start();
    }

    private void start()
    {
        running = true;
        thread = new Thread(this);
        thread.start();
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        setFocusable(true);
        requestFocus();
    } 

    @Override
    public void run()
    {
        long start;
        long elapsed;
        long wait;
        while(running)
        {
            start = System.nanoTime();

            tick();
            repaint();

            elapsed = System.nanoTime() - start;
            wait = time - elapsed / 1000000;

            if(wait <= 0)
            {
                wait = 5;
            }

            try
            {
                Thread.sleep(wait);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void tick()
    {
        game.tick();
        updateKeys();
    }

    public void paint(Graphics g)
    {
        super.paintComponent(g);

        game.paint(g);
    }
    
    @Override
    public void keyPressed(KeyEvent event)
    {
        if(KeyEvent.getKeyText(event.getKeyCode()) == "Up")
        {
            upKeyDown = true;
        }
        if(KeyEvent.getKeyText(event.getKeyCode()) == "Right")
        {
            rightKeyDown = true;
        }
        if(KeyEvent.getKeyText(event.getKeyCode()) == "Left")
        {
            leftKeyDown = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent event)
    {
        if(KeyEvent.getKeyText(event.getKeyCode()) == "Up")
        {
            upKeyDown = false;
        }
        if(KeyEvent.getKeyText(event.getKeyCode()) == "Right")
        {
            rightKeyDown = false;
        }
        if(KeyEvent.getKeyText(event.getKeyCode()) == "Left")
        {
            leftKeyDown = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent event)
    {
        // nothing
    }

    public void updateKeys()
    {
        if(game.getState() == "level")
        {
            if(upKeyDown)
            {
                game.playerAction("jump");
            }
            if(rightKeyDown)
            {
                game.playerAction("move right");
            }
            if(leftKeyDown)
            {
                game.playerAction("move left");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        // nothing
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        game.mouseClick(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        game.mouseRelease();
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        // nothing
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        // nothing
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // nothin
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        game.mouseMotion(e.getX(), e.getY());
    }
}

import java.util.Scanner;
import java.io.File;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class LevelConverter 
{
    private static LevelImages images = new LevelImages();

    public static String[][] textToLevel(File f)
    {
        try
        {
            Scanner tester = new Scanner(f);
            int length = tester.nextLine().length();
            tester.close();

            Scanner scan = new Scanner(f);
            String[][] arr = new String[15][length];
            int lineOn = 0;
            while(scan.hasNextLine())
            {
                String str = scan.nextLine();
                for(int i = 0; i < str.length(); i++)
                {
                    if(str.charAt(i) == 'g')
                    {
                        arr[lineOn][i] = "grass";
                    }
                    else if(str.charAt(i) == 'd')
                    {
                        arr[lineOn][i] = "dirt";
                    }
                    else if(str.charAt(i) == 'l')
                    {
                        arr[lineOn][i] = "lava";
                    }
                    else if(str.charAt(i) == 'o')
                    {
                        arr[lineOn][i] = "underlava";
                    }
                    else if(str.charAt(i) == 'b')
                    {
                        arr[lineOn][i] = "block";
                    }
                    else if(str.charAt(i) == 't')
                    {
                        arr[lineOn][i] = "temp block";
                    }
                    else if(str.charAt(i) == '1')
                    {
                        arr[lineOn][i] = "red blink";
                    }
                    else if(str.charAt(i) == '2')
                    {
                        arr[lineOn][i] = "blue blink";
                    }
                    else if(str.charAt(i) == 'w')
                    {
                        arr[lineOn][i] = "water";
                    }
                    else if(str.charAt(i) == 'u')
                    {
                        arr[lineOn][i] = "underwater";
                    }
                    else if(str.charAt(i) == 'q')
                    {
                        arr[lineOn][i] = "bridge";
                    }
                    else if(str.charAt(i) == 'k')
                    {
                        arr[lineOn][i] = "spikes";
                    }
                    else if(str.charAt(i) == 'f')
                    {
                        arr[lineOn][i] = "red flip";
                    }
                    else if(str.charAt(i) == 'v')
                    {
                        arr[lineOn][i] = "blue flip";
                    }
                    else if(str.charAt(i) == 'r')
                    {
                        arr[lineOn][i] = "trampoline";
                    }
                    else if(str.charAt(i) == '<')
                    {
                        arr[lineOn][i] = "conveyor left";
                    }
                    else if(str.charAt(i) == '>')
                    {
                        arr[lineOn][i] = "conveyor right";
                    }
                    else if(str.charAt(i) == '[')
                    {
                        arr[lineOn][i] = "conveyor left end";
                    }
                    else if(str.charAt(i) == ']')
                    {
                        arr[lineOn][i] = "conveyor right end";
                    }
                    else if(str.charAt(i) == '*')
                    {
                        arr[lineOn][i] = "gem";
                    }
                    else if(str.charAt(i) == 's')
                    {
                        arr[lineOn][i] = "sand";
                    }
                    else if(str.charAt(i) == 'i')
                    {
                        arr[lineOn][i] = "snow";
                    }
                    else if(str.charAt(i) == 'x')
                    {
                        arr[lineOn][i] = "concrete top";
                    }
                    else if(str.charAt(i) == 'c')
                    {
                        arr[lineOn][i] = "concrete";
                    }
                }
                lineOn++;
            }

            scan.close();
            return arr;
        }
        catch(Exception e)
        {
            System.out.println("Deleted or corrupt file!");
            return null;
        }
    }

    public static void drawLevel(Graphics g, int frame, String path, int scroll, List<SpecialBlock> specials)
    {
        String[][] level = textToLevel(new File(path));
        for(SpecialBlock s : specials)
        {
            s.makeChanges(level);
        }
        for(int i = 0; i < 15; i++)
        {
            for(int j = 0; j < level[0].length; j++)
            {
                if(j * 40 + scroll >= -40 && j * 40 + scroll <= 840) {
                    if(level[i][j] == "grass")
                    {
                        g.drawImage(images.grass(), j * 40 + scroll, i * 40, null);
                        // g.setColor(new Color(0, 255, 0));
                        // g.fillRect(j * 40 + scroll, i * 40, 40, 40);
                    }
                    if(level[i][j] == "dirt")
                    {
                        g.drawImage(images.dirt(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "lava")
                    {
                        g.drawImage(images.lava(frame), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "underlava")
                    {
                        g.drawImage(images.underlava(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "block")
                    {
                        g.drawImage(images.block(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "temp block")
                    {
                        g.drawImage(images.tempblock(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "temp block breaking")
                    {
                        g.drawImage(images.tempblockbreak(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "red blink")
                    {
                        g.drawImage(images.redblink(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "blue blink")
                    {
                        g.drawImage(images.blueblink(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "water")
                    {
                        g.drawImage(images.water(frame), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "underwater")
                    {
                        g.drawImage(images.underwater(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "bridge")
                    {
                        g.drawImage(images.bridge(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "spikes off")
                    {
                        g.drawImage(images.spikesoff(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "spikes")
                    {
                        g.drawImage(images.spikes(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "red flip")
                    {
                        g.drawImage(images.redflip(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "blue flip")
                    {
                        g.drawImage(images.blueflip(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "trampoline")
                    {
                        g.drawImage(images.trampoline(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "conveyor left")
                    {
                        g.drawImage(images.conveyorleft(frame), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "conveyor right")
                    {
                        g.drawImage(images.conveyorright(frame), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "conveyor left end")
                    {
                        g.drawImage(images.conveyorleftend(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "conveyor right end")
                    {
                        g.drawImage(images.conveyorrightend(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "empty frame")
                    {
                        g.drawImage(images.frame(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "sand")
                    {
                        g.drawImage(images.sand(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "snow")
                    {
                        g.drawImage(images.snow(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "concrete top")
                    {
                        g.drawImage(images.concretetop(), j * 40 + scroll, i * 40, null);
                    }
                    if(level[i][j] == "concrete")
                    {
                        g.drawImage(images.concrete(), j * 40 + scroll, i * 40, null);
                    }
                }
            }
        }
    }

    public static List<SpecialBlock> getSpecialBlocks(String path)
    {
        List<SpecialBlock> sb = new ArrayList<>();
        String[][] level = textToLevel(new File(path));
        for(int i = 0; i < 15; i++)
        {
            for(int j = 0; j < level[0].length; j++)
            {
                if(level[i][j] == "temp block" || level[i][j] == "red blink" || level[i][j] == "blue blink" || level[i][j] == "spikes" || level[i][j] == "red flip" || level[i][j] == "blue flip")
                {
                    sb.add(new SpecialBlock(j, i, level[i][j]));
                }
            }
        }
        return sb;
    }

    public static void getLists(String path, int scroll, List<SpecialBlock> specials, List<Ground> glist, List<Hitbox> dzlist, List<Hitbox> wlist, List<Hitbox> sglist, List<Hitbox> tlist, List<Conveyor> clist)
    {
        String[][] level = textToLevel(new File(path));
        for(SpecialBlock s : specials)
        {
            s.makeChanges(level);
        }
        for(int i = 0; i < 15; i++)
        {
            for(int j = 0; j < level[0].length; j++)
            {
                if(j * 40 + scroll >= -40 && j * 40 + scroll <= 840) {
                    if(level[i][j] == "grass" || level[i][j] == "sand" || level[i][j] == "snow" || level[i][j] == "concrete top" || level[i][j] == "concrete" || level[i][j] == "dirt" || level[i][j] == "block" || level[i][j] == "temp block" || level[i][j] == "temp block breaking" || level[i][j] == "red blink" || level[i][j] == "blue blink" || level[i][j] == "spikes off" || level[i][j] == "red flip" || level[i][j] == "blue flip" || level[i][j] == "trampoline" || level[i][j] == "conveyor left" || level[i][j] == "conveyor right" || level[i][j] == "conveyor left end" || level[i][j] == "conveyor right end")
                    {
                        glist.add(new Ground(j * 40 + scroll, i * 40, 40, 40, j));
                    }
                    if(level[i][j] == "lava")
                    {
                        dzlist.add(new Hitbox(j * 40 + scroll, i * 40 + 6, 40, 34));
                    }
                    if(level[i][j] == "spikes" || level[i][j] == "underlava")
                    {
                        dzlist.add(new Hitbox(j * 40 + scroll, i * 40, 40, 40));
                    }
                    if(level[i][j] == "water" || level[i][j] == "underwater")
                    {
                        wlist.add(new Hitbox(j * 40 + scroll, i * 40, 40, 40));
                    }
                    if(level[i][j] == "bridge")
                    {
                        sglist.add(new Hitbox(j * 40 + scroll, i * 40, 40, 20));
                    }
                    if(level[i][j] == "trampoline")
                    {
                        tlist.add(new Hitbox(j * 40 + scroll, i * 40, 40, 40));
                    }
                    if(level[i][j] == "conveyor left" || level[i][j] == "conveyor right")
                    {
                        clist.add(new Conveyor(level[i][j].substring(9), j * 40 + scroll, i * 40, 40, 40));
                    }
                }
            }
        }
    }
}
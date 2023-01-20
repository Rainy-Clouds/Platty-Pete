public class FulfillFinalRequirements 
{
    private int[] arr = {1, 2, 3, 4};
    private Hitbox myHitbox;

    /**
     * Sorry Mr. Holmer the rest of the requirements are scattered elsewhere in the code, you might have to search for them
     * @param h hitbox
     */
    public FulfillFinalRequirements(Hitbox h)
    {
        myHitbox = h;
        System.out.println(myHitbox);  
        Panel.number++;
        int exec = 0;
        for(int i = 0; i < 5; i++)
        {
            exec++;
        }
        System.out.println("Executed " + exec + " times.");
    }

    /**
     * Reverses the contents of an object array.
     * @param arr - An array of any objects
     * @return The array in reverse
     */
    public static Object[] reverse(Object[] arr)
    {
        Object[] newArr = new Object[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            newArr[arr.length - (i + 1)] = arr[i];
        }
        return newArr;
    }

    /**
     * Pre-condition: w and h should be more than 0.
     * @param x x-value
     * @param y y-value
     * @param w width
     * @param h height
     * @return a new hitbox with your values
     */
    public Hitbox makeABox(int x, int y, int w, int h)
    {
        return new Hitbox(x, y, w, h);
    }

    /**
     * Returns the square root of the number entered in the parameter
     * Pre-condition: num must be positive
     * Post-condition: it will return a number more than 0.
     * @param num number to square root
     * @return square root of num.
     */
    public double squareRoot(int num)
    {
        return Math.sqrt(num);
    }

    /**
     * Benefits Nigerian culture by telling people of the three main groups its made of
     * My family is from the Yoruba, btw.
     */
    public static void benefitNigerianCulture()
    {
        System.out.println("Nigeria has rich culture shaped by it's three main ethnic groups, the Hausas in the North, the Yoruba in the Southwest, and the Igbo in the Southeast.");
    }
}

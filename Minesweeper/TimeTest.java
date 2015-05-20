
/**
 * Write a description of class TimeTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimeTest
{
    // instance variables - replace the example below with your own
    private int x;
    private FileWrite test= new FileWrite();
    /**
     * Constructor for objects of class TimeTest
     */
    public void main(String [] args)
    {
        test.addWin(10);
        test.addWin(5);
        test.addLoss();
        test.addWin(7);
        System.out.println(test.getWinPercent());
        System.out.println(test.getBestTime());
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}

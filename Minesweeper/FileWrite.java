import java.io.*;
public class FileWrite 
{
    private int numGames;
    private int numWins;
    private FileWriter fstream;
    private BufferedWriter out;
    private int maxWinStreak=0;
    public FileWrite()
    {
        try{
            // Create file 
            FileWriter fstream = new FileWriter(System.currentTimeMillis() + "out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("Statistics");
            out.newLine();
            //Close the output stream
            out.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void addWin(int time){
        try{
        out.write("W:"+time);
        out.newLine();
        out.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void addLoss(){
        try{
        out.write("L");
        out.newLine();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
   
    
}
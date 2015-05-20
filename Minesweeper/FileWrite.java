import java.io.*;
import java.io.FileReader;
import java.util.Date;

public class FileWrite 
{
    private int numGames;
    private int numWins;
    private FileWriter fstream;
    private BufferedWriter out;
    private int bestTime;
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
        //writes "W" into file for every win, adds time next to it
        try{
            out.write("W: "+time);
            out.newLine();
            out.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void addLoss(){
        //writes "L" into file for every loss
        try{
            out.write("L");
            out.newLine();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void getWinPercent(){
        int wins=0;
        int losses=0;
        double winPercent=0;
        try (BufferedReader br = new BufferedReader(new FileReader("StatsReader"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                if(br.readLine().substring(0,1).equals("W")){
                    wins++;
                }
                else if(br.readLine().substring(0,1).equals("L")){
                    losses++;
                }
            }
            winPercent=(double) wins/(double) losses;
            out.write("Win Percentage: "+winPercent);
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void getBestTime(){
        //reads file line by line to determine best time
        int bestTime=Integer.MAX_VALUE;
        try (BufferedReader br = new BufferedReader(new FileReader("StatsReader"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                if(br.readLine().substring(0,1).equals("W")){
                    if(Integer.parseInt(br.readLine().substring(3))<bestTime){
                        bestTime=Integer.parseInt(br.readLine().substring(3));
                    }
                }
            }
            out.write("Best Time: "+bestTime);
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

    }

}
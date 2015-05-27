import java.io.*;
import java.util.*;

public class FileWrite 
{
    private int games, wins, atime, best;
    FileOutputStream fos;
    BufferedWriter bufferedWriter;
    public FileWrite()
    {
        try{
            File file =new File("Statistics");
 
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    			
    		}
            Scanner sc = new Scanner(file);
            games=sc.nextInt();
            wins=sc.nextInt();
            atime=sc.nextInt();
            best=sc.nextInt();
            
            fos=new FileOutputStream(file, true);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos));
            
        }catch (Exception e){//Catch exception if any
            e.printStackTrace();
        }
    }

    public void addWin(int time) throws IOException{
        File file =new File("Statistics");
        fos=new FileOutputStream(file, true);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos));
        games++;
        wins++;
        atime=(atime*wins+time)/(wins+1);
        if (time<best){
            best=time;
        }
        bufferedWriter.write(games);
        bufferedWriter.newLine();
        bufferedWriter.write(wins);
        bufferedWriter.newLine();
        bufferedWriter.write(atime);
        bufferedWriter.newLine();
        bufferedWriter.write(best);        
    }

    public void addLoss() throws IOException{
        games++;
        bufferedWriter.write(games);
        bufferedWriter.newLine();
    }

    
}
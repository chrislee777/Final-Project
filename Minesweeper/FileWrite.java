import java.io.*;
public class FileWrite 
{
    public static void main(String args[])
    {
        try{
            // Create file 
            FileWriter fstream = new FileWriter(System.currentTimeMillis() + "out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("Statistics");
            //Close the output stream
            out.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
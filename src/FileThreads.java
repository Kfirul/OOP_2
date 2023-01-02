import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileThreads extends Thread {
    private String nameFile;
    private int countRows;

    public FileThreads(String nameFile){
    this.nameFile=nameFile;
    }

    public void run(){
        try {
            FileReader ffw = new FileReader(nameFile);
            BufferedReader bbw = new BufferedReader(ffw);
            while (bbw.readLine() != null)
                countRows++;

            bbw.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCountRows(){
        return countRows;
        }
}

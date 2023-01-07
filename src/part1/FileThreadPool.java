package part1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class FileThreadPool implements Callable<Integer> {
    private String nameFile;
    private int countRows;

    public FileThreadPool(String nameFile){
        this.nameFile=nameFile;
    }
    @Override
    public Integer call() throws Exception {
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
        return countRows;

    }

}

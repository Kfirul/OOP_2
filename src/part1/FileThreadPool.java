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
/**

 The call() method is used to read a file and count the number of rows in the file.
 The name of the file to be read is passed as a parameter to the constructor of the class or set before this method call,
 If the file is not found, a FileNotFoundException is thrown.
 If there is an issue reading the file, an IOException is thrown.
 @return The number of rows in the file as an Integer.
**/
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

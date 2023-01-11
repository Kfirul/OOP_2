package part1;

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

    /**

     The run() method is used to read a file and count the number of rows in the file.

     The name of the file to be read is passed as a parameter to the constructor of the class.

     If the file is not found, a FileNotFoundException is thrown.

     If there is an issue reading the file, an IOException is thrown.
     */
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

    /**

     The getCountRows() method returns the number of rows counted in the file that was read by the run() method.
     @return int - The number of rows in the file.
     */
    public int getCountRows(){
        return countRows;
        }
}

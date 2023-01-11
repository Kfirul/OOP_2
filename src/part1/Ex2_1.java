package part1;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex2_1 {

    /**
     The createTextFiles() method is used to create a specified number (n) of text files, with each file containing a random number of lines
     (up to the specified bound) of text "Hello Universe".
     The file names are generated in the format "file_x", where x is the number of the file starting from 1.
     A seed value can be provided to initialize the random number generator.
     @param n - The number of files to be created.
     @param seed - The seed value for the random number generator.
     @param bound - The upper bound for the number of lines in each file.
     @return String[] - An array of strings containing the names of the created files.
     */
    public static String[] createTextFiles(int n, int seed, int bound) {
        String[] filesNames = new String[n];
        Random rand = new Random(seed);
        try {
            for (int i = 1; i <= n; i++) {
                String name = "file_" + i;
                File file = new File(name);
                filesNames[i - 1] = name;
                file.createNewFile();
                int numRows = rand.nextInt(bound);
                FileWriter fw = new FileWriter(name);
                for (int j = 0; j < numRows - 1; j++) {
                    fw.write(("Hello Universe\n"));
                }
                fw.write(("Hello Universe"));
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filesNames;
    }
    /**
     The getNumOfLines() method is used to count the number of lines in a given set of files.
     @param fileNames - A string array containing the names of the files to be read.
     @return int - The total number of lines in the specified files.
     @throws IOException - If there is an issue reading the files.
     */
    public static int getNumOfLines(String[] fileNames)  {
        int countRows = 0;
        try {
        for (int i = 0; i < fileNames.length; i++) {

                FileReader ffw = new FileReader(fileNames[i]);
                BufferedReader bbw = new BufferedReader(ffw);
                while (bbw.readLine() != null)
                    countRows++;

                bbw.close();
            }

        }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

            return countRows;
        }
    /**
     The getNumOfLinesThreads() method is used to count the number of lines in a given set of files using a Threads and join each thread to sum
     @param fileNames - A string array containing the names of the files to be read.
     @return int - The total number of lines in the specified files.
     @throws InterruptedException - if any thread is interrupted while joining
     */
    public int getNumOfLinesThreads(String[] fileNames) throws InterruptedException {
        int sum=0;
        for(int i=0;i< fileNames.length;i++){
            FileThreads fileThreads=new FileThreads(fileNames[i]);
            fileThreads.start();
            fileThreads.join();
            sum=sum+ fileThreads.getCountRows();
        }
        return sum;
    }
    /**
     The getNumOfLinesThreadPool() method is used to count the number of lines in a given set of files using a thread pool.
     It creates a fixed thread pool with the size equal to the number of fileNames,
     and a FileThreadPool object is created and submitted to the thread pool for each file.
     The method blocks until all the fileThreadPool has been processed,
     and the number of lines counted by each thread is added to get the total number of lines.
     @param fileNames - A string array containing the names of the files to be read.
     @return int - The total number of lines in the specified files.
     @throws Exception - if any exception is thrown while getting the result of Future
     */
    public int getNumOfLinesThreadPool(String[] fileNames) throws Exception {
        int sum=0;
        ArrayList<Future> futures= new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(fileNames.length);
        for(int i=0;i< fileNames.length;i++){
            FileThreadPool ftp=new FileThreadPool(fileNames[i]);
            futures.add(executor.submit(ftp));

        }
        executor.shutdown();
        for (Future f : futures) {
            sum=sum+(Integer)f.get();
        }
        return sum;
    }


    }



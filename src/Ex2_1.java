import java.io.*;
import java.util.Random;

public class Ex2_1 {

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
    public static int getNumOfLinesThreads(String[] fileNames) throws InterruptedException {
        int sum=0;
        for(int i=0;i< fileNames.length;i++){
            FileThreads fileThreads=new FileThreads(fileNames[i]);
            fileThreads.start();
            fileThreads.join();
            sum=sum+ fileThreads.getCountRows();
        }
        return sum;
    }
//    public static int getNumOfLinesThreadPool(String[] fileNames){
//
//    }


    }



package part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
public class Ex2 {
    public static void main(String[] args) throws Exception {

        String [] nameFiles=Ex2_1.createTextFiles(1000,20,500);

        long start = System.currentTimeMillis();
        Ex2_1.getNumOfLines(nameFiles);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time in seconds without threads: "+ (end-start)*0.001);

        start = System.currentTimeMillis();
        Ex2_1 thread = new Ex2_1();
        thread.getNumOfLinesThreads(nameFiles);
        end = System.currentTimeMillis();
        System.out.println("Elapsed Time in seconds using threads: "+ (end-start)*0.001);

        start = System.currentTimeMillis();
        Ex2_1 threadPool = new Ex2_1();
        threadPool.getNumOfLinesThreadPool(nameFiles);
        end = System.currentTimeMillis();
        System.out.println("Elapsed Time in seconds using thread-pool: "+ (end-start)*0.001);
        deleteFiles(1000);
    }

    public static void deleteFiles(int n)
    {
        for (int i = 1; i <= n; i++) {
            String name = "file_"+i;
            File file = new File(name);
            file.delete();
        }
    }
}
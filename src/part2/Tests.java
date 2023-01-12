package part2;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.PriorityQueue;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    @Test
    public void partialTest(){
        CustomExecutor customExecutor = new CustomExecutor();
        var task = Task.createTask(()->{
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        }, TaskType.COMPUTATIONAL);
        var sumTask = customExecutor.submit(task);
        final int sum;
        try {
            sum = (int) sumTask.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        logger.info(()-> "Sum of 1 through 10 = " + sum);
        Callable<Double> callable1 = ()-> {
            return 1000 * Math.pow(1.02, 5);
        };
        Callable<String> callable2 = ()-> {
            StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            return sb.reverse().toString();
        };
        // var is used to infer the declared type automatically
        var priceTask = customExecutor.submit(()-> {
            return 1000 * Math.pow(1.02, 5);
        }, TaskType.COMPUTATIONAL);
        var reverseTask = customExecutor.submit(callable2, TaskType.IO);
        final Double totalPrice;
        final String reversed;
        try {
            totalPrice = priceTask.get();
            reversed = reverseTask.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        logger.info(()-> "Reversed String = " + reversed);
        logger.info(()->String.valueOf("Total Price = " + totalPrice));
        logger.info(()-> "Current maximum priority = " +
                customExecutor.getCurrentMax());
        customExecutor.gracefullyTerminate();
    }
    @Test
    public void queueOrderByPriority()  {
        PriorityQueue<AdaptTask> queue = new PriorityQueue<AdaptTask>();
        Task<Integer> task1 = Task.createTask(() -> {
            Thread.sleep(1000);
            return 1;
        }, TaskType.COMPUTATIONAL);
        AdaptTask taskAdapt1=new AdaptTask(task1);
        Task<Integer> task2 = Task.createTask(() -> {
            Thread.sleep(1000);
            return 1;
        }, TaskType.IO);
        AdaptTask taskAdapt2=new AdaptTask(task2);

        Task<Integer> task3 = Task.createTask(() -> {
            Thread.sleep(1000);
            return 1;
        }, TaskType.OTHER);
        AdaptTask taskAdapt3=new AdaptTask(task3);

        queue.add(taskAdapt3);
        queue.add(taskAdapt2);
        queue.add(taskAdapt1);
        assertEquals(1 , queue.poll().getTask().getPriority());
        assertEquals(2 , queue.poll().getTask().getPriority());
        assertEquals(3, queue.poll().getTask().getPriority());

    }
}


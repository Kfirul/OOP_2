package part2;

import java.util.*;
import java.util.concurrent.*;

public class CustomExecutor extends ThreadPoolExecutor {

    private int CurrentMax;
    public CustomExecutor() {
        super(Runtime.getRuntime().availableProcessors() / 2,
                Runtime.getRuntime().availableProcessors() - 1,
                300,TimeUnit.MILLISECONDS,new PriorityBlockingQueue<Runnable>()) ;

        CurrentMax=10;
    }
    private <T> Future<Task> customSubmit(Task<T> task){
        CurrentMax=(Math.min(CurrentMax,task.getPriorty()));
        return super.submit(task);
    }
    public <T> Future<T> submit(Callable <T> task){
        Task newTask= new Task<>(task);
        return customSubmit(newTask);
    }
    public <T> Future<T> submit(Callable <T> task,TaskType taskType){
        Task newTask= new Task<>(task,taskType);
        return customSubmit(newTask);
    }
    public int getCurrentMax() {
        return CurrentMax;
    }

    public void gracefullyTerminate() {
        shutdown();
    }

}

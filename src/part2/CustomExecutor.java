package part2;

import java.util.concurrent.*;

public class CustomExecutor extends ThreadPoolExecutor {

    private int [] countPriorty={0,0,0,0};

    public CustomExecutor() {
        super(Runtime.getRuntime().availableProcessors() / 2,
                Runtime.getRuntime().availableProcessors() - 1,
                300,TimeUnit.MILLISECONDS,new PriorityBlockingQueue<>()) ;

    }

    private <T> Future<T> customSubmit(Task<T> task){
        countPriorty[task.getPriority()] = countPriorty[task.getPriority()]+1;
        if (task == null || task.getCallable() == null)
            throw new NullPointerException();
        RunnableFuture<T> customTask = new AdptFutureTask<>(task);
        execute(customTask);
        return customTask;
    }

    public <T> Future<T> submit(Callable <T> task){
        Task<T> newTask= Task.createTask(task);
        return customSubmit(newTask);
    }

    public <T> Future<T> submit(Callable <T> task,TaskType taskType){
        Task<T>  newTask= Task.createTask(task,taskType);
        return customSubmit(newTask);
    }

    public int getCurrentMax() {
        for (int i = 1; i <= 3; i++) {
            if (countPriorty[i]>0)
                return i;
        }
        return 0;
    }


    public void gracefullyTerminate() {
            shutdown();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        boolean found=false;
        for(int i=1;i<=3 && !found;i++){
                if(countPriorty[i]>0){
                    countPriorty[i]= countPriorty[i]-1;
                    found =true;
                }
        }
    }
}

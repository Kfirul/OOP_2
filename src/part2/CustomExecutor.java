package part2;

import java.util.Arrays;
import java.util.concurrent.*;

public class CustomExecutor extends ThreadPoolExecutor {

    private int [] countPriorty;

    /**
     *  CustomExecutor constructor which initializes the ThreadPoolExecutor with the number of available processors
     *  divided by 2 as core pool size, the number of available processors minus 1 as maximum pool size, 300 milliseconds as keep alive time and a
     *  PriorityBlockingQueue as the work queue. It also initializes an array to keep track of the number of tasks with each priority.
     */
    public CustomExecutor() {
        super(Runtime.getRuntime().availableProcessors() / 2,
                Runtime.getRuntime().availableProcessors() - 1,
                300,TimeUnit.MILLISECONDS,new PriorityBlockingQueue<>()) ;
        countPriorty=new int[11];
    }
    /**
     *  Submits a task for execution and returns a Future representing that task.
     *  It increments the count of the number of tasks with the same priority as the input task.
     *
     * @param task the task to be submitted
     * @return a Future representing pending completion of the task
     * @throws NullPointerException if task is null or if task's callable is null
     */
    private <T> Future<T> customSubmit(Task<T> task){
        synchronized(task) {
            countPriorty[task.getPriority()] = countPriorty[task.getPriority()] + 1;
        }
            if (task == null || task.getCallable() == null)
                throw new NullPointerException();
            RunnableFuture<T> customTask = new AdaptTask<>(task);
            execute(customTask);
            return customTask;
        }

    /**
     * Submits a task with default priority for execution and returns a Future representing that task.
     * It creates a new Task instance with the input task and default priority, then submit the new task to execution.
     *
     * @param task the task to be submitted
     * @return a Future representing pending completion of the task
     * @throws NullPointerException if task is null
     */
    public <T> Future<T> submit(Callable <T> task){
        Task<T> newTask= Task.createTask(task);
        return customSubmit(newTask);
    }
    /**
     * Submits a task with input priority for execution and returns a Future representing that task.
     * It creates a new Task instance with the input task and input priority, then submit the new task to execution.
     *
     * @param task the task to be submitted
     * @param taskType the taskType that determine the priority of the task
     * @return a Future representing pending completion of the task
     * @throws NullPointerException if task is null
     */
    public <T> Future<T> submit(Callable <T> task,TaskType taskType){
        Task<T>  newTask= Task.createTask(task,taskType);
        return customSubmit(newTask);
    }
    /**
     * Returns the current maximum priority among the tasks in the work queue.
     *
     * @return the maximum priority
     */
    public synchronized int getCurrentMax() {
        for (int i = 1; i <= 10; i++) {
            if (countPriorty[i]>0)
                return i;
        }
        return 0;
    }
    /**
     * Initiates an orderly shutdown in which previously submitted tasks are executed,
     * but no new tasks will be accepted.
     */

    public void gracefullyTerminate() {
            shutdown();
    }

    /**
     *  Overrides the beforeExecute() method of the ThreadPoolExecutor class.
     *  Decrements the count of the number of tasks with the maximum priority.
     *
     * @param t the thread that will execute the task
     * @param r the task that will be executed
     */
    @Override
    protected synchronized void beforeExecute(Thread t, Runnable r) {
        boolean found=false;
        for(int i=1;i<=10 && !found;i++){
                if(countPriorty[i]>0){
                    countPriorty[i]= countPriorty[i]-1;
                    found =true;
                }
        }
    }

    @Override
    public String toString() {
        return "CustomExecutor{" +
                "countPriorty=" + Arrays.toString(countPriorty) +
                '}';
    }
}

package part2;

import java.util.concurrent.Callable;

public class Task<T> implements Callable,Comparable <Task<T>> {
    private Callable<T> callable;
    private Integer priorty;

    public Task(Callable<T> callable,TaskType taskType){
        this.callable=callable;
        priorty=taskType.getPriorityValue();
    }
    public Task(Callable<T> callable){
        this.callable=callable;
        priorty=3;
    }
    public static Task createTask(Callable callable,TaskType taskType){
          return new Task(callable, taskType);
    }

    @Override
    public T call() throws Exception {
        return callable.call();
    }

    public Callable<T> getCallable() {
        return callable;
    }

    public void setCallable(Callable<T> callable) {
        this.callable = callable;
    }

    public int getPriorty() {
        return priorty;
    }



    @Override
    public int compareTo(Task o) {
        return this.priorty.compareTo(o.priorty);
    }

}

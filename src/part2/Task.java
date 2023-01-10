package part2;

import java.util.concurrent.Callable;

public class Task<T> implements Callable,Comparable <Task<T>> {
    private Callable<T> callable;
    private Integer priority;

    protected Task(Callable<T> callable,TaskType taskType){
        this.callable=callable;
        priority=taskType.getPriorityValue();
    }
    protected Task(Callable<T> callable){
        this.callable=callable;
        this.priority=3;
    }
    public static<T> Task<T> createTask(Callable callable,TaskType taskType){
          return new Task(callable, taskType);
    }

    public static <T> Task<T> createTask(Callable callable){
        return new Task(callable);

    }

    @Override
    public T call() throws Exception {
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Callable<T> getCallable() {
        return callable;
    }

    public void setCallable(Callable<T> callable) {
        this.callable = callable;
    }

    public int getPriority() {
        return priority;
    }


    @Override
    public int compareTo(Task o) {
        return  this.priority.compareTo(o.priority);
    }


    @Override
    public String toString() {
        return "Task{" +
                "callable=" + callable +
                ", priority=" + priority +
                '}';
    }
}

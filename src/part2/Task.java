package part2;

import java.util.concurrent.Callable;

public class Task<V> implements Callable,Comparable <Task> {
    private Callable<V> callable;
    private TaskType taskType;

    public Task(Callable<V> callable,TaskType taskType){
        this.callable=callable;
        this.taskType=taskType;
    }

    public static Task newTask(Callable callable,TaskType taskType){
          return new Task(callable, taskType);
    }

    @Override
    public V call() throws Exception {
        return callable.call();
    }

    public Callable<V> getCallable() {
        return callable;
    }

    public void setCallable(Callable<V> callable) {
        this.callable = callable;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    @Override
    public int compareTo(Task o) {
        return this.taskType.compareTo(o.taskType);
    }

}

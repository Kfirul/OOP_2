package part2;

import java.util.concurrent.Callable;

public class Task<T> implements Callable,Comparable <Task> {
    private Callable<T> callable;
    private TaskType taskType;

    public Task(Callable<T> callable,TaskType taskType){
        this.callable=callable;
        this.taskType=taskType;
    }
    public Task(Callable<T> callable){
        this.callable=callable;
        taskType.setPriority(3);
    }
    public static Task newTask(Callable callable,TaskType taskType){
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

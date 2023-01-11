package part2;

import java.util.concurrent.Callable;

public class Task<T> implements Callable,Comparable <Task<T>> {
    private Callable<T> callable;
    private Integer priority;
    /**
     * Constructor that creates a Task and sets the Callable instance to the
     * input callable and the priority to the priority value of the input taskType.
     *
     * @param callable the callable instance to be wrapped by this Task
     * @param taskType the taskType that determine the priority of the task
     */
    protected Task(Callable<T> callable,TaskType taskType){
        this.callable=callable;
        priority=taskType.getPriorityValue();
    }
    /**
     * Constructor that creates a Task and sets the Callable instance to the input callable and the default priority value to 3
     *
     * @param callable the callable instance to be wrapped by this Task
     */
    protected Task(Callable<T> callable){
        this.callable=callable;
        this.priority=3;
    }
    /**
     *  a static factory method that creates and returns a new Task instance with the input callable and taskType.
     *
     * @param callable the callable instance to be wrapped by the created Task
     * @param taskType the taskType that determine the priority of the task
     * @return a new Task instance
     */
    public static<T> Task<T> createTask(Callable callable,TaskType taskType){
          return new Task(callable, taskType);
    }
    /**
     *  a static factory method that creates and returns a new Task instance with the input callable and default priority.
     *
     * @param callable the callable instance to be wrapped by the created Task
     * @return a new Task instance
     */
    public static <T> Task<T> createTask(Callable callable){
        return new Task(callable);

    }
    /**
     * Override of the Callable interface's call() method. It will call the call() method of the Callable
     * instance that this Task class wraps and return the result.
     * It also catch the exception thrown by the call() method, wrap it with a new RuntimeException and re-throw it.
     *
     * @throws Exception throws the exception caught by the call() method wrapped with a RuntimeException
     * @return the result returned by the call() method of the Callable instance
     */
    @Override
    public T call() throws Exception {
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Getter method that returns the Callable instance that this Task class wraps.
     *
     * @return the Callable instance wrapped by this Task
     */
    public Callable<T> getCallable() {
        return callable;
    }
    /**
     * Setter method that sets the Callable instance that this Task class wraps.
     *
     * @param callable the callable instance to be wrapped by this Task
     */
    public void setCallable(Callable<T> callable) {
        this.callable = callable;
    }
    /**
     * Getter method that returns the priority of the Task
     *
     * @return the priority of the task
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Overrides the compareTo method, compares the priority of this Task to the priority of the input Task,
     * return 0 if the priorities are the same, a value less than 0 if this task's priority is less than the input task's priority,
     * and a value greater than 0 if this task's priority is greater than the input task's priority.
     *
     * @param o the input task to be compared to this task
     * @return the comparison result
     */
    @Override
    public int compareTo(Task o) {
        return  this.priority.compareTo(o.priority);
    }
/**
 * Returns the string representation of the object.
 *
 * @return a string representation of
 **/

    @Override
    public String toString() {
        return "Task{" +
                "callable=" + callable +
                ", priority=" + priority +
                '}';
    }
}

package part2;

import java.util.concurrent.FutureTask;

public class AdaptTask<T> extends FutureTask<T> implements Comparable<AdaptTask<T>> {
    private Task<T> taskCustom;

    /**
     * Constructor that creates an AdaptFutureTask instance and sets the input task to be wrapped.
     *
     * @param task the task to be wrapped by this AdaptFutureTask instance
     */
    public AdaptTask(Task<T> task) {
        super(task);
        this.taskCustom = task;
    }
    /**
     * Getter method that returns the task wrapped by this AdaptFutureTask instance.
     *
     * @return the task wrapped by this AdaptFutureTask instance
     */
    public Task<T> getTask(){
        return taskCustom;
    }
    /**
     * Overrides the compareTo() method of the FutureTask class.
     * Compares the task wrapped by this AdaptFutureTask instance with the task wrapped by the input AdaptFutureTask instance based on their priorities.
     *
     * @param other the AdaptFutureTask instance to be compared to this AdaptFutureTask instance
     * @return the comparison result
     */
    @Override
    public int compareTo(AdaptTask<T> other){
        return taskCustom.compareTo(other.getTask());
    }
}

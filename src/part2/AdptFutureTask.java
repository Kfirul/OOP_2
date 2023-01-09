package part2;

import java.util.concurrent.FutureTask;

public class AdptFutureTask<T> extends FutureTask<T> implements Comparable<AdptFutureTask<T>> {
    private Task<T> taskCustom;

    public AdptFutureTask(Task<T> task) {
        super(task);
        this.taskCustom = task;
    }

    public Task<T> getTask(){
        return taskCustom;
    }

    @Override
    public int compareTo(AdptFutureTask<T> other){
        return taskCustom.compareTo(other.getTask());
    }
}

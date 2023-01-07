package part2;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomExecutor {
    private Queue<Task> taskQueue;
    private ThreadPoolExecutor executor;
    private TaskType CurrentMax;
    public CustomExecutor() {
        taskQueue = new LinkedList<Task>();
        CurrentMax.setPriority(10);
    }

    public int getCurrentMax() {
        return CurrentMax.getPriorityValue();
    }
}

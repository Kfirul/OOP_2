//package part2;
//
//import java.util.*;
//import java.util.concurrent.*;
//
//public class CustomExecutor {
//    private PriorityBlockingQueue<Task> taskQueue;
//   // private ArrayList<Task> taskQueue1=new ArrayList<Task>();
//    private ThreadPoolExecutor executor;
//    private TaskType CurrentMax;
//    public CustomExecutor() {
//        taskQueue =new PriorityBlockingQueue<>();
//        executor=new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() / 2,
//                Runtime.getRuntime().availableProcessors() - 1,300,TimeUnit.MILLISECONDS,taskQueue) ;
//        CurrentMax.setPriority(10);
//    }
//    public <T> Future<Task> submit(Task<T> task){
//        taskQueue.add(task);
//        CurrentMax.setPriority(Math.min(CurrentMax.getPriorityValue(),task.getTaskType().getPriorityValue()));
//        return executor.submit(task);
//    }
////    public <T> Future<Task> submit(Task<T> task){
////
////    }
//    public int getCurrentMax() {
//        return CurrentMax.getPriorityValue();
//    }
//
//    public void gracefullyTerminate() {
//        executor.shutdown();
//    }
//}

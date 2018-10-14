package jichu.Multithreading.mashibing.T26;

import com.sun.org.apache.xalan.internal.utils.FeatureManager;

import java.util.concurrent.*;

/**
 * FutureTask未来的任务，这个任务会有一个返回值
 * FutureTask对Callable进行了包装，因为Callable也没有get方法，阻塞着等结果
 *
 * submit就已经new了一个FutureTask，把结果扔到Future中
 * @Author: liangxiao
 * @Date: Created in 10:51 2018/10/14
 */
public class T06_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });

        new Thread(task).start();

        System.out.println(task.get());//阻塞

        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f=service.submit(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 2;
        });

        System.out.println(f.isDone());
        System.out.println(f.get());
        System.out.println(f.isDone());

    }
}

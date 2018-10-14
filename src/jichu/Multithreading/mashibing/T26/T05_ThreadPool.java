package jichu.Multithreading.mashibing.T26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的概念（一堆线程，装在某个容器中，等待你来运行）
 *
 * @Author: liangxiao
 * @Date: Created in 10:23 2018/10/14
 */
public class T05_ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            service.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);

        service.shutdown();
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);

        TimeUnit.SECONDS.sleep(5);
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
    }
}

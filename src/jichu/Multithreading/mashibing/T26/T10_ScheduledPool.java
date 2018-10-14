package jichu.Multithreading.mashibing.T26;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时器线程池，一般可以替代我们的Timer
 * Timer每次是new一个新的线程
 * 以固定的频率来执行某个任务
 *
 * @Author: liangxiao
 * @Date: Created in 14:20 2018/10/14
 */
public class T10_ScheduledPool {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        service.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }, 0, 500, TimeUnit.MILLISECONDS);
    }
}

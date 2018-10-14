package jichu.Multithreading.mashibing.T26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 新来一个任务，没有空闲线程，则新建一个线程，只到系统能承受的最大线程数，大概几万个
 * 当一个线程空闲1分钟（默认），就会被销毁，所以有个生存周期，也可以自己指定
 *
 * @Author: liangxiao
 * @Date: Created in 11:59 2018/10/14
 */
public class T08_CachedPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);

        for (int i = 0; i < 2; i++) {
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
        TimeUnit.SECONDS.sleep(80);//默认60秒线程会销毁
        System.out.println(service);
    }
}

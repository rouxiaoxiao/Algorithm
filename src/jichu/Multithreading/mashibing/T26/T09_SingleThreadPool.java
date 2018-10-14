package jichu.Multithreading.mashibing.T26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 保证任务的前后顺序
 * @Author: liangxiao
 * @Date: Created in 13:51 2018/10/14
 */
public class T09_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            service.execute(() -> {
                System.out.println(j + " " + Thread.currentThread().getName());
            });
        }
    }
}

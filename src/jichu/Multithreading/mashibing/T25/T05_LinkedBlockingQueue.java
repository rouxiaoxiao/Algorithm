package jichu.Multithreading.mashibing.T25;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liangxiao
 * @Date: Created in 20:17 2018/10/13
 */
public class T05_LinkedBlockingQueue {
    static BlockingDeque<String> strs = new LinkedBlockingDeque<>();
    static Random r = new Random();

    public static void main(String[] args) {
        //一个生产者线程
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    strs.put("a" + i);//如果满了就会等待
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "p1").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (; ; ) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "take" + strs.take());//如果空了就会等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "c" + i).start();
        }
    }
}

package jichu.Multithreading.mashibing.T25;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWrite读没有加锁，因为CopyOnWrite是不会出现脏读的
 * 写时复制，多线程环境下，读的效率会很高，但是写的效率非常低
 * 适合多读少写的环境
 *
 * @Author: liangxiao
 * @Date: Created in 10:11 2018/10/13
 */
public class T02_CopyOnWriteList {
    public static void main(String[] args) {
        List<String> lists = new CopyOnWriteArrayList<>();
        Random r = new Random();
        Thread[] ths = new Thread[100];
        for (int i = 0; i < ths.length; i++) {
            Runnable task = new Runnable() {
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        lists.add("a" + r.nextInt(100000));
                        System.out.println(Thread.currentThread().getName() + i);
                    }
                }
            };
            ths[i] = new Thread(task);
        }
        runAndComputeTime(ths);
        System.out.println(lists.size());
    }

    static void runAndComputeTime(Thread[] ths) {
        long s1 = System.currentTimeMillis();
        Arrays.asList(ths).forEach(t -> t.start());
        Arrays.asList(ths).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long s2 = System.currentTimeMillis();
        System.out.println(s2 - s1);
    }
}
